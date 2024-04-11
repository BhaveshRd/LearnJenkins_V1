package com.learnJenkins.LearnJenkins_V1;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LearnJenkinsV1ApplicationTests {

	Logger loggerFactory = LoggerFactory.getLogger( LearnJenkinsV1ApplicationTests.class);
	@Test
	void contextLoads() {

		loggerFactory.info("test my first test case-------->");
		assertEquals(true, true);
	}

}
