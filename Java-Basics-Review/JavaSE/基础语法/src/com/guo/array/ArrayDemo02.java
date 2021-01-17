package com.guo.array;

public class ArrayDemo02 {
    public static void main(String[] args) {
        //静态初始化
        int[] a = {1,2,3,4,5,6,7,8};
        System.out.println(a[0]);

        //动态初始化，包括默认初始化
        int[] b = new int[10];
        b[0] = 10;
        System.out.println(b[0]);
        //下面的没有初始化，但是有一个默认值，就叫默认初始化
        System.out.println(b[1]);
        System.out.println(b[2]);
        System.out.println(b[3]);
    }
}
