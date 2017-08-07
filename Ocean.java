package battleship;

import java.util.Random;

public class Ocean {
    private Ship[][] ships = new Ship[10][10];
    private int shotsFired;
    private int hitCount;
    
    Ocean() {
        this.shotsFired = 0;
        this.hitCount = 0;
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                new EmptySea().placeShipAt(i, j, true, this);;
            }
        }
    }
    
    void placeAllShipsRandomly() {
        placeOneShipRandomly(new Battleship());
        
        for(int i = 0; i < 2; i++) {
            placeOneShipRandomly(new Cruiser());
        }
        
        for (int i = 0; i < 3; i++) {
            placeOneShipRandomly(new Destroyer());
        }
        
        for (int i = 0; i < 4; i++) {
            placeOneShipRandomly(new Submarine());
        }
        
    }
    
    private void placeOneShipRandomly(Ship ship) {
        int r = new Random().nextInt(10);
        int c = new Random().nextInt(10);
        boolean hor = new Random().nextBoolean();
        
        while(!ship.okToPlaceShipAt(r, c, hor, this)) {
            r = new Random().nextInt(10);
            c = new Random().nextInt(10);
            hor = new Random().nextBoolean();
        }
        ship.placeShipAt(r, c, hor, this);
    }
    
    boolean isOccupied(int row, int cloumn) {
    	if (row < 0 || row > 9 || cloumn < 0 || cloumn > 9) {
    		return false;
    	}
        return !this.ships[row][cloumn].getShipType().equals("emptysea");
    }
    
    boolean shootAt(int row, int column) {
    	if (!isOccupied(row, column)) {
    		this.ships[row][column].shootAt(row, column);
    		this.shotsFired++;
    		return false;
    	}
    	
        if (!ships[row][column].isSunk()) {
            this.ships[row][column].shootAt(row, column);
            this.shotsFired++;
            this.hitCount++;
            return true;
        } else {
            this.shotsFired++;
            return false;
        }
    }
    
    int getShotsFired() {
        return this.shotsFired;
    }
    
    int getHitCount() {
        return this.hitCount;
    }
    
    boolean isGameOver() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!ships[i][j].getShipType().equals("emptysea") || !ships[i][j].isSunk()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    Ship[][] getShipArray() {
        return this.ships;
    }
    
    void print() {
        int column_id = 0;
        System.out.print("0" + "  ");
        for(int i = 0; i < 10; i++) {
            System.out.print(column_id + "  ");
            column_id++;
        }
        System.out.println();
        
        int row_id = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print(row_id + "  ");
            for (int j = 0; j < 10; j++) {
                if (ships[i][j].isHorizontal()) {
                    if (!ships[i][j].hit[i - ships[i][j].getBowRow()]) {
                        System.out.print("." + "  ");
                    } else {
                        System.out.print(ships[i][j] + "  ");
                    }
                } else {
                    if (!ships[i][j].hit[j - ships[i][j].getBowColumn()]) {
                        System.out.print("." + "  ");
                    } else {
                        System.out.print(ships[i][j] + "  ");
                    }
                }
            }
            System.out.println();
            row_id++;
        }
        
    }
    

}
