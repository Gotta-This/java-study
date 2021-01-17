package com.guo.operator;

public class Demo04 {
    public static void main(String[] args) {
        //一元运算符
        // ++  --  是自增自减
        int a = 3;//a的初始值是3
        int b = a++;//a++相当于 a = a + 1;
        //执行完这行代码后，先给b赋值，再自增
        System.out.println(a);//4
        //a++执行后才会+1

        int c = ++a;
        //执行这行代码钱，先给a自增，再给c赋值输出


        System.out.println(a);//5
        System.out.println(b);//3
        System.out.println(c);//5


        //幂运算  2^3 = 2*2*2 = 8
        //很多运算，我们会使用一些工具类来操作！
        //Math类提供了很多科学工程计算需要的方法
        double pow = Math.pow(2, 3);
        System.out.println(pow);
    }
}
