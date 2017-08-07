package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
    Battleship battleship;
    Cruiser cruiser;
    Ocean ocean;
    EmptySea emptysea;

    @Before
    public void setUp() throws Exception {
        battleship = new Battleship();
        ocean = new Ocean();
        cruiser = new Cruiser();
        emptysea = new EmptySea();
    }


    @Test
    public void testOkToPlaceShipAt() {
    	Ship[][] ships = ocean.getShipArray();
    	for (int i = 0; i < 10; i++) {
    		for (int j = 0; j < 10; j++) {
    			System.out.print(ships[i][j]);
    		}
    	}
        assertTrue(battleship.okToPlaceShipAt(0, 0, true, ocean));
        assertFalse(battleship.okToPlaceShipAt(0, 8, true, ocean));
        assertTrue(battleship.okToPlaceShipAt(6, 6, false, ocean));
        assertFalse(battleship.okToPlaceShipAt(7, 6, false, ocean));
        assertTrue(battleship.okToPlaceShipAt(7, 6, true, ocean));
        battleship.placeShipAt(2, 3, true, ocean);
        assertFalse(cruiser.okToPlaceShipAt(3, 7, true, ocean));
    }
    
    @Test
    public void testPlaceShipAt() {
        battleship.placeShipAt(2, 3, true, ocean);
        assertEquals("battleship", ocean.getShipArray()[2][3].getShipType());
        assertNotEquals("battleship", ocean.getShipArray()[3][3].getShipType());
        assertEquals("battleship", ocean.getShipArray()[2][6].getShipType());
        

    	
    }
    
    @Test
    public void testIsSunk() {
    	battleship.placeShipAt(4, 5, false, ocean);
    	assertFalse(battleship.isSunk());
    }
    
    @Test
    public void testShootAt() {
    	battleship.placeShipAt(4, 5, false, ocean);
        Ship[][] ships = ocean.getShipArray();
    	for (int i = 0; i < 10; i++) {
    		System.out.println();
    		for (int j = 0; j < 10; j++) {
    			System.out.print(ships[i][j]);
    		}
    	}
    	assertTrue(battleship.shootAt(4, 5));
    	assertTrue(battleship.shootAt(6, 5));
    	assertFalse(battleship.shootAt(3, 5));
    	assertTrue(battleship.hit[0]);
    	assertTrue(battleship.hit[2]);
    	assertFalse(battleship.hit[3]);
    }
    
    @Test
    public void testShootAtEmpty() {
    	assertEquals("emptysea", ocean.getShipArray()[1][1].getShipType());
    	ocean.shootAt(1, 1);
    	assertFalse(ocean.getShipArray()[1][1].isSunk());
    	assertTrue(ocean.getShipArray()[1][1].hit[0]);
    	assertFalse(ocean.getShipArray()[2][2].hit[0]);
    }

}
