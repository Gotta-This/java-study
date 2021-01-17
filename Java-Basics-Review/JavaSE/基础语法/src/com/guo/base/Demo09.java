package com.guo.base;

public class Demo09 {

    //final, static......都是修饰符，不存在先后顺序
    final double PI = 3.14;
    static final int width = 600;
    final static int height = 300;
    public final static int i = 1;
    private final static char c = 'c';

    public static void main(String[] args) {
        //System.out.println(PI);//不是类变量无法使用
        System.out.println(width);
        System.out.println(height);
        System.out.println(i);
        System.out.println(c);
    }
}
