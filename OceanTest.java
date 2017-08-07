package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	Ocean ocean;

	@Before
	public void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	public void testPrint() {
		// ocean.print();
	}

	@Test
	public void testPlaceOneShipRandomly() {
		ocean.placeAllShipsRandomly();
		// ocean.print();
	}

	@Test
	public void testShootAt() {
		ocean.placeAllShipsRandomly();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				ocean.shootAt(i, j);
			}
		}
		ocean.print();
	}

}
