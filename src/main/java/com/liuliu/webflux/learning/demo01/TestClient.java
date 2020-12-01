package com.liuliu.webflux.learning.demo01;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class TestClient {

    private static final Logger log = LoggerFactory.getLogger(TestClient.class);

    public static void main(String[] args) {
        WebClient client = WebClient.create("http://localhost:8080/");
        Mono<Person> result = client.post()
                .uri("persion/getPersion/{id}.json", "123")
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToMono(Person.class);
        Person person = result.block();
        log.info(JSONObject.wrap(person).toString());
    }

}
