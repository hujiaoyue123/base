package com.boxin.base.manage.web.controller.system;

import com.boxin.base.common.security.SimpleServicePermissionResource;
import com.boxin.base.common.util.JsonUtil;
import com.boxin.base.model.ManagePermission;
import com.boxin.base.service.manage.user.PermissionService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 此类为菜单及子功能操作类
 * Created by zy on 2015/4/22.
 */
@Controller
public class SysMenuFunction {

    Log logger = LogFactory.getLog(SysMenuFunction.class);

    @Autowired
    private PermissionService permissionService;

    /**
     * 获取所有菜单
     * @return
     */
    @RequestMapping(value="/sys/getAllMenu",method = RequestMethod.POST)
    public @ResponseBody String getAllMenu() {
        List<ManagePermission> mPermissionList = null;
        try {
            mPermissionList = permissionService.selectAllMenu();
        } catch (Exception e) {
            return null;
        }
        String menu = JsonUtil.list2Json(mPermissionList);
        menu = menu.replace("service:","");
        menu = menu.replace(".","/");
        menu = menu.replace("/list",".list");
        menu = menu.replace("/html",".html");
        menu = menu.replace("name","text");
        return menu;
    }

    /**
     * 插入菜单
     * @return
     */
    @RequestMapping(value="/sys/insertMenu",method = RequestMethod.POST)
    public @ResponseBody String insertMenu(HttpServletRequest request) {
        String pid = request.getParameter("pid");
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        String type = request.getParameter("type");
        String sort = request.getParameter("sort");

        Map<String,Object> resultMap = new HashMap<String, Object>();
        ManagePermission mp = new ManagePermission();
        //数据校验（pid不能为空，Name不能为空）
        if(StringUtils.isEmpty(pid)){
            resultMap.put("message","请先选中上级菜单");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(StringUtils.isEmpty(name)){
            resultMap.put("message","菜单名称不能为空");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }

        mp.setName(name);
        mp.setParentId(Long.parseLong(pid));
        mp.setType(Integer.parseInt(type));
        mp.setSort(Long.parseLong(sort));
        if(url.length()>0){
            if(url.startsWith("/")){
                url = url.substring(1,url.length());
            }
            url = url.replace("/",".");
            url = SimpleServicePermissionResource.SERVICE_PREFIX + url;
        }
        mp.setCode(url);

        boolean result = false;
        try {
            result= permissionService.insert(mp);
        } catch (Exception e) {
            resultMap.put("message","操作数据库失败");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(result){
            resultMap.put("state","success");
        }else{
            resultMap.put("message","操作失败请重新操作");
            resultMap.put("state","fail");
        }
        return JsonUtil.map2Json(resultMap);
    }

    /**
     * 删除子菜单
     * @param request
     * @return
     */
    @RequestMapping(value="/sys/deleteMenu",method = RequestMethod.POST)
    public @ResponseBody String deleteMenu(HttpServletRequest request){
        String id = request.getParameter("id");
        Map<String,Object> resultMap = new HashMap<String, Object>();

        //数据校验
        if(StringUtils.isEmpty(id)){
            resultMap.put("message","请选中菜单再进行删除操作");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }

        //判断是否存在子菜单，如果存在，不删除，否之可以。
        try {
            boolean hasChildNode = permissionService.hasChildNode(Long.parseLong(id));
            if(hasChildNode){
                resultMap.put("message","删除菜单失败");
                resultMap.put("state","fail");
            }else{
                boolean result = permissionService.deleteMenuById(Long.parseLong(id));
                if(result){
                    resultMap.put("state","success");
                }else{
                    resultMap.put("message","删除菜单失败");
                    resultMap.put("state","fail");
                }
            }
        } catch (Exception e) {
            resultMap.put("message","删除菜单失败");
            resultMap.put("state","fail");
        }
        return JsonUtil.map2Json(resultMap);

    }

    /**
     * 更新菜单
     * @param request
     * @return
     */
    @RequestMapping(value = "/sys/updateMenu",method = RequestMethod.POST)
    public @ResponseBody String updateMenu(HttpServletRequest request) {
        String sId = request.getParameter("id");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String sSort = request.getParameter("sort");
        String sType = request.getParameter("type");
        String sStatus = request.getParameter("status");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        ManagePermission managePermission = new ManagePermission();
        //数据校验 name,code不能为空
        if(StringUtils.isEmpty(name) ||StringUtils.isEmpty(code)){
            resultMap.put("message","菜单名或路径不能为空");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        Long id = Long.parseLong(sId);
        Long sort = Long.parseLong(sSort);
        Integer type = Integer.parseInt(sType);
        Integer status = Integer.parseInt(sStatus);
        if(id<0 || sort < 0 ){
            resultMap.put("message","菜单未选中或排序号为负值");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(type != 1 && type != 2){
            resultMap.put("message","提交参数错误，请重新操作");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(status !=0 && status != 1){
            resultMap.put("message","提交参数错误，请重新操作");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }

        managePermission.setName(name);
        managePermission.setSort(sort);
        managePermission.setType(type);
        managePermission.setStatus(status);
        if(code.length()>0){
            if(code.startsWith("/")){
                code = code.substring(1,code.length());
            }
            code = code.replace("/",".");
            code = SimpleServicePermissionResource.SERVICE_PREFIX + code;
        }
        managePermission.setCode(code);
        managePermission.setId(id);

        boolean result = false;
        try {
            result = permissionService.update(managePermission);
        } catch (Exception e) {
            resultMap.put("message","操作数据库失败");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(result){
            resultMap.put("state","success");
        }else{
            resultMap.put("message","更新菜单失败");
            resultMap.put("state","fail");
        }
        return JsonUtil.map2Json(resultMap);
    }

    /**
     * 加载子功能数据
     * @param request
     * @return
     */
    @RequestMapping(value="/sys/findFunction")
    public @ResponseBody String findFunction(HttpServletRequest request){
        String sPid = request.getParameter("pid");
        Map<String,Object> resultMap = new HashMap<String, Object>();

        //数据校验
        Long pid = Long.parseLong(sPid);
        if(pid <=0){
            resultMap.put("total","0");
            resultMap.put("rows","[]");
            return JsonUtil.map2Json(resultMap);
        }
        try {
            List<ManagePermission> mPermissionList = permissionService.findFunctionByPid(pid);
            resultMap.put("total",mPermissionList.size());
            resultMap.put("rows",mPermissionList);
        } catch (Exception e) {
            resultMap.put("total",0);
            resultMap.put("rows","[]");
        }
        String result = JsonUtil.map2Json(resultMap);
        result = result.replace("service:","");
        return result;


    }

    /**
     * 插入子功能
     * @param request
     * @return
     */
    @RequestMapping(value = "/sys/insertFunction",method = RequestMethod.POST)
    public @ResponseBody String insertFunction(HttpServletRequest request){
        String spid = request.getParameter("pid");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String sstatus = request.getParameter("status");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        ManagePermission managePermission = new ManagePermission();

        //数据校验
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(code)){
            resultMap.put("message","功能名称或代码不能为空");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        long pid = Long.parseLong(spid);
        if(pid < 0){
            resultMap.put("message","请选中菜单再进行操作");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        int status = Integer.parseInt(sstatus);
        if(status !=0 && status != 1){
            resultMap.put("message","开关参数设置错误");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(code.length()>0){
            if(code.startsWith("/")){
                code = code.substring(1,code.length());
            }
            code = code.replace("/",".");
            code = SimpleServicePermissionResource.SERVICE_PREFIX + code;
        }

        managePermission.setName(name);
        managePermission.setCode(code.trim());
        managePermission.setStatus(status);
        managePermission.setSort(0L);
        managePermission.setParentId(pid);
        managePermission.setType(2);     //2表示为功能类型，1是菜单

        boolean result = false;
        try {
            result = permissionService.insert(managePermission);
        } catch (Exception e) {
            resultMap.put("message","操作数据库失败");
            resultMap.put("state", "fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(result){
            resultMap.put("state","success");
        }else{
            resultMap.put("message","插入功能失败");
            resultMap.put("state","fail");
        }
        return JsonUtil.map2Json(resultMap);
    }

    /**
     * 更新子功能菜单
     * @param request
     * @return
     */
    @RequestMapping(value = "/sys/updateFunction",method = RequestMethod.POST)
    public @ResponseBody String updateFunction(HttpServletRequest request){
        String sid = request.getParameter("id");
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String sStatus = request.getParameter("status");

        Map<String,Object> resultMap = new HashMap<String, Object>();
        ManagePermission managePermission = new ManagePermission();

        //数据校验
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(code)){
            resultMap.put("message","功能名称或代码不能为空");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }

        Long id = Long.parseLong(sid);
        int status = Integer.parseInt(sStatus) ;
        if(id<0){
            resultMap.put("message","功能ID值不正确，请选中功能再操作");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(status !=0 && status != 1){
            resultMap.put("message","开关参数设置错误");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(code.length()>0){
            code = SimpleServicePermissionResource.SERVICE_PREFIX + code;
        }

        managePermission.setCode(code);
        managePermission.setName(name);
        managePermission.setStatus(status);
        managePermission.setId(id);
        managePermission.setType(2);
        managePermission.setSort(0L);

        boolean result = false;
        try {
            result = permissionService.update(managePermission);
        } catch (Exception e) {
            resultMap.put("message","操作数据库失败");
            resultMap.put("state", "fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(result){
            resultMap.put("state","success");
        }else{
            resultMap.put("message","更新功能失败");
            resultMap.put("state","fail");
        }
        return JsonUtil.map2Json(resultMap);
    }

    @RequestMapping(value = "/sys/deleteFunction",method = RequestMethod.POST)
    public @ResponseBody String deleteFunction(HttpServletRequest request){
        String id = request.getParameter("id");
        Map<String,Object> resultMap = new HashMap<String, Object>();

        //数据校验
        if(StringUtils.isEmpty(id)){
            resultMap.put("message","请选中功能再进行删除操作");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }

        boolean result = false;
        try {
            result = permissionService.deleteMenuById(Long.parseLong(id));
        } catch (Exception e) {
            resultMap.put("message","数据库操作失败");
            resultMap.put("state","fail");
            return JsonUtil.map2Json(resultMap);
        }
        if(result){
            resultMap.put("state","success");
        }else{
            resultMap.put("message","删除功能失败");
            resultMap.put("state","fail");
        }
        return JsonUtil.map2Json(resultMap);
    }
}
