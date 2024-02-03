package com.example.jenkinspractice.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator=new Calculator();

    @Test
    public void CalculatorTest() throws Exception {
        Assertions.assertEquals(5,calculator.sum(3,2));
    }
}