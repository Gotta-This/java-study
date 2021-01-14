package com.guo.base;

public class Demo04 {
    public static void main(String[] args) {
        //八大数据类型拓展
        //========================================
        /*
         * 整数拓展：
         * 进制：
         * 二进制       0b开头
         * 八进制
         * 十进制       0开头
         * 十六进制     0x开头
         * */
        int i = 10;
        int i2 = 010;   //八进制0
        int i3 = 0x10;  //十六进制0x

        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println("========================================");
        //========================================
        //浮点数拓展     银行业务怎么表示？钱
        //BigDecimal    数学工具类
        //========================================
        //float     有限  离散  舍入误差  大约  接近但不等于
        //double
        //最好完全避免使用浮点数进行比较
        //最好完全避免使用浮点数进行比较
        //最好完全避免使用浮点数进行比较

        float f = 0.1f;     //0.1
        double d = 1.0/10;  //0.1

        System.out.println(f==d);//false
        System.out.println(f);
        System.out.println(d);

        float d1 = 15665165165161f;
        float d2 = d1 + 1;

        System.out.println(d1==d2);//true

        System.out.println("========================================");
        //========================================
        //字符拓展
        //========================================
        //字符可以是英文字符也可以是中文字符
        char c1 = 'a';
        char c2 = '中';

        //可以把这两个字符给输出
        System.out.println(c1);
        System.out.println(c2);

        //也可以把这两个类型强制转换成int型
        //类型强制转换在要转换的标识符前加()里面写要转换成什么类型
        System.out.println((int)c1);//97
        System.out.println((int)c2);//20013

        //结论：所有的字符本质还是数字

        /*
        char 字符类型会涉及一个知识点：编码
        编码 Unicode  可以处理各种语言文字  它有一张编码表：
        这个表中97对应的就是a，65对应的就是A
        编码值占2字节  最多可以表示0~65536
        在Excel表格中，行数最多只有2的16次方，而2的16次方就等于65536
        Unicode编码的表示方式是U0000 UFFFF，范围就是U0000-UFFFF
        在Java中，前面加上一个  反斜杠  就能转义，  反斜杠+U  代表给后面这个数字转义
        */

        char c3 = '\u0061';
        System.out.println(c3);//a

        /*
         * 转义字符
         * \t    制表符
         * \n    换行符
         * ......百度查
         * */

        System.out.println("========================================");
        //========================================
        //好玩的操作——以后会学习的
        //========================================
        String sa = new String("Hello world");
        String sb = new String("Hello world");
        System.out.println(sa == sb);//false

        String sc = "Hello world";
        String sd = "Hello world";
        System.out.println(sc == sd);//true
        //之后学到对象的时候  从内存的级别分析

        System.out.println("========================================");
        //========================================
        //布尔值扩展
        //========================================
        boolean flag = true;
        if(flag==true){ }//如果flag为true则运行大括号中的代码
        if(flag){ }//和上面一样
        //新手会像上面一样写代码，而老手会写下面的
        //Java中有这样一个概念：Less Is More! —— 代码要精简易读

    }

    private static class Sring {
        public Sring(String hello_world) {
        }
    }
}
