package Tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import units.TotalAmount;
public class totalamountTest {

	TotalAmount t;
	@Before
	public void setUp() throws Exception {
		t =new TotalAmount();
	}

	@Test
	public void testTotalAmount() {
		Assert.assertEquals(400, t.cart(5,100));
	}

}
