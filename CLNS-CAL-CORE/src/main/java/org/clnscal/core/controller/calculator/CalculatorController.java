package org.clnscal.core.controller.calculator;

import org.clnscal.core.service.XxxxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    public XxxxxService service;

    @GetMapping("/v1/calculator")
    public Mono<MessageResponse> calculator(@RequestParam(value = "userId") String userId,
                                            @RequestParam(value = "itemId") String itemId) {
        return service.calculate(userId, itemId);
    }

}
