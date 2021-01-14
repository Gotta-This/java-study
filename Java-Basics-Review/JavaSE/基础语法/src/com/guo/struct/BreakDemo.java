package com.guo.struct;

public class BreakDemo {
    public static void main(String[] args) {
        int i = 0;
        while (i<100){
            i++;
            System.out.println(i);
            if(i==30){
                break;//当i为30时中断当前语句
            }
        }
        System.out.println("这里证明，只是循环结束了，程序还是往下走！！");
    }
}
