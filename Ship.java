package battleship;

public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    protected int length;
    private boolean horizontal;
    boolean [] hit = new boolean[4];
    
    abstract int getLength();
    
    int getBowRow() {
        return this.bowRow;
    }
    
    int getBowColumn() {
        return this.bowColumn;
    }
    
    boolean isHorizontal() {
        return horizontal;
    }
    
    void setBowRow(int row) {
        this.bowRow = row;
    }
    
    void setBowColumn(int column) {
        this.bowColumn = column;
    }
    
    void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    
    abstract String getShipType();
    
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if(horizontal && column + this.length - 1 > 9) {
            return false;
        }
        if(!horizontal && row + this.length - 1 > 9) {
            return false;
        }
        for(int i = 0; i < this.length; i++) {
            if (ocean.isOccupied(row, column) || ocean.isOccupied(row, column-1)
                    || ocean.isOccupied(row, column+1) || ocean.isOccupied(row - 1, column)
                     || ocean.isOccupied(row + 1, column) || ocean.isOccupied(row - 1, column - 1)
                     || ocean.isOccupied(row - 1, column + 1) || ocean.isOccupied(row + 1, column - 1) 
                     || ocean.isOccupied(row + 1, column + 1)) {
                return false;
            }
            if(horizontal) {
                column++;
            }else {
                row++;
            } 
        }
        return true;
    }
    
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;
        
        Ship[][] shipsArray = ocean.getShipArray();
        for (int i = 0; i < this.length; i++) {
            shipsArray[row][column] = this;
            if (horizontal) {
                column++;
            } else {
                row++;
            }
        }
    }
    
    boolean shootAt(int row, int column) {
    	if (!this.isSunk()) {
	    	if (this.horizontal && row == this.bowRow && column >= this.bowColumn && column <= this.bowColumn + this.length - 1) {
	    		 this.hit[column - this.bowColumn] = true;
	             return true;
	    	}
	    	
	    	if (!this.horizontal && column == this.bowColumn && row >= this.bowRow && row <= this.bowRow + this.length - 1) {
	   		 this.hit[row - this.bowRow] = true;
	            return true;
	        }
    	}
        return false;
    }
    
    boolean isSunk() {
        for (int i = 0; i < this.length; i++) {
            if(!this.hit[i]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        if (this.isSunk()) {
            return "x";
        } else {
            return "S";
        }
    }

}
