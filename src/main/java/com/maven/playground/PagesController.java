package com.maven.playground;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Claire on 4/29/17.
 */
@RestController
public class PagesController {

    @GetMapping("/math/calculate")
    public String mathStuff(@RequestParam(value="operation", defaultValue="add") String operation,
                         @RequestParam("x") String firstNumber,
                         @RequestParam("y") String secondNumber
    ) {
        MathService mc = new MathService();
        mc.setOperation(operation);
        mc.setFirstNumber(Integer.parseInt(firstNumber));
        mc.setSecondNumber(Integer.parseInt(secondNumber));
        return mc.calculate();
    }

    @PostMapping("/math/sum")
    public String addIt(@RequestParam("n") String[] queryString){
        MathService mc = new MathService();
        return mc.getSum(queryString);
    }
}