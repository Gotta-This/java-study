# Java方法 - 01 - Java方法详解

方法：日常生活中，为了**解决某种事情**，而采取的某种办法——为了去学习，以什么方式去学校(公交车、打的、坐地铁)——这些解决问题的东西就叫它方法，也叫**函数**

---

## 一、什么是方法

- `System.out.println()`，那么它是什么呢？
  
- `System`是一个类，`out`是一个对象，`println()`就是一个方法
  
- Java方法是语句的集合,它们在一起执行一个功能(比如`a+b`如果感觉非常繁琐，就可以写一个方法，用于`a+b`)
	- 方法是解决一类问题的步骤的有序组合
	- 方法包含于类或对象中
	- 方法在程序中被创建,在其他地方被引用
	  - 比如说`println()`就是一个方法，我们可以`import`包来调用这个方法
	
- 设计方法的原则:方法的本意是功能块,就是实现某个功能的语句块的集合。我们设计方法的

  时候,最好保持方法的原子性,**就是一个方法只完成1个功能,这样利于我们后期的扩展**(基于OOP设计思想)

- ***方法是面向对象的思想，函数是面向过程的思想***

- ***回顾：方法的命名规则？？*** (首字母小写，后面单词驼峰命名规则)

---

## 二、给加法定义一个方法

```java
public class Demo01 {
    //main 方法
    public static void main(String[] args) {
        int sum = add(1, 2);
        System.out.println(sum);
    }
    //加法方法
    public static int add(int a, int b){//static定义为类方法
        return a+b;
    }
}
```

此处可以用Debug查看每一步怎么走的

---

## 三、用之前学的`for`做一个例子

```java
public class Demo01 {
    //main 方法
    public static void main(String[] args) {
        //int sum = add(1, 2);
        //System.out.println(sum);
        forDemo();
    }
    //加法方法
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
```

- `void`关键字代表无返回值
- `main`方法体中尽量干净简洁

---

