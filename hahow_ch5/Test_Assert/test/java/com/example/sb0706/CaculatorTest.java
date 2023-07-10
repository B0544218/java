package com.example.sb0706;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaculatorTest {
    @Test
    public void test() {
        Caculator calculator = new Caculator();
        int result = calculator.add(1, 2);
        assertNotNull(result);
        assertEquals(3, result, "加法有問題");
        assertTrue(result > 1, "一定是正數");
    }
    @Test
    public void divideTest(){
        Caculator calculator = new Caculator();
        // 會噴出exception，因此這個 1 / 0的測試是成功的
        // 如果沒有throw error的狀況，在這邊會測試失敗
        assertThrows(ArithmeticException.class, ()->{
            calculator.divide(1, 0);
        });
    }
}