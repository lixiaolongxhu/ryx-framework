package com.sample.webmagic;

import java.util.Map;

import org.springframework.scheduling.config.Task;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.pipeline.Pipeline;

public class ConsolePipeline  implements Pipeline {
	

	@Override
	public void process(ResultItems resultItems, us.codecraft.webmagic.Task task) {
		    System.out.println("自定义控制台输出 get page: " + resultItems.getRequest().getUrl());
	        //遍历所有结果，输出到控制台，上面例子中的"author"、"name"、"readme"都是一个key，其结果则是对应的value
	        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
	            System.out.println(""+entry.getKey() + ":\t" + entry.getValue());
	        }
		
	}

	
}