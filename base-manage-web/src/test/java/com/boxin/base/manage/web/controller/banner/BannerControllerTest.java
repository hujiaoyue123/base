package com.boxin.base.manage.web.controller.banner;

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
 * Created by zy on 2015/5/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class BannerControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    @Rollback
    public void testInsertBanner() throws Exception{
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=UTF-8");

        this.mockMvc.perform(post("/banner/insertBannerImages")
                        .accept(mediaType)
                .param("imgName","测试图震12121没有2")
                .param("lang","0")
                .param("link","http://www.baidu.com")
                .param("sort","1")
                .param("status","1")
                .param("type","0")
                .param("url","application.ini")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Rollback
    public void testFindBanner() throws Exception{
        MediaType mediaType = MediaType.parseMediaType("application/json;charset=UTF-8");

        this.mockMvc.perform(post("/banner/findBannerImages")
                        .accept(mediaType)
                        .param("page", "1")
                        .param("rows", "10")
                        .param("status", "1")
        )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


}
