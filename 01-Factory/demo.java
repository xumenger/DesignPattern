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

// 工厂类
public class ShapeFactory{
    public Shape getShape(String shapeType){
        if(null == shapeType){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

// 测试代码
public class FactoryPatternDemo{
    public static void main(String[] args){
         ShapeFactory shapeFactory = new ShapeFactory();
         
         Shape shape1 = shapeFactory.getShape("CIRCLE");
         shape1.draw();
         
         Shape shape2 = shapeFactory.getShape("RECTANGLE");
         shape2.draw();
         
         Shape shape3 = shapeFactory.getShape("SQUARE");
         shape3.draw();
    }
}
