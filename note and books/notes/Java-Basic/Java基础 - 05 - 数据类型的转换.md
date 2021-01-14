# Java基础 - 05 - 数据类型的转换

由于Java是强类型语言，所以要进行有些运算的时候，需要用到类型转换
整型、常量、字符串实际上是可以混合运算的
运算中，不同类型的数据先转化为同一类型，然后进行运算

### 数据类型的级别/优先级/大小排序：

```java
低 --------------------------------------------------> 高
byte -> short -> char -> int -> long -> float -> double
```

---

## 一、强制类型转换(优先级高 -> 低)

**强制类型转换**格式：(类型)变量名，比如：

```java
//强制类型转换  (类型)变量名  优先级高 -> 低
int i = 128;
byte b = (byte)i;//内存溢出问题
System.out.println(i);
System.out.println(b);
```

### 这里有一个内存溢出问题

由于`byte`数据类型的范围是`-128 ~ 127`，要转换的这个数i超过了`byte`的范围，这也是为什么转换出来的是`-128`

---

## 二、自动类型转换(优先级低 -> 高)

**自动类型转换**不需要添加任何东西可以直接转换，拿上面的`byte b`举例：

```java
//自动类型转换  优先级低 -> 高
double d = i;
System.out.println(d);//128.0
```

---

## 三、注意点
1. 不能对布尔值进行转换

2. 不能把对象类型转换为不相干的类型

3. 在把高容量转换到低容量的时候，强制转换

4. 转换的时候可能存在内存溢出(***上面强制转换发生的问题***)，或者精度问题(***下面例子***)

5. 不同继承体系内的对象不能转换

```java
System.out.println((int)23.7);//23
System.out.println((int)-45.89f);//-45
//精度丢失
```

```java
char c = 'a';
int d1 = c + 1;
System.out.println(d1);//98
System.out.println((char)98);//b
```

---

## 四、溢出问题
操作比较大的数的时候，注意溢出的问题
***JDK7新特性，数字之间可以使用下划线分割，但不会输出下划线***

```java
int money = 10_0000_0000;
int years = 20;
int total = money*years;//本来应该是200亿，但在计算的时候溢出了
System.out.println(total);//是个负数
```

我们定义一个10亿的整数，再定义一个整数20，把他们相乘用`int`型输出，结果是个负数

### 改为用long输出

```java
//改用long输出
long total2 = money*years;
System.out.println(total2);//还是那个负数
```

结果还是那个负数

### 原因

定义的`money`和`years`是`int`型的，计算结束后还是`int`类型
计算结束之后才转换成了`long`类型，转换之前就已经存在问题了

### 解决问题

我们在它运算之前就把`years`改为`long`类型

```java
long total3 = money*((long)years);
System.out.println(total3);//成功输出200亿
```

