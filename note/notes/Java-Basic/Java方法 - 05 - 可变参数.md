# Java方法 - 05 - 可变参数

## 一、定义

- JDK 1.5 开始，Java支持传递同类型的可变参数给一个方法。
- 在方法声明中，在指定参数类型后加一个省略号(...)
- 一个方法中只能指定一个可变参数，它必须是方法的最后一个参数。任何普通的参数必须在它之前声明
  - `public void test(int ... i, int x){}`就会报错

---

## 二、作用

最开始的时候写方法，会遇见方法有很多不确定的参数，这种情况下，会去写很多类、方法来代替它，比如

```java
public class Demo04 {
    public static void main(String[] args) {
    }
    public void method(){ }
    public void method(int i){ }
    public void method(int i,int i2){ }
    public void method(int i,double i2){ }
}
```

有可能很多方法的名字都是重复的，参数越多，代码越繁琐，而且有可能一个方法要重写几十次，有时候就可以像`main()`方法一样，一次性传递好几个参数——数组(数组是个数据结构，可以存放好多数字)。但是还是不满足需求，就可以用可变参数代替掉。

---

## 三、练习

### 传递多个参数后输出

```java
public class Demo04 {
    public static void main(String[] args) {
        Demo04 demo04 = new Demo04();//对象的实例化
        demo04.test(1,2,3,4,45,5);//传递了五个参数
    	//如果传递的参数中有其他类型而不是int型，就会报错
    }
    public void test(int ... i){
        System.out.println(i[0]);
        System.out.println(i[1]);
        System.out.println(i[2]);
        System.out.println(i[3]);
        System.out.println(i[4]);
        System.out.println(i[5]);
    }
}
```

- ***这里使用了对象来调用这个方法***

- 传递了五个参数：`1,2,3,4,45,5`。然后`test()`方法输出了五个参数，参数是可变的，不过这里把它给定义了这五个数

- ***这个例子就是数组的本质***

---

### 打印参数中最大的值

```java
public static void main(String args[]){
  //调用可变参数的方法
  printMax(34,3,3,2,56.5);//直接传递五个参数
  printMax(new double[]{1,2,3});//定义一个新数组传递
}

public static void printMax(double ... numbers){
    if(numbers.length == 0){
        System.out.println("你没有传递参数");
        return;
    }
    double result = numbers[0];
 	//排序
    for (int i = 1; i < numbers.length; i++) {
        if(numbers[i] > result){
            result = numbers[i];
        }
    }
    System.out.println("最大值是： " + result);
}
```
---