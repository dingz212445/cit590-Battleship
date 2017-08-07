package battleship;

public class Cruiser extends Ship {
    
    Cruiser(){
        this.length = 3;
        for (int i = 0; i < this.length; i++) {
            this.hit[i] = false;
        }
    }

    @Override
    int getLength() {
        return this.length;
    }

    @Override
    String getShipType() {
        return "cruiser";
    }

}
