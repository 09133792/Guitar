package test;

import Model.FlyBehavior;

public class FlyNoWayTest implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}