package com.example.hotel.utils;

import java.math.BigDecimal;

public class Test {


    public static void main(String[] args) {
        // 可参考下面代码：
        //加法：add
        //减法：subtract
        // 乘法：multiply
        //除法：divide
        BigDecimal bignum1 = new BigDecimal("10");
        BigDecimal bignum2 = new BigDecimal("5");
        BigDecimal bignum3 = null;
        //加法
        bignum3 = bignum1.add(bignum2);
        System.out.println("求和：" + bignum3);
        //减法
        bignum3 = bignum1.subtract(bignum2);
        System.out.println("求差：" + bignum3);
        //乘法
        bignum3 = bignum1.multiply(bignum2);
        System.out.println("乘法积：" + bignum3);
        //除法
        bignum3 = bignum1.divide(bignum2);
        System.out.println("除法结果：" + bignum3);
    }
}
