package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private ApplicationContext ctx;

	@Test
	void first() {
		System.out.println(getDemoBean().getId());
	}

	@Test
	void second() {
		System.out.println(getDemoBean().getId());
	}

	@Test
	void third() {
		System.out.println(getDemoBean().getId());
	}

	private DemoBean getDemoBean() {
		return ctx.getBean("demoProxy", DemoBean.class);
	}
}
