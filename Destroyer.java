package battleship;

public class Destroyer extends Ship {

    Destroyer(){
        this.length = 2;
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
        return "destroyer";
    }

}
