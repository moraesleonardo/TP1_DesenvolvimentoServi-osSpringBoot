package com.example.TP1Leonardo.Moraes.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
// Define a classe como um controlador REST, fazendo-a pronta para receber requisições HTTP.
@RestController
public class MathController {

    // Classe interna para definir a estrutura de dados que será recebida no corpo das requisições POST.
    static class NumbersInput {
        private double num1;
        private double num2;

        public double getNum1() {
            return num1;
        }

        public void setNum1(double num1) {
            this.num1 = num1;
        }

        public double getNum2() {
            return num2;
        }

        public void setNum2(double num2) {
            this.num2 = num2;
        }
    }
    // Lista contendo dois números pré-definidos que serão usados nas operações matemáticas nos métodos GET.
    private List<Double> numbers = Arrays.asList(10.0, 5.0);

    // Método para adicionar dois números, acessível via GET, que usa os números pré-definidos.
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public double add() {
        return numbers.get(0) + numbers.get(1);
    }

    // Método para subtrair dois números, acessível via GET.
    @RequestMapping(value = "/subtract", method = RequestMethod.GET)
    public double subtract() {
        return numbers.get(0) - numbers.get(1);
    }

    // Método para multiplicar dois números, acessível via GET.
    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public double multiply() {
        return numbers.get(0) * numbers.get(1);
    }

    // Método para dividir dois números, acessível via GET. Lança exceção se o divisor for zero.
    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public double divide() {
        if (numbers.get(1) == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numbers.get(0) / numbers.get(1);
    }
    // Método para calcular a potência de um número elevado ao outro, acessível via GET.
    @RequestMapping(value = "/power", method = RequestMethod.GET)
    public double power() {
        return Math.pow(numbers.get(0), numbers.get(1));
    }

    // Métodos POST que aceitam dois números através do corpo da requisição, utilizando o mesmo endpoint.
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public double add(@RequestBody NumbersInput input) {
        return input.getNum1() + input.getNum2();
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    public double subtract(@RequestBody NumbersInput input) {
        return input.getNum1() - input.getNum2();
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    public double multiply(@RequestBody NumbersInput input) {
        return input.getNum1() * input.getNum2();
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    public double divide(@RequestBody NumbersInput input) {
        if (input.getNum2() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return input.getNum1() / input.getNum2();
    }

    @RequestMapping(value = "/power", method = RequestMethod.POST)
    public double power(@RequestBody NumbersInput input) {
        return Math.pow(input.getNum1(), input.getNum2());
    }
}
