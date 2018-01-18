package com.boxin.base.manage.web.controller.auth;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zy on 2015/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class AuthControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    @Rollback
    public void testFindUserAuth() throws  Exception{
        //测试插入用户认证数据
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=UTF-8");
        this.mockMvc.perform(post("/auth/findUserAuth")
                .accept(mediaType)
                //.param("realname", "nami")
                .param("page", "1")
                .param("rows", "10")
                .param("status", "0")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Rollback
    public void testUpdateUserAuth() throws Exception{
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=UTF-8");
        this.mockMvc.perform(post("/auth/updateUserAuth")
                        .accept(mediaType)
                        .param("ids", "2")
                        .param("uids", "9")
                        .param("status", "1")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Rollback
    public void testFindOrgAuth() throws  Exception{
        //测试插入用户认证数据
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=UTF-8");
        this.mockMvc.perform(post("/auth/findOrgAuth")
                        .accept(mediaType)
                        .param("realname", "")
                        .param("page", "1")
                        .param("rows", "10")
                        .param("status", "0")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Rollback
    public void testUpdateOrgAuth() throws Exception{
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=UTF-8");
        this.mockMvc.perform(post("/auth/updateOrgAuth")
                        .accept(mediaType)
                        .param("ids", "2")
                        .param("uids", "5")
                        .param("status", "1")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();




    }

}
