package name.guolanren.controller;

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
 * @author guolanren
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
        mockMvc.perform(MockMvcRequestBuilders.post("/sys_users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.sysUserId").value("4"));
    }

    @Test
    @Transactional
    @Rollback
    public void whenCreateFailedCausedByInvalidParam() throws Exception {
        String content = "{}";
        mockMvc.perform(MockMvcRequestBuilders.post("/sys_users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("201"));
    }

    @Test
    @Transactional
    @Rollback
    public void whenRemoveSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/sys_users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/sys_users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").doesNotExist());
    }

    @Test
    @Transactional
    @Rollback
    public void whenRemoveFailedCausedByInvalidParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/sys_users/0")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(201));
    }

    @Test
    @Transactional
    @Rollback
    public void whenModifySuccess() throws Exception {
        String content = "{\"sysUserId\":1,\"name\":\"丁\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/sys_users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/sys_users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("丁"));
    }

    @Test
    public void whenGetByIdSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sys_users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("甲"));
    }

}
