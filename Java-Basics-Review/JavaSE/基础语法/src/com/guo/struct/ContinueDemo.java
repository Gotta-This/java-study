package com.guo.struct;

public class ContinueDemo {
    public static void main(String[] args) {
        int i =0;
        while (i<100){
            i++;
            if(i%10==0){//当i为10的倍数时，跳过这个10
                System.out.println();
                continue;
            }
            System.out.println(i);
        }
        //break在任何循环语句的主体部分，均可用break控制循环的流程。break用于强行退出循环，不执行循环中剩余的语句。
        //break 语句也在switch语句中使用

        //continue  语句用在循环语句体重，用于终止某次循环过程，即跳过循环体中尚未执行的语句，接着进行下一次是否执行循环的判定。
    }
}
