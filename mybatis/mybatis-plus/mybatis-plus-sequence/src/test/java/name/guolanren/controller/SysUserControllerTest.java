package name.guolanren.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author 郭耀展
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Transactional
    @Rollback
    public void whenCreateSuccess() throws Exception {
        String content = "{\"name\":\"丁\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/sysUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.gmtCreate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.gmtModified").exists())
                .andDo(mvcResult -> {
                    String result = mvcResult.getResponse().getContentAsString();
                    Long gmtCreate = JsonPath.parse(result).read("$.gmtCreate");
                    Long gmtModified = JsonPath.parse(result).read("$.gmtModified");
                    Assert.assertTrue(gmtCreate.equals(gmtModified));
                });
    }

    @Test
    @Transactional
    @Rollback
    public void whenModifySuccess() throws Exception {
        String content = "{\"id\":1,\"name\":\"丁\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/sysUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/sysUser/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.gmtCreate").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.gmtModified").exists())
                .andDo(mvcResult -> {
                    String result = mvcResult.getResponse().getContentAsString();
                    Long gmtCreate = JsonPath.parse(result).read("$.gmtCreate");
                    Long gmtModified = JsonPath.parse(result).read("$.gmtModified");
                    Assert.assertTrue(gmtModified.compareTo(gmtCreate) > 0);
                });
    }

}
