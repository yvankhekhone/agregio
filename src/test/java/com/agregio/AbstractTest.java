package com.agregio;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = Agregio.class)
@TestPropertySource(
		  locations = "classpath:application-test.properties")
public abstract class AbstractTest {

}
