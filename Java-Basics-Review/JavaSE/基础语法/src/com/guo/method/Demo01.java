package com.guo.method;

public class Demo01 {
    //main 方法
    public static void main(String[] args) {
        //实参，把a,b传递进去了
        int sum = add(1, 2);
        System.out.println(sum);
        //forDemo();
    }

    //加法方法
    //形式参数，用来定义作用的
    public static int add(int a, int b){
        return a+b;
    }
    public static void forDemo(){
    //练习2：用while或for循环输出1-1000之间能被5整除的数，并且每行输出3个
        for (int i = 0; i <= 1000; i++) {
        if(i%5==0){
            System.out.print(i+"\t");
        }
        if(i%(5*3)==0){
            System.out.println();
            //System.out.print("\n");
        }
        }
    }

}