package co.kr.spring.validation.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ValidationControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(new ValidationController()).alwaysExpect(status().isOk()).build();
    }


    @Test
    public void validateSuccess() throws Exception {
        this.mockMvc.perform(get("/validate?number=10&date=2029-07-04"))
                .andExpect(content().string("No errors"))
                .andDo(print());
    }

    @Test
    public void validateErrors() throws Exception {
        this.mockMvc.perform(get("/validate?number=3&date=2010-07-01"))
                .andExpect(content().string("Object has validation errors"))
                .andDo(print());
    }

}