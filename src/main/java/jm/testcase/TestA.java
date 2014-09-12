package jm.testcase;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestA {

	@BeforeClass
	public void setUp() {
		// close 
	}

	@Test(groups = { "fast" })
	public void aFastTest() {
		Assert.assertEquals("add", "addy");
		System.out.println("Fast test");
	}

	@Test(groups = { "slow" })
	public void aSlowTest() {
		System.out.println("Slow test");
	}
	
	

}