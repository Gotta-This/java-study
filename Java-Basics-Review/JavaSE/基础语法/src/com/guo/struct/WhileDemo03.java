package com.guo.struct;

public class WhileDemo03 {
    public static void main(String[] args) {
        //计算1+2+3+...+100=？

        int sum = 0;
        int i = 0;

        while (i<=100){
            sum = sum + i;//sum += i
            i++;
        }
        System.out.println(sum);
    }
}
