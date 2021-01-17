package com.guo.method;

public class Demo02 {
    public static void main(String[] args) {
        int max = max(10,20);
        System.out.println(max);
    }

    //比大小
    public static int max(int num1,int num2){
        int result=0;//这里要初始化result 不然下面return会报错 因为没初始化
        if(num1==num2){
            System.out.println("num1=num2");
            return 0;//程序走到这里 方法结束
        }
        if(num1>num2) {
            result = num1;
        }else{
            result = num2;
        }
        return result;
    }
}
