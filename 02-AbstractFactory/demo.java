// 形状接口
public interface Shape{
    void draw();
}

public class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}

public class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Square::draw() method.");
    }
}

public class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}

// 颜色接口
public interface Color{
    void fill();
}

public class Red implements Color{
    @Override
    public void fill(){
        System.out.println("Inside Red::fill() method.");
    }
}

public class Green implements Color{
    @Override
    public void fill(){
        System.out.println("Inside Green::fill() method.");
    }
}

public class Blue implements Color{
    @Override
    public void fill(){
        System.out.println("Inside Blue::fill() method.");
    }
}

// 为Color和Shape对象创建抽象类来获取工厂
public abstract class AbstractFactory{
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}

//创建扩展了AbstractFactory的工厂类，基于给定的信息生成实体类的对象
public class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shape){
        if(null == shape){
            return null;
        }
        if(shape.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shape.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shape.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
    
    @Override
    Color getColor(String color){
        return null;
    }
}

public class ColorFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shape){
        return null;
    }
    
    @Override
    public Color getColor(String color){
        if(null == color){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        }else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return  null;
    }
}

// 创建一个工厂生成器类，通过传递形状或颜色信息来获取工厂
public class FactoryProceducer{
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgonreCase("SHAPE")){
            return new ShapeFactory();
        }else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}

// 测试代码
public class AbstractFactoryPatternDemo{
    public static void main(String[] args){
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProceducer.getFactory("SHAPE");
        if(null != shapeFactory){
            Shape shape1 = shapeFactory.getShape("CIRCLE");
            shape1.draw();
        }
        
        //颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        if(null != colorFactory){
            Color color1 = colorFactory.getColor("RED");
            color1.fill();
        }
    }
}
