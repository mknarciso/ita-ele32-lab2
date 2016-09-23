package comp18;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LempelZivTest {
	LempelZiv first;
	@Before
	public void Setup(){
		 first = new LempelZiv("abcbababcbcabac");
	}

	@Test
	public void EncryptTrial() {
		assertEquals("010100110101000100011000111000",first.toEncodedString());
		//assertEquals("010100110101000100011000111000C",first.toEncodedString());
		}
	
	@Test
	public void TestGetB(){
		assertEquals(2,first.getB(3));
		assertEquals(2,first.getB(4));
		assertEquals(3,first.getB(5));
		assertEquals(3,first.getB(8));
		assertEquals(4,first.getB(9));
		assertEquals(8,first.getB(255));
		assertEquals(10,first.getB(1024));
	}
	@Test
	public void TestDir(){
		assertEquals(13,first.dicIn.size());
	}
	@Test
	public void isAtDir(){
		assertTrue(first.isAtDir("a"));
		assertTrue(first.isAtDir("b"));
		assertTrue(first.isAtDir("c"));
		assertFalse(first.isAtDir("d"));
	}

}