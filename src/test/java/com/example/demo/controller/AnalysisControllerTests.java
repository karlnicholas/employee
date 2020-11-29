package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.AnalysisService;

@WebMvcTest(AnalysisController.class)
class AnalysisControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean AnalysisService analysisService;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		SummaryStatistics summaryStatistics = new SummaryStatistics();
		summaryStatistics.addValue(10.0);
		doReturn(summaryStatistics).when(analysisService).getSummaryStatistics();
		this.mockMvc.perform(get("/analysis")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"n\":1")));
	}
}
