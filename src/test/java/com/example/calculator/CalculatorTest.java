package com.example.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator=new Calculator();
    
    @Test
    public void sum() {
        Assertions.assertEquals(5,calculator.sum(2,3));
    }
}