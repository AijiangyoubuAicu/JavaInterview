# 工厂模式
## 工厂模式的定义
在基类中定义创建对象的一个接口，让子类决定实例化那个类。工厂方法让一个类的实例化延迟到子类中进行；

## 工厂模式分类
- 简单工厂模式：又称静态工厂方法模式
- 工厂模式模式：又称多态性工厂模式或虚拟构造子模式
- 抽象工厂模式：又称工具箱模式

## 使用工厂模式的好处
1.**解耦**：把对象的创建和使用的过程分开；<br>
2.**降低代码重复**：如果创建某个对象的过程都很复杂，需要一定的代码量，而且很多地方都要用到，那么就会有很多的重复代码<br>
3.**降低维护成本**：由于创建过程都由工厂统一管理，所以发生业务逻辑变化，不需要找到所有需要创建对象B的地方逐步修正，只需要在工厂修改即可，加大维护成本

## 简单工厂模式
### 介绍
严格来说，简单工厂模式并不是23种常用的设计模式之一，它只算工厂模式的一个特殊实现，简单工厂模式在实际中的应用相对于其他2个工厂模式用的还是相对
少得多，因为它只适应很多简单的情况<br>
最重要的是它违背了我们在概述中说的**开放-封闭原则**(虽然可以通过**反射**的机制来避免，后面我们会介绍到)，因为每次你要添加一个功能；

### 适用场景
(1) 需要创建的对象较少<br>
(2) 客户端不关系对象的创建过程

### 简单工厂模式角色分配
- 工厂角色：简单工厂模式的核心，它负责实现创建所有实例的内部逻辑，工厂类可以被外界直接调用，创建所需的产品对象
- 抽象产品角色：简单工厂模式所创建的所有对象的超类，它负责描述所有实例所公有的公共接口
- 具体产品角色：简单工厂模式的创建目标，所有创建的对象都是充当这个角色的具体类的实例

(1) 创建抽象产品角色(Shape 接口)：
```java
/**
 * 形状接口
 * 拥有一个图画的功能
 * 
 * 该类是“抽象产品角色”
 */
public interface Shape {
    void draw();
}
```

(2) 创建具体产品角色(实现 Shape 接口的实现类)

- 圆形

```java
/**
 * 圆形
 */
public class Circle implements Shape {

    public Circle() {
        System.out.println("圆形");
    }

    @Override
    public void draw() {
        System.out.println("画一个圆");
    }
}
```

- 长方形

```java
/**
 * 长方形
 */
public class Rectangle implements Shape {

    public Rectangle() {
        System.out.println("长方形");
    }

    @Override
    public void draw() {
        System.out.println("画了一个长方形");
    }
}
```

- 正方形

```java
/**
 * 正方形
 */
public class Square implements Shape {

    public Square() {
        System.out.println("正方形");
    }

    @Override
    public void draw() {
        System.out.println("画了一个正方形");
    }
}
```
(3) 创建工厂角色(工厂类对应接口名ShapeFactory)：

```java
/**
 * 形状工厂
 */
public class ShapeFactory {

    // 使用 getShape() 方法获取形状类型的对象
    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("圆形")) {
            return new Circle();
        }
        if (shapeType.equalsIgnoreCase("长方形")) {
            return new Rectangle();
        }
        if (shapeType.equalsIgnoreCase("正方形")) {
            return new Square();
        }
        return null;
    }
}
```
(4) 测试方法：
```java
public class Test {
    public static void main(String[] args) {
        // 获取圆形对象
        Shape c = ShapeFactory.getShape("圆形");
        c.draw();
        // 获取长方形对象
        Shape r = ShapeFactory.getShape("长方形");
        r.draw();
        // 获取正方形对象
        Shape s = ShapeFactory.getShape("正方形");
        s.draw();
    }
}
```
可得结果：

```
圆形
画一个圆
长方形
画了一个长方形
正方形
画了一个正方形
```
### 使用反射改善简单工厂

这样我们实现的存在一个问题:如果我们新增产品的话，就需要修改工厂类中的**getShape()**，这明显不符合**开放-封闭原则**

改善简单工厂模式，以反射的方式：
```java
/**
 * 利用反射简单解决工厂每次增加新的产品都要修改产品的弊端
 */
public class ShapeFactory_02 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
```
测试：

```java
public class Test {
    public static void main(String[] args) {
        // 获取圆形对象
        Circle circle = (Circle) ShapeFactory_02.getClass(Circle.class);
        circle.draw();
        // 获取长方形对象
        Rectangle rectangle = (Rectangle) ShapeFactory_02.getClass(Rectangle.class);
        rectangle.draw();
        // 获取正方形对象
        Square square = (Square) ShapeFactory_02.getClass(Square.class);
        square.draw();

    }
}
```

## 工厂模式

### 概述

工厂模式是简单工厂模式的进一步深化，在工厂方法模式中，不再提供统一的工厂来创建所有的方法，而是针对不同的对象提供不同的工厂，即**每个对象都有一个与之对应的工厂**

### 适用场景
- **一个类不知道它所需要的对象的类**；在工厂方法模式中。客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体的产品对象由具体工厂类创建；
	客户端需要知道创建具体产品的工厂类；
- **一个类通过其子类来指定创建哪个对象**；在工厂方法模式中，对于抽象工厂只需要提供一个创建产品的接口，而其子类来确定确定具体要创建的对象，利用面向
	对象的多态性来创建
- 将创建对象的任务委托给多个工厂的子类中的某一个，客户端在适用时可以无需关新是哪一个工厂子类创建产品子类，需要时再动态指定，可将具体工厂类名存储再配置文件
	或数据库中

### 工厂方法模式角色分配
1.**抽象工厂**角色：工厂方法模式的核心，与应用程序无关，任何再模式中创建的对象的工厂类都必须实现这个接口<br>
2.**具体工厂**角色：这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建某一种产品对象<br>
3.**抽象产品**角色：工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口<br>
4.**具体产品**角色：这个角色实现了抽象产品角色所定义的接口，某具体产品由专门的具体工厂创建，它们之间往往一一对应



