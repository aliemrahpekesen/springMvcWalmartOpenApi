package com.aep.walmart.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author aliemrahpekesen
 */
@RunWith(SpringRunner.class)
public class DisplayUtilTests {

	@Test
	public void tectClearAndResize() {
		String dirtyLongText = "\"This is a dirty long &quot;message!";
		String result = DisplayUtil.clearAndResize(dirtyLongText, 10);
		assertEquals(10, result.length());
		assertNotEquals(true, result.contains("\""));
		assertNotSame(dirtyLongText, result);
	}
}
