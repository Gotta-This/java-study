package com.guo.base;

public class Demo08 {
    //一个类中不只能定义main方法，还可以定义其他方法
    //除了定义方法，还可以定义一些属性(可以理解为变量)

    //类变量   static 类型 变量名 = 值;
    static double salary = 2500;

    //实例变量：从属于对象
    //如果不进行初始化，这个变量的值会被赋予默认值
    //所有数字的初始化值都为0或0.0，所有字符串变量初始化为十六位的u0000，布尔值默认是false
    //除了基本类型，其余的默认值都是null
    String name;
    int age;

    //main方法
    public static void main(String[] args) {
        //局部变量：main方法大括号结束就失效了
        //        必须声明变量和初始化值
        int i = 10;
        System.out.println(i);

        //变量类型  变量名字 = new com.guo.base.Demo08;
        Demo08 demo08 = new Demo08();
        System.out.println(demo08.age);//0
        System.out.println(demo08.name);//null

        //类变量 static
        System.out.println(salary);
    }

    //其他方法
    public void add(){
        //System.out.println(i);
        //由于i是main中定义的局部变量，在其他方法中不生效
    }
}
