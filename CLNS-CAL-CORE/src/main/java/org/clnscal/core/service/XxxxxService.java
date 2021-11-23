package org.clnscal.core.service;

import org.clnscal.core.controller.calculator.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
//@CircuitBreaker(name = "circuitService") //it will throw CallNotPermittedException without entering the method. Exceptions will be caught in error controller.
public class XxxxxService {

    private static final Logger LOG = LoggerFactory.getLogger(XxxxxService.class);

    @Autowired
    WebClient webClient;

    public Mono<MessageResponse> calculate(String userId, String itemId) {
        var user = getUser(userId);
        var item = getItem(itemId);
        return Mono.zip(user, item).flatMap(zip -> Mono.just(
                new MessageResponse.Builder().withMessage(zip.getT1() + ", " + zip.getT2()).build()
        ));
    }

    public Mono<String> getUser(String id) {
        return webClient.get()
                .uri("/api/v1/pakettypes/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getItem(String id) {
        return webClient.get()
                .uri("/api/v1/pakettypes/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

}
