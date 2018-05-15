/*
 * 在代理模式中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供接口
 */

// 创建一个接口
public interface Image{
     void display(); 
}


//创建实现接口的实体类
public class RealImage implements Image{
    private String fileName;
  
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
  
    @Override
    public void display(){
         System.out.println("Displaying " + fileName);
    }
  
    private void loadFromDisk(String fileName){
         System.out.println("Loading " + fileName);
    }
}

public class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;
    
    public ProxyImage(fileName){
        this.fileName = fileName;
    }
    
    @Override
    public void display(){
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}


//当被请求时，使用ProxyImage来获取RealImage类的对象
public class ProxyPatternDemo{
    
    public static void main(String[] args){
        Image image = new ProxyImage("test.jpg");
        
        //图像将从磁盘加载
        image.display();
        System.out.println("");
        
        //图像将无法从磁盘加载
        image.display();
    }
}
