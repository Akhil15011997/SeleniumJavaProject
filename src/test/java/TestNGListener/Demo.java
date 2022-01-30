package TestNGListener;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

//@Listeners({TestNGListener.TestNGListenerDemo.class})
public class Demo {
	@Test(priority = 1)
	public void Test1() { System.out.println("In Test1"); }
	@Test(priority = 2)
	public void Test2() { System.out.println("In Test2"); Assert.assertTrue(false); }
	@Test(priority = 3)
	public void Test3() { System.out.println("In Test3"); throw new SkipException("This is skipped"); }

}
