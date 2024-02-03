package com.example.calculator.calculator;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator=new Calculator();

    @Test
    public void CalculatorTest() throws Exception {
        Assertions.assertEquals(5,calculator.sum(3,2));
    }
}