# Java方法 - 03 - 方法的重载和重写(Super关键字)

## 一、重载(overload)

***重载就是在一个类中，有相同的函数名称，但形参不同的函数***

### 方法重载的规则

- **方法名称必须相同**
- **参数列表必须不同**(个数不同、或类型不同、参数排列顺序不同等)
- 重载的方法可以改变访问修饰符
- 方法的返回类型可以相同也可以不相同
- 仅仅返回类型不同不足以成为方法的重载
- 方法能够在同一个类中或者在一个子类中被重载。

### 实现理论

- 方法名称相同时，编译器会根据调用方法的参数个数、参数类型等去逐个匹配，以选择对应的方法，如果匹配失败，则编译器报错

---

## 二、重载的例子

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
    //方法名相同，参数列表不同，返回值相同
    public static int max(double num1,double num2){
        int result=0;//这里要初始化result 不然下面return会报错 因为没初始化
        if(num1==num2){
            System.out.println("num1=num2");
            return 0;//程序走到这里 方法结束
        }
        if(num1>num2) {
            result = (int)num1;
        }else{
            result = (int)num2;
        }
        return result;
    }
    //三个数比大小
    public static int max(int num1,int num2,int num3){
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
  	//方法重载 double
    public static double max(double num1,double num2){
        double result=0;//这里要初始化result 不然下面return会报错 因为没初始化
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

---

## 三、方法的重写(override)

***子类对父类允许访问的方法实现过程进行重新编写,参数和返回值都不能改变,即外壳不变,核心改变***

- 重写的好处在于子类可以根据需要，定义特定于自己的行为。 也就是说子类能够根据需要实现父类的方法。
- 重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常。例如： 父类的一个方法申明了一个检查异常 `IOException`，但是在重写这个方法的时候不能抛出 `Exception` 异常，因为 `Exception` 是 `IOException` 的父类，只能抛出 `IOException` `的子类异常。
- 在面向对象原则里，重写意味着可以重写任何现有方法

---

### 方法重写的规则

- **参数列表必须完全与被重写方法的相同**。
- 返回类型与被重写方法的返回类型可以不相同，但是必须是父类返回值的派生类
  - java5 及更早版本返回类型要一样，java7 及更高版本可以不同
- 访问权限不能比父类中被重写的方法的访问权限更低。
  - 例如：如果父类的一个方法被声明为 public，那么在子类中重写该方法就不能声明为 protected。
- 父类的成员方法只能被它的子类重写。
- 声明为 final 的方法不能被重写。
- 声明为 static 的方法不能被重写，但是能够被再次声明。
- 子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为 private 和 final 的方法。
- 子类和父类不在同一个包中，那么子类只能够重写父类的声明为 public 和 protected 的非 final 方法。
- 重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。
- 构造方法不能被重写。
- 如果不能继承一个方法，则不能重写这个方法。

---

## 四、重写的例子

```java
class Animal{
   public void move(){
      System.out.println("动物可以移动");
   }
}
class Dog extends Animal{
   public void move(){
      System.out.println("狗可以跑和走");
   }
}
public class TestDog{
   public static void main(String args[]){
      Animal a = new Animal(); // Animal 对象
      Animal b = new Dog(); // Dog 对象
      a.move();// 执行 Animal 类的方法
      b.move();//执行 Dog 类的方法
   }
}
```

- 在上面的例子中可以看到，尽管 b 属于 Animal 类型，但是它运行的是 Dog 类的 move方法。
- 这是由于在编译阶段，只是检查参数的引用类型。
- 然而在运行时，Java 虚拟机(JVM)指定对象的类型并且运行该对象的方法。
- 因此在上面的例子中，之所以能编译成功，是因为 Animal 类中存在 move 方法，然而运行时，运行的是特定对象的方法。

---

## 五、`Super`关键字

***当需要在子类中调用父类的被重写方法时，要使用 super 关键字***

```java
class Animal{
   public void move(){
      System.out.println("动物可以移动");
   }
}
class Dog extends Animal{
   public void move(){
      super.move(); // 应用super类的方法
      System.out.println("狗可以跑和走");
   }
}
public class TestDog{
   public static void main(String args[]){
      Animal b = new Dog(); // Dog 对象
      b.move(); //执行 Dog类的方法
   }
}
```

---

## 六、重写与重载的区别

| 区别点   | 重载方法 | 重写方法                                       |
| :------- | :------- | :--------------------------------------------- |
| 参数列表 | 必须修改 | 一定不能修改                                   |
| 返回类型 | 可以修改 | 一定不能修改                                   |
| 异常     | 可以修改 | 可以减少或删除，一定不能抛出新的或者更广的异常 |
| 访问     | 可以修改 | 一定不能做更严格的限制（可以降低限制）         |

---

## 七、总结

方法的重写(Overriding)和重载(Overloading)是java多态性的不同表现，重写是父类与子类之间多态性的一种表现，重载可以理解成多态的具体表现形式。

1. 方法重载是一个类中定义了多个方法名相同,而他们的参数的数量不同或数量相同而类型和次序不同,则称为方法的重载(Overloading)。
2. 方法重写是在子类存在方法与父类的方法的名字相同,而且参数的个数与类型一样,返回值也一样的方法,就称为重写(Overriding)。
3. 方法重载是一个类的多态性表现,而方法重写是子类与父类的一种多态性表现。

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200618155223575-1881372085.png)

![](https://img2020.cnblogs.com/blog/2057077/202006/2057077-20200618155231005-1380516824.png)

---