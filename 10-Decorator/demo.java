/*
 * 装饰器模式允许向一个现有的对象添加新的功能，同时又不改变其结构
 * 这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装
 * 这种设计模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能
 */
 
 
//创建一个接口
public interface Shape{
    void draw();
}
 
 
//创建实现接口的实体类
public class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Shape: Rectangle");
    }
}

public class Circle implements Shape{
    @Override
    public void draw(){
        Syetem.out.println("Shape: Circle");
    }
}


//创建实现了Shape接口的抽象装饰器
public abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;
    
    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }
    
    public void draw(){
        decoratedShape.draw();
    }
}


//创建扩展了ShapeDecorator类的实体装饰类
public class RedShapeDecorator extends ShapeDecorator{
    
    public RedShapeDecorator(Shape decoratedShape){
        super(decoratedShape);
    }
    
    @Override
    public void draw(){
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }
    
    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
   }
}


//使用RedShapeDecorator来装饰Shape类
public class DecoratorPatternDemo{
    public static void main(String[] args){
    
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        
        System.out.println("Circle with normal border");
        circle.draw();
        
        System.out.println("\nCircle of red border");
        redCircle.draw();
        
        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
