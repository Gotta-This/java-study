# Java基础 - 06 - 变量、变量作用域与常量

## 一、变量

- ***变量是什么：就是可以变化的量！***
  - 可以通过变量操作内存中的数据，定义了内存中一个空间叫xxx
  - 变量指的是内存中的空间，空间里的东西不是定量，就叫变量
- Java是一种强类型语言，每个变量都必须声明其类型
- Java变量是程序中最基本的存储单元，其元素包括变量名，变量类型和**作用域**

---

### 变量定义方式/公式

```java
   type varName [=value] [{, varName[=value]}] ;
//数据类型 变量名  =  值;  可以使用逗号隔开来声明多个同类型变量，但不建议
```

例：

```java
//int a,b,c;
//int a = 1, b = 2, c = 3;
//上面两种方式不建议使用,要注重程序的可读性
int a = 1;
int b = 2;
int c = 3;

String name = "guopengfei";
char x = 'X';
double pi = 3.14;
```

注意事项：

- 每个变量都有类型，类型可以是基本类型，也可以是引用类型
- 变量名必须是合法的[标识符](https://www.cnblogs.com/Gotta-This/p/13064091.html)
- 变量声明是一条完整的语句，因此每一个声明都必须以分号结束

---

## 二、变量作用域

- 一个类中不只能定义`main`方法，还可以定义其他方法
- 除了定义方法，还可以定义一些属性(可以理解为**变量**)

```java
public class Variable{
  static int allClicks = 0;			//  类变量
  String str = "hello world";		//  实例变量
  
  public void method(){
    int i = 0;									//  局部变量
  }
}
```

---

### 局部变量(写在方法中的)

```java
//main方法
public static void main(String[] args) {
  //局部变量：main方法大括号结束就失效了
  //        必须声明变量和初始化值
  int i = 10;
  System.out.println(i);
}

//其他方法
public void add(){
  //System.out.println(i);
  //由于i是main中定义的局部变量，在其他方法中不生效
}
```

- 局部变量在大括号结束失效，在其他方法中无法使用
- 局部变量必须声明变量和初始化值

---

### 实例变量(写在类中间的)

```java
public class Demo {
    //实例变量：从属于对象
    String name;
    int age;

    //main方法
    public static void main(String[] args) {
				//实例变量
        //变量类型  变量名字 = new Demo08;
        Demo08 demo08 = new Demo08();
        System.out.println(demo08.age);//0
        System.out.println(demo08.name);//null
    }
}
```
- **实例变量从属于对象**
- 如果不进行初始化，这个**变量的值**会被赋予**默认值**
  - 所有数字的初始化值都为0或0.0
  - 所有字符串变量初始化为十六位的u0000
  - 布尔值默认是`false`
  - 除了基本类型，其余的默认值都是`null`
- **实例化变量**需要`new`自身类，然后用``类名.变量名`调用

---

### 类变量(写在类里面的)

```java
public class Demo {
    //类变量   static 类型 变量名 = 值;
    static double salary = 2500;
  
    //main方法
    public static void main(String[] args) {
				//类变量 static
        System.out.println(salary);
    }
}
```

- 与**实例变量**类似，不过在使用的时候不需要`new`
- **声明变量**格式：`static 类型 变量名 = 值;`例子如上

---

## 三、常量

- 常量(Constant)：初始化(initialize)后不能再改变值！**不会变动的值**
- 所谓变量可以理解成一种特殊的变量，它的值被设定后，在程序运行过程中**不允许被改变**

```java
final 数据类型 常量名 = 值;
final double PI = 3.14;
```

- **常量名一般使用大写字符**
- 在程序中使用某些常量可以提高某些代码的可读性
  - 比如游戏中要设置宽高(**不会改变的值**)
- `public`, `private`, `static`, `final`......都是修饰词，不存在先后顺序
- 常量可以被定义为类变量(**常用**)

### 例

```java
public class Demo {

    //final, static......都是修饰符，不存在先后顺序
    final double PI = 3.14;
    static final int width = 600;
    final static int height = 300;
    public final static int i = 1;
    private final static char c = 'c';

    public static void main(String[] args) {
        //System.out.println(PI);//不是类变量无法使用
        System.out.println(width);
        System.out.println(height);
        System.out.println(i);
        System.out.println(c);
    }
}
```

## 四、变量的命名规范  ※

- 所有变量、方法、类名：**见名知意**
- 类成员变量：首字母小写和驼峰规则
  - 驼峰规则：monthSalary
  - 除了第一个单词以外，后面的单词首字母大写  lastname -> lastName
- 局部变量：首字母小写和驼峰原则
- 常量：**大写字母**和下划线：MAX_VALUE
- 类名：首字母大写和驼峰原则：Man, GoodMan
- 方法名：首字母小写和驼峰原则：run(), runRun()

***《阿里巴巴Java开发手册》有对标识符命名规则的规定，虽然是阿里巴巴公司编写的，但对于我们有很重要的学习作用，百度云链接：[提取码: xcbc](https://pan.baidu.com/s/1BtOw_TtwW1tHF7DFdfuMfA)***

***有关我之前写的[标识符关键字](https://www.cnblogs.com/Gotta-This/p/13064091.html)的笔记***