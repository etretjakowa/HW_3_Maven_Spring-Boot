package ru.skypro.calculator.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    public final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/plus")
    public String sumNumbers(@RequestParam Integer num1, @RequestParam Integer num2){
        Integer result = calculatorService.sum(num1, num2);
        return showMessage(num1, num2, "+", result);
    }
    @GetMapping("/minus")
    public String minusNumbers(@RequestParam Integer num1, @RequestParam Integer num2){
        Integer result = calculatorService.minus(num1, num2);
        return showMessage(num1, num2, "-", result);
    }
    @GetMapping("/multiply")
    public String multiplyNumbers(@RequestParam Integer num1, @RequestParam Integer num2){
        Integer result = calculatorService.sum(num1, num2);
        return showMessage(num1, num2, "*", result);
    }


    @GetMapping("/divide")
            public String divideNumbers(@RequestParam Integer num1, @RequestParam Integer num2){
        if(num2 == 0){
            return "Второй аргумент = 0, на 0 делить нельзя!";
        }
        Integer result = calculatorService.divide(num1, num2);
        return showMessage(num1, num2, "/", result);
    }

    private String showMessage(Integer num1, Integer num2, String action,Integer result){
        return String.format("%d %s %d = %d ",num1, action, num2, result);
    }

}
