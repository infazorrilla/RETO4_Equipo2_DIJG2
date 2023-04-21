package PokeZoo.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import PokeZoo.bbdd.pojo.Enclosure;

class EnclosureTest {

	@Test
	public void test1() {
		Enclosure enclosure = new Enclosure();
		int numIdEnclosure = enclosure.getIdEnclosure();
		assertEquals(numIdEnclosure, 0);
	}

	@Test
	public void test2() {
		Enclosure enclosure = new Enclosure();
		String woType = enclosure.getTypeEn();
		assertEquals(woType, null);
	}

	@Test
	public void test3() {
		Enclosure enclosure = new Enclosure();
		int numNumber = enclosure.getNumberEn();
		assertEquals(numNumber, 0);
	}

}
