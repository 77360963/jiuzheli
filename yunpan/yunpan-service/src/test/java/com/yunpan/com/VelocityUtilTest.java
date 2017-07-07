package com.yunpan.com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import www.yunpan.com.utils.ContentVelocityTemplate;
import www.yunpan.com.utils.VelocityUtil;

public class VelocityUtilTest {

	public static void main(String[] args) {
		  ApplicationContext c=new ClassPathXmlApplicationContext("/META-INF/spring/velocity-config.xml");
		  ContentVelocityTemplate template=(ContentVelocityTemplate)c.getBean("personalXmlTemplate");
         System.out.println("模板加载成功");
         Map<String,Object>  params=new HashMap<String,Object>();
         params.put("mercid", "xxxxxxxxxxxx");
         String context=VelocityUtil.getXmlData(template, params);
         System.out.println(context);
         
	}

}
