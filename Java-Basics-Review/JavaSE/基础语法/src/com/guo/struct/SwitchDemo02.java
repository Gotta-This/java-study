package com.guo.struct;

public class SwitchDemo02 {
    public static void main(String[] args) {
        String name = "郭鹏飞";

        //JDK7的新特性，表达式结果可以是字符串！！！
        //字符的本质还是数字

        switch (name){
            case "郭鹏飞":
                System.out.println("郭鹏飞");
                break;
            case "厉害":
                System.out.println("厉害");
                break;
            default:
                System.out.println("弄啥嘞！");
        }
    }
}
