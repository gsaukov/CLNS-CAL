package org.clnscal.core.controller.calculator;

import org.clnscal.core.service.XxxxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    public XxxxxService service;

    @GetMapping("/v1/calculator")
    public MessageResponse calculator(@RequestParam(value = "start") String userId,
                                         @RequestParam(value = "end") String itemId) {
        MessageResponse response = service.calculate(userId, itemId);
        return response;
    }

}
