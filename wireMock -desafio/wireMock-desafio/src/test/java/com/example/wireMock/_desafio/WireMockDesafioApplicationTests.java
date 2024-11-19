package com.example.wireMock._desafio;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
@WireMockTest(httpPort = 8080)
class WireMockDesafioApplicationTests {

    @Test
    public void testGetMappingResponse() {
        // Configurando um mapping no WireMock
        WireMock.stubFor(get(urlPathEqualTo("/info?cpf"))
                .withQueryParam("", equalTo("123"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"message\": \"Response from mapping!\", \"id\": \"123\"}")));

        // Fazendo uma requisição simulada
        WebClient webClient = WebClient.create("http://localhost:8080");
        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/example")
                        .queryParam("id", "123")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Imprimindo a resposta para validação
        System.out.println(response);

        // Verificando se o WireMock registrou a requisição simulada
        WireMock.verify(getRequestedFor(urlPathEqualTo("/api/example"))
                .withQueryParam("id", equalTo("123")));
    }
}
