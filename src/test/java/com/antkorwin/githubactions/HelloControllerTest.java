package com.antkorwin.githubactions;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void hello() {
		webTestClient.get()
		             .uri("/test")
		             .exchange()
		             .expectStatus()
		             .isOk()
		             .expectBody(String.class)
		             .isEqualTo("Hello World!");
	}
}