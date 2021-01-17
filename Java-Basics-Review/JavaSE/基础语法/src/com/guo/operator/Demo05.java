package com.guo.operator;

//逻辑运算符
public class Demo05 {
    public static void main(String[] args) {
        //  逻辑运算符就是与或非
        //  与(and)   或(or)    非(not)
        boolean a = true;
        boolean b = false;

        System.out.println("a && b："+(a&&b));//逻辑与运算，两个变量都为真，结果才为真
        System.out.println("a || b："+(a||b));//逻辑或运算，两个变量有一个为真，结果都为真
        System.out.println("!(a && b)："+(!(a && b)));//如果是真则为假，如果是假则为真

        //短路运算
        //在与运算中，需要两个变量都为真，结果才为真
        //但是如果前面那个变量为假，后面语句就不会进行，直接输出假
        int c = 5;
        boolean d = (c<4&&(c++<4));
        System.out.println(d);//false
        System.out.println(c);//5
        //这里c<4为false，c++<4为true
        //第二句话把c输出，如果c = 6，那么证明不会短路
        //如果c = 5，那么证明会短路
        //结果为5，说明当a&&b时，如果a = false ,则a后的式子不会运算
    }
}
