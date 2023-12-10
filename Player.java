public class Player {
    public BoardCell getPosition() {
        return position;
    }

    public void setPosition(BoardCell position) {
        this.position = position;
    }

    private BoardCell position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    boolean isWinner(){
        return position.getVal()==100;
    }

    int rollDice(){
        while(true){
            int val = (int)(Math.random()*10);
            if(val>0 && val<=6){
                return val;
            }
        }
    }

    Player(String name , BoardCell position){
        this.name = name;
        this.position = position;
    }

}
