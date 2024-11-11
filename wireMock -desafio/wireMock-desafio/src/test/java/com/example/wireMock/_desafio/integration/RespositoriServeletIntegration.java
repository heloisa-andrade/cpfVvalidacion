package com.example.wireMock._desafio.integration;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@WireMockTest(httpPort = 8081)
public class RespositoriServeletIntegration {
}
