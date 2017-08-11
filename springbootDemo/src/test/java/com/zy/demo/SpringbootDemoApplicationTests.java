package com.zy.demo;

import org.springframework.http.MediaType;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class SpringbootDemoApplicationTests {

	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		this.mockMvc=MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	
	@Test
	public void getHelloController() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect((ResultMatcher) content().string(equalTo("hello")));
	}
	
	@Test
	public void contextLoads() {
		final int a = 10;
		int[] num = new int[a];
		num[0] = 1;

		for (int i = 1; i != a; i++) {
			for (int j = 0; j != i; j++) {
				System.out.print(num[j] + " ");
			}
			System.out.println();
			num[i] = 1;

			for (int j = i - 1; j != 0; j--) {
				num[j] = num[j] + num[j - 1];
			}
		}
	}

}
