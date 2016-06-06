package test;

import Model.QuackBehavior;

public class MuteQuackTest implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}