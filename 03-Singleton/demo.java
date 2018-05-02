//单例类
public class SingleObject{
    //创建SingleObject的一个对象
    private static SingleObject instance = new SingleObject();
    
    //让构造函数为private，这样该类就不会被实例化
    private SingleObject(){}
    
    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }
    
    public void showMessage(){
        System.out.println(""Hello World");
    }
}

//测试代码
public class SingletonPatternDemo{
    public static void main(String[] args){
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}
