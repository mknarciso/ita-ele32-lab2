package comp18;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LempelZivTest {
	LempelZiv first,second,third;
	@Before
	public void Setup(){
		 first = new LempelZiv("abcbababcbcabac");
		 second = new LempelZiv("Isto é um teste, muito legal este teste!");
		// third = new LempelZiv("abababa");
	}

	@Test
	public void EncryptTrial() {
		assertEquals("010100110101000100011000111000c",first.toEncodedString());
		}
	@Test
	public void DecryptTrial() {
	    first.decode();
		assertEquals("abcbababcbcabac",first.toDecodedString());
	}
	@Test
	public void DecryptTrial2() {
	    second.decode();
	    System.out.println(second.toEncodedString());
		assertEquals("Isto é um teste, muito legal este teste!",second.toDecodedString());
	}	
	@Test
	public void DecryptTrial3() {
	    //third.decode();
		//assertEquals("abababa",third.toEncodedString());
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