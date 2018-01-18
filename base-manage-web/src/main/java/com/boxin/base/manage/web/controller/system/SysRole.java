package com.boxin.base.manage.web.controller.system;

import com.boxin.base.common.util.JsonUtil;
import com.boxin.base.common.util.StringUtil;
import com.boxin.base.common.util.WebUtil;
import com.boxin.base.service.manage.user.RoleService;
import com.boxin.base.webmodel.GridData;
import com.boxin.base.model.ManageRole;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 此类为角色设置操作类
 * Created by zy on 2015/4/25.
 */
@Controller
public class SysRole {

    Log logger = LogFactory.getLog(SysRolePermission.class);
    @Autowired
    private RoleService roleServic;

    /**
     * 查询所有角色数据
     * @return
     */
    @RequestMapping(value="/sys/findAllRoles",method = RequestMethod.GET)
    public void findAllRoles(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<ManageRole> listRole = null;
        List<ManageRole> listRoles = null;
        GridData gridData = GridData.newInstance();
        
        try {
        	String pages = request.getParameter("page");
        	int page = Integer.parseInt((pages == null || pages == "0") ? "1":pages);
        	String rowNumber = request.getParameter("rows");
        	int rows = Integer.parseInt((rowNumber == null || rowNumber == "0") ? "10":rowNumber);
        	listRole = roleServic.findAllRoles();
        	listRoles = roleServic.findAllRoles(page,rows);
            gridData.setAsSuccess();
            gridData.setTotalCount(listRole.size());
            gridData.addMeta("rows", listRoles);
        } catch (Exception e) {
            gridData.setAsFailure();
        }
        WebUtil.write(response, JsonUtil.obj2JsonObj(gridData));
    }

    /**
     * 插入角色数据
     * @param request
     * @return
     */
    @RequestMapping(value="/sys/insertRole",method = RequestMethod.POST)
    public @ResponseBody String insertRole(HttpServletRequest request){
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        ManageRole manageRole = new ManageRole();

        if(StringUtils.isEmpty(name)|| StringUtil.isEmpty(code)){
            resultMap.put("message","角色名称或代码不能为空");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }

        manageRole.setCode(code.trim());
        manageRole.setName(name);
        manageRole.setDescription(description.trim());
        manageRole.setStatus(1);
        manageRole.setCreateTime(new Date());

        int result = 0;
        try {
            result = roleServic.insert(manageRole);
        } catch (Exception e) {
            resultMap.put("message","插入数据库出错");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(result == 1){
            resultMap.put("state","success");
        }else{
            resultMap.put("message","插入数据失败");
            resultMap.put("state","fail");
        }
        return JsonUtil.map2Json(resultMap);
    }

    /**
     * 更新角色
     * @param request
     * @return
     */
    @RequestMapping(value="/sys/updateRole",method = RequestMethod.POST)
    public @ResponseBody String updateRole(HttpServletRequest request){
        String sid = request.getParameter("id");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String sstatus = request.getParameter("status");

        Map<String,Object> resultMap = new HashMap<String, Object>();
        ManageRole manageRole = new ManageRole();

        //数据校验
        if(StringUtils.isEmpty(name)|| StringUtil.isEmpty(code)){
            resultMap.put("message","角色名称或代码不能为空");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(StringUtils.isEmpty(description)){
            description = "";
        }
        int status = Integer.parseInt(sstatus);
        if(status !=0 && status != 1){
            resultMap.put("message","提交参数错误，请重新操作");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        long id = Long.parseLong(sid);
        manageRole.setId(id);
        manageRole.setName(name);
        manageRole.setCode(code);
        manageRole.setDescription(description);
        manageRole.setModifyTime(new Date());
        manageRole.setStatus(status);

        boolean result = false;
        try {
            result = roleServic.updateByPrimaryKeySelective(manageRole);
        } catch (Exception e) {
            resultMap.put("message","更新数据库出错");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(result){
            resultMap.put("state","success");
        }else{
            resultMap.put("message","更新数据失败");
            resultMap.put("state","fail");
        }
        return JsonUtil.map2Json(resultMap);
    }

    /**
     * 获取可用角色
     * @return
     */
    @RequestMapping(value = "/sys/findEnableRoles",method = RequestMethod.POST)
    public @ResponseBody String findEnableRoles(){
        List<ManageRole> manageRoleList = null;
        try {
            manageRoleList = roleServic.findEnableRoles();
        } catch (Exception e) {
            return null;
        }
        String rolelist = JsonUtil.list2Json(manageRoleList);
        rolelist = rolelist.replace("name","text");
        return rolelist;
    }


}
