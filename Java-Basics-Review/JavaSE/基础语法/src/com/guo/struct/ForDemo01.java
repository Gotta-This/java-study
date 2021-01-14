package com.guo.struct;

public class ForDemo01 {
    public static void main(String[] args) {
        int a = 1;//初始化条件

        while (a<100){//条件判断
            System.out.println(a);//循环体
            a += 2;//迭代  a = a + 2;
        }

        System.out.println("while循环结束！");

        //初始化//条件判断//迭代
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        System.out.println("for循环结束！");

        //快速生成 ： 100.for  回车
        for (int i = 0; i < 100; i++) {

        }

        /*
        关于for  循环有以下几点说明：
        最先执行初始化步骤。可以声明一种类型,但可初始化一个或多个循环控制变星,也可以是空语句。
        然后,检测布尔表达式的值。如果为true,循环体被执行。如果对aLse,循环终止,开始执行循环体后面的语句
        执行一次新环后,更新循环控制变量(送代因子控制循环变量的增减)
        再次检测布尔表达式。循环执行上面的过程。
         */

    }
}
