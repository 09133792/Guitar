package Model;

import test.FlyWithWingsTest;
import test.QuackTest;

public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		flyBehavior = new FlyWithWingsTest();
		quackBehavior = new QuackTest();
	}
 
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}
}