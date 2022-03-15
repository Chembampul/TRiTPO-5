package com.example.lab1_cpp.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FibonacciCalculationControllerTest {

    @Autowired
    FibonacciCalculationController fibonacciCalculationController;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesFibonacciCalculationController() {
        ServletContext servletContext = context.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(context.getBean("fibonacciCalculationController"));
    }

    @Test
    public void calculateFibonacci_successfulResult_correctRequest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/calculation/?position=9"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value("34"))
                .andReturn();

        Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void calculateFibonacci_badRequest_wrongParamName() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/calculation/?wrongParamName=9"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message")
                        .value("Required request parameter 'position' for method parameter type int is not present"))
                .andReturn();

        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void calculateFibonacci_badRequest_wrongParamType() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/calculation/?position=string"))
                .andDo(print()).andExpect(status().isBadRequest()).andExpect(jsonPath("$.message")
                        .value("Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: \"string\""))
                .andReturn();

        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void calculateFibonacci_badRequest_positionLessThanZero() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/calculation/?position=-1"))
                .andDo(print()).andExpect(status().isBadRequest()).andExpect(jsonPath("$.message")
                        .value("calculation.position: must be greater than or equal to 0"))
                .andReturn();

        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void calculateFibonacci_badRequest_positionGreaterThanHundred() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/calculation/?position=101"))
                .andDo(print()).andExpect(status().isBadRequest()).andExpect(jsonPath("$.message")
                        .value("calculation.position: must be less than or equal to 100"))
                .andReturn();

        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void calculateFibonacci_successfulResult_correctRequest_2() {
        int actual = fibonacciCalculationController.calculation(9).getValue();
        int expected = 34;
        assertEquals(expected, actual);
    }
}