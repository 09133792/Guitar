package Model;

import test.FlyWithWingsTest;
import test.QuackTest;

public class MallardDuck extends Duck {
 
	public MallardDuck() {
 
		quackBehavior = new QuackTest();
                flyBehavior = new FlyWithWingsTest();
 

	}
 
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}