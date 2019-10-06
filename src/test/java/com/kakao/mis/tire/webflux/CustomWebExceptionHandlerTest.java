package com.kakao.mis.tire.webflux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@WebFluxTest(value = {GreetingHandler.class, GreetingRouter.class, UserHandler.class,
  CustomWebExceptionHandler.class})
public class CustomWebExceptionHandlerTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void handleIllegalStateException() {
    webTestClient
      .get()
      .uri("/hello")
      .exchange()
      .expectStatus().isOk();
  }

  @Test
  public void handle() {
    webTestClient
      .get()
      .uri("/hello2")
      .exchange()
      .expectStatus().is5xxServerError();
  }

}