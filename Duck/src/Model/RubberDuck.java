package Model;

import test.FlyNoWayTest;
import test.SqueakTest;

public class RubberDuck extends Duck {
 
	public RubberDuck() {
		flyBehavior = new FlyNoWayTest();
		quackBehavior = new SqueakTest();
	}
 
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}
