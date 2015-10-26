package com.sample.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.framework.core.vo.ResultVo;
import com.sample.basic.BasicControllerTest;

public class TestContrroller extends BasicControllerTest {

	@Test
	public void  queryOne() throws Exception{
		
		mockMvc.perform(
				(post("/test/queryOne.service"))
				.session(mockHttpSession)
				.param("token", "f20df78d-fc4d-4b90-95f6-d2db0935120c")
				)
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.status").value(ResultVo.RESPONSE_CODE_OK))
				.andExpect(jsonPath("$.r").value(Matchers.notNullValue()))
				.andExpect(jsonPath("$.msg").value(Matchers.notNullValue()));
	
		
	}
}
