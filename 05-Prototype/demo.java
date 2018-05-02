//http://www.runoob.com/design-pattern/prototype-pattern.html

import java.util.Hashtable;

// 创建一个实现了Cloneable 接口的抽象类
public abstract class Shape implements Cloneable{
    private String id;
    protected String type;
    
    abstract void draw();
    
    public String getType(){
        return type;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public Object clone(){
        Object cloone = null;
        try{
            clone = super.clone();
        }catch(CloneNotSuppertedException e){
            e.printStackTrace();
        }
        return clone;
    }
}

// 创建扩展了上面抽象类的实体类
public class Rectangle extends Shape{
    public Rectangle(){
        type = "Rectangle";
    }
    
    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}
public class Square extends Shape{

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

// 创建一个类，从数据库获取实体类，并把它们存储在一个Hashtable中
public class ShapeCache{
    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();
    
    public static Shape getShape(String shapeId){
        Shape chachedShape = shapeMap.get(shapeId);
        return (Shape)cachedShape.clone();
    }
    
    //对每种形状都进行数据库查询，并创建该形状
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.geiId(), circle);
        
        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}

//使用ShapeCache类来获取存储在Hashtable中的形状的克隆
public class PrototypePatternDemo{
    public static void main(String[] args){
        ShapeCache.loadCache();
        
        Shape clonedShape = (Shape)ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());
        
        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());        

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType()); 
    }
}
