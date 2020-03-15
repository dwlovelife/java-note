package establish.factory.absfactory.pizzastore.order;

import establish.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * 抽象工厂模式
 * 基本介绍 
 * 1.抽象工厂模式: 定义了一个interface用于创建相关有依赖关系的对象簇,而无需指明具体的类
 * 2.抽象工厂模式可以将简单工厂模式和工厂模式进行整合。
 * 3.从设计层面看,抽象工厂模式就是对简单工厂模式的改进(或者称进一步的抽象)
 * 4.将工厂抽象成两层,AbsFactory(抽象工厂)和具体工厂的实现子类，这样将单个的简单工厂变成了工厂簇,更利于代码的维护和扩展
 */
public interface AbsFactory {
	
	//让下面的工厂子类类具体实现
	public Pizza createPizza(String orderType);
	
}
