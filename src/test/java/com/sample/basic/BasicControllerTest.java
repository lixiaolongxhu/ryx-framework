package com.sample.basic;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import javax.annotation.Resource;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import com.framework.core.vo.ResultVo;
import com.sample.mvc.service.TestService;


//@ContextConfiguration(locations = { "classpath:spring/spring-*.xml", "file:src/main/webapp/WEB-INF/spring-servlet.xml"  }) 
@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration  
@ContextConfiguration(locations = { "classpath:spring/applicationContext-*.xml" })  
@TransactionConfiguration(defaultRollback = true)  
@Transactional 
public class BasicControllerTest {
	public static final Logger LOG = LoggerFactory.getLogger(BasicControllerTest.class);

	@Resource  
    public WebApplicationContext wac;  
  
	public MockMvc mockMvc;  
    
    public MockHttpSession mockHttpSession = new MockHttpSession();
    
    
    @Resource
    public TestService  testService;
    
   
    
    @BeforeClass
    public static void init(){ 
//    	Env.unitTest = true;
    }
    
    @After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
    public static void destroy(){
//    	Env.unitTest = false;
    }
    
    @Before
	public void setUp() throws Exception {
       
    	LOG.debug("BasicControllerTest 单元测试  初始");
        this.mockMvc = webAppContextSetup(this.wac).build();
      
    }
   
	
	@Test
	public void  initTest() throws Exception{
		
		mockMvc.perform(
				(post("/test/cache.service"))
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
