package com.example.sb0706.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getById() throws Exception {
        //  RequestBuilder決定設定的http request相關參數
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/students/{studentId}", 3)
                // 下面header和gueryParam不一定需要
                .header("headerName", "headerValue")
                .queryParam("graduate", "true");

        //  perform代表要執行http request，等同於發起http request
        //  因為perform方法會噴出exception，因此要Alt+ Enter(Add exception method)
        //  andExpect是驗證請求的結果
        mockMvc.perform(requestBuilder)
                // 可以看MockHttpServletRequest的細節(print可以將API結果印出)
                .andDo(print())
                .andExpect(status().is(200))
//              // 下面是指 想要取得json中哪個key的值($.id是指 外層的json object值)
                .andExpect(jsonPath("$.id", equalTo(3)))
                .andExpect(jsonPath("$.name", notNullValue()));
    }
    @Test
    public void create() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        " \"name\": \"Hank\",\n" +
                        " \"score\": 14.6,\n" +
                        " \"graduate\": false\n" +
                        "}");
        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201));
    }

}