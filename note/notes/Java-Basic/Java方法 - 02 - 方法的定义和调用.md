# Java方法 - 02 - 方法的定义和调用

---

## 一、方法的定义

Java的方法类似于其他语言的*函数*(c语言，py语言中)，有着同样的作用，方法是一段***用来完成特定功能的代码片段***，一般情况下，定义一个方法包含以下语法：

```java
修饰符 返回值类型 方法名(参数类型 参数名){
  ...
  方法体
 	...
  return 返回值;
}
```

***方法包含一个方法头和一个方法体***

---

## 二、一个方法的所有部分

### 修饰符

修饰符，这是可选的，告诉编译器如何调用该方法。定义了该方法的访问类型。

### 返回值类型

方法可能会存在返回值。`returnValueType`是方法返回值的数据类型。有些方法执行所需的操作，但没有返回值。在这种情况下，`returnValueType`是关键字`void`。

如果没有`void`无返回值，就一定要用`return`把返回值给返回了

### 方法名

是方法的实际名称。方法名和参数表共同构成方法签名。***但要遵守命名规范***

### 参数类型

参数像是一个占位符。当方法被调用时，传递值给参数。这个值被称为实参或变量。参数列表是指方法的参数类型、顺序和参数的个数。参数是可选的，方法可以不包含任何参数。
- 形式参数：在方法被调用时用于接收外界输入的数据。

  ```java
  //加法方法
  //形式参数，用来定义作用的
  public static int add(int a, int b){
    return a+b;
  }
  ```

- 实参：调用方法时实际传给方法的数据。

  ```java
      public static void main(String[] args) {
          //实参，把a,b传递进去了
          int sum = add(1, 2);
          System.out.println(sum);
      }
      //加法方法
      //形式参数，用来定义作用的
      public static int add(int a, int b){
          return a+b;
      }
  ```

### 方法体

方法体包含具体的语句，定义该方法的功能
比如加法的方法体就是`return a+b;`

---

## 三、比大小

如果`num1>num2`返回`num1`，否则返回`num2`
按照方法的语法来写：

1. 修饰符 返回值类型 方法名(参数类型 参数名){}

   ```java
   public static int max(){}
   ```

   - 两个修饰符`public static`
   - 比大小返回的是数字，这里定义为整数`int`
   - 方法名就叫`max`，返回两个数中最大的那个数

   ***这里会报错，显示需要返回一个值，因为返回值类型写的是`int`，就必须返回一个整数类型***

2. 这里需要两个数字比大小，所以写两个**形式参数**

   ```java
   public static int max(int num1,int num2){}
   ```

   - 参数名字是随便写的，但是要符合参数作用，这里定义为`num1`和`num2`

3. 方法体

   如果`num1`大于`num2`这里就返回`num1`，如果`num2`大于`num1`这里就返回`num2`

   ```java
   public static int max(int num1,int num2){
           if(num1>num2) {
               return num1;
           }
           if(num2>num1) {
               return num2;
           }
   }
   ```

   - 这里写了`return`还是报错，因为这里的`return`是写在`if`里的，外面要有个`return`

4. 如何把`num1`返回出来

   一般定义另一个数，来存放比较出来的比较大的那个数

   ```java
       public static int max(int num1,int num2){
           int result=0;//这里要初始化result 不然下面return会报错 因为没初始化
           if(num1>num2) {
               result = num1;
           }
           if(num2>num1) {
               result = num2;
           }
           return result;
       }
   ```

5. 这样的代码不够简洁，使用`if...else`语句

   ```java
       public static int max(int num1,int num2){
           int result=0;//这里要初始化result 不然下面return会报错 因为没初始化
           if(num1>num2) {
               result = num1;
           }else{
             	result = num2;
           }
           return result;
       }
   ```

6. 还不够严谨

   要考虑如果两个数相等的情况

   ```java
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
   ```

   - `return`还有一个作用，`return 0`终止方法，方法结束

---

## 四、方法调用

调用方法：

```java
对象名.方法名(实参列表)
```

Java支持两种调用方法的方式，根据方法是否返回值来选择

1. 当方法返回一个值的时候，方法调用通常被当做一个值，例如：

   ```java
   int larger = max(30,40);
   ```

2. 如果方法返回值是`void`，方法调用一定是一条语句

   ```java
   System.out.println("num1=num2");
   ```

### 比大小方法调用

```java
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
```

这里控制台打印`20`
但是如果传递的参数是两个相等的数，控制台打印`num1=num2  0`

---

***课后拓展了解： 值传递 和 引用传递 ***

---

## 六、课后拓展

值传递( Pass By Value)和引用传递(Pass By Reference)。首先，不要纠结于 Pass By Value 和 Pass By Reference 的字面上的意义，否则很容易陷入所谓的“一切传引用其实本质上是传值”这种并不能解决问题无意义论战中。

更何况，要想知道Java到底是传值还是传引用，起码你要先知道传值和传引用的准确含义吧？可是如果你已经知道了这两个名字的准确含义，那么你自己就能判断Java到底是传值还是传引用。
这就好像用大学的名词来解释高中的题目，对于初学者根本没有任何意义。

---

### 1.  搞清楚 基本类型 和 引用类型 的不同之处

```java
int num = 10;
String str = "hello";
```

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200618145048034-268511370.png)

如图所示，`num`是基本类型，值就直接保存在变量中。而`str`是引用类型，变量中保存的只是实际对象的地址。一般称这种变量为"引用"，引用指向实际对象，实际对象中保存着内容。

### 2. 搞清楚赋值运算符（=）的作用

```java
num = 20;
str = "java";
```

- 对于基本类型 `num` ，赋值运算符会直接改变变量的值，原来的值被覆盖掉。
- 对于引用类型 `str`，赋值运算符会改变引用中所保存的地址，原来的地址被覆盖掉。但是原来的对象不会被改变（重要）。
- 如上图所示，`hello` 字符串对象没有被改变。（没有被任何引用所指向的对象是垃圾，会被垃圾回收器回收）

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200618145226636-1350519844.png)

### 3. 调用方法时发生了什么？参数传递基本上就是赋值操作。

第一个例子：基本类型

```java
void foo(int value) {
    value = 100;
}
foo(num); // num 没有被改变
```

第二个例子：没有提供改变自身方法的引用类型

```java
void foo(String text) {
    text = "windows";
}
foo(str); // str 也没有被改变
```

第三个例子：提供了改变自身方法的引用类型

```java
StringBuilder sb = new StringBuilder("iphone");
void foo(StringBuilder builder) {
    builder.append("4");
}
foo(sb); // sb 被改变了，变成了"iphone4"。
```

第四个例子：提供了改变自身方法的引用类型，但是不使用，而是使用赋值运算符。

```java
StringBuilder sb = new StringBuilder("iphone");
void foo(StringBuilder builder) {
    builder = new StringBuilder("ipad");
}
foo(sb); // sb 没有被改变，还是 "iphone"。
```

重点理解为什么，第三个例子和第四个例子结果不同？

下面是第三个例子的图解：

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200618145348635-880505148.png)

builder.append("4")之后

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200618145447871-77505042.png)

下面是第四个例子的图解：

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200618145511745-883195896.png)

builder = new StringBuilder("ipad"); 之后

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200618145534544-924865568.png)

---