package com.maven.playground;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Claire on 4/29/17.
 */
@RestController
public class PagesController {

    @GetMapping("/math/pi")
    public String piCalculated() {
        return "3.14159";
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String volumeCaclulator(@PathVariable int length,
                                   @PathVariable int width,
                                   @PathVariable int height) {
        MathService mc = new MathService();
        return mc.getVolume(length, width, height);
    }

    @GetMapping("/math/calculate")
    public String mathStuff(@RequestParam(value="operation", defaultValue="add") String operation,
                         @RequestParam("x") String firstNumber,
                         @RequestParam("y") String secondNumber) {
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