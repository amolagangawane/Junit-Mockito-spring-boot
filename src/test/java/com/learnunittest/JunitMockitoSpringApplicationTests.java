package com.learnunittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitMockitoSpringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test1(){
		Assertions.assertEquals(0,0);
	}
	@Test
	void test2(){
		Assertions.assertEquals(0,1);
	}
	@Test
	void test4(){
		Assertions.assertEquals(0,0);
	}

}
