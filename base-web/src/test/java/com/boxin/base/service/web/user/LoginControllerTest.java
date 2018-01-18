package com.boxin.base.service.web.user;

import com.boxin.base.webmodel.UserConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zy on 2015/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class LoginControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private UserConfig userConfig;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        //测试session
        userConfig = UserConfig.newInstance();
        userConfig.setStatus(UserConfig.USER_STATUS_LOGINED);
        userConfig.setLoginError(0);
      /*  User user = new User();
        user.setName("2222");
        userConfig.addUserInfo("user",user);*/
    }

    @Test
    public void testIsLogin()throws Exception{
        //测试是否需要登陆
        this.mockMvc.perform(get("/user/loginStatus")
            .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
            .sessionAttr("_USERCONFIG", userConfig)
            )
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
    }

    @Test
    public void testGetVerifyCode()throws Exception{
        //测试获取验证码
        this.mockMvc.perform(get("/public/verifycode.png")
            .accept(MediaType.parseMediaType("text/html"))
            )
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
    }

    @Test
    public void testNeedCode()throws Exception{
        this.mockMvc.perform(get("/user/needVerify")
            .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                        .sessionAttr("_USERCONFIG", userConfig)
        )
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
    }

    @Test
    public void checkLogin() throws Exception {
        //测试登陆
        this.mockMvc.perform(post("/user/login")
            .param("username", "3323497@qq.com")
            .param("password", "123456")
            .sessionAttr("_USERCONFIG", userConfig)
            )
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();

    }



    @Test
    @Rollback
    public void testGetUserInfo()throws Exception{
        this.mockMvc.perform(get("/user/getUserInfo.json")
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                        .sessionAttr("_USERCONFIG", userConfig)
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


}
