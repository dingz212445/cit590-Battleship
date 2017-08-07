package battleship;

public class Submarine extends Ship {

    Submarine(){
        this.length = 1;
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
        return "submarine";
    }

}
