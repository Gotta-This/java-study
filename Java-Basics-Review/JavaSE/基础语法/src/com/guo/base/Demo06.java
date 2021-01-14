package com.guo.base;

public class Demo06 {
    public static void main(String[] args) {
        //操作比较大的数的时候，注意溢出的问题
        //JDK7新特性，数字之间可以使用下划线分割，但不会输出下划线
        int money = 1000000000;
        int years = 20;
        int total = money*years;//本来应该是200亿，但在计算的时候溢出了
        System.out.println(total);//是个负数

        //改用long输出
        long total2 = money*years;
        System.out.println(total2);//还是那个负数

        //定义的money和years是int型的，计算结束后还是int类型
        //计算结束之后才转换成了long类型，转换之前就已经存在问题了

        //解决问题
        long total3 = money*((long)years);
        System.out.println(total3);//成功输出200亿


    }
}
