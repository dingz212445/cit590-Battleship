package battleship;

public class Battleship extends Ship {
    
    Battleship(){
        this.length = 4;
        for (int i = 0; i < this.length; i++) {
            this.hit[i] = false;
        }
    }

    @Override
    int getLength() {
        // TODO Auto-generated method stub
        return this.length;
    }

    @Override
    String getShipType() {
        return "battleship";
    }
    
}
