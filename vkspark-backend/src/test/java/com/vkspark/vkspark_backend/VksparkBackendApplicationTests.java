package com.vkspark.vkspark_backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vkspark.vkspark_backend.security.JwtService;

@SpringBootTest
class VksparkBackendApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
JwtService jwtService;


public void test(){

System.out.println(
jwtService.generateToken("virat@gmail.com")
);

}
}
