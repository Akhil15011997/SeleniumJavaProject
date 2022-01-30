package TestNGListener;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

//@Listeners({TestNGListener.TestNGListenerDemo.class})
public class Demo2 {
	@Test
	public void Test4() { System.out.println("In Test4"); }
	@Test
	public void Test5() { System.out.println("In Test5"); Assert.assertTrue(false); }
	@Test
	public void Test6() { System.out.println("In Test6"); throw new SkipException("This is skipped"); }

}
