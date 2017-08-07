package battleship;

public class EmptySea extends Ship {
    
    EmptySea(){
        this.length = 1;
        this.hit[0] = false;
    }
    
    @Override
    boolean shootAt(int row, int column) {
        this.hit[0] = true;
        return false;
    }
    
    @Override
    boolean isSunk() {
        return false;
    }

    @Override
    int getLength() {
        return 1;
    }
    
    @Override
    public String toString() {
        return "-";
    }

    @Override
    String getShipType() {
        return "emptysea";
    }

}
