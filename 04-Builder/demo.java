// http://www.runoob.com/design-pattern/builder-pattern.html

import java.util.ArrayList;
import java.util.List;

// 创建一个表示食物条目和食物包装的接口
public interface Item{
    public String name();
    public Packing packing();
    public float price();
}
public interface Packing{
    public String pack();
}

// 创建实现Packing接口的实体类
public class Wrapper implements Packing{
    @Override
    public String pack(){
        return "Wrapper";
    }
}
public class Bottle implements Packing{
    @Override
    public String pack(){
        return "Bottle";
    }
}

// 创建实现Item接口的抽象类，该类提供了默认的功能
public abstract class Burger implements Item{
    @Override
    public Packing packing(){
        return new Wrapper();
    }
    
    @Override
    public abstract float price();
}
public abstract class ColdDrink implements Item{
    @Override
    public Packing packing(){
        return new Bottle();
    }
    
    @Override
    public abstract float price();
}

// 创建扩展了Burger和ColdDrink的实体类
public class VegBurger extends Burger{
    @Override
    public float price(){
        return 25.0f;
    }
    
    @Override
    public String name(){
        return "Veg Burger";
    }
}
public class ChickenBurger extends Burger{
    @Override 
    public float price(){
        return 50.5f;
    }
    
    @Override
    public String name(){
        return "Chicken Burger";
    }
}

public class Coke extends ColdDrink{
    @Override
    public float price(){
        return 30.0f;
    }
    
    @Override
    public String name(){
        reuturn "Coke";
    }
}
public class Pepsi extends ColdDrink{
    @Override
    public float price(){
        return 35.0f;
    }
    
    @Override
    public String name(){
        return "Pepsi";
    }
}


// 创建一个Meal类，带有上面定义的Item对象
public class Meal{
    private List<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public float getCost(){
        float cost = 0.0f;
        for(Item item: items){
            cost += item.price();
        }
        return cost;
    }
    
    public void showItems(){
        for(Item item: items){
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}


// 创建一个MealBuilder类，实际的builder类负责创建Meal对象
public class MealBuilder{
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
    
    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}


// 测试代码
public class BuilderPatternDemo{
    public static void main(String[] args){
        MealBuilder mealBuilder = new MealBuilder();
        
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getCost());
        
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}
