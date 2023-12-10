import java.util.List;

public class Game {
    private List<Player> players;
    private Player currentTurnPlayer;
    private int currentPlayerIndex;

    public Player getCurrentTurnPlayer() {
        return currentTurnPlayer;
    }

    public void setCurrentTurnPlayer(Player currentTurnPlayer) {
        this.currentTurnPlayer = currentTurnPlayer;
    }

    public boolean isWinnerDeclared() {
        return winnerDeclared;
    }

    public void setWinnerDeclared(boolean winnerDeclared) {
        this.winnerDeclared = winnerDeclared;
    }

    public BoardCell getBoard() {
        return board;
    }

    public void setBoard(BoardCell board) {
        this.board = board;
    }

    private boolean winnerDeclared;
    private BoardCell board;

    void makeMove(Player player, int diceVal){
        if(!winnerDeclared || !player.equals(currentTurnPlayer)) {
            BoardCell currentPosition = player.getPosition();
            if (currentPosition.getVal() + diceVal > 100) {
                return;
            }
            for (int i = 0; i < diceVal; i++) {
                currentPosition = currentPosition.getNext();
            }
            if (currentPosition.getSnake() != null) {
                currentPosition = currentPosition.getSnake();
            }
            if (currentPosition.getLadder() != null) {
                currentPosition = currentPosition.getLadder();
            }
            System.out.println(player.getName() + " rolled a " + diceVal + " and moved from "+ player.getPosition().getVal() +" to "+  currentPosition.getVal());
            player.setPosition(currentPosition);
            if (player.isWinner()) {
                System.out.println(player.getName() +" is winner");
                winnerDeclared=true;
            }
            if(currentPlayerIndex==players.size()-1){
                currentPlayerIndex =0;
                currentTurnPlayer = players.get(0);
            }else{
                currentPlayerIndex++;
                currentTurnPlayer = players.get(currentPlayerIndex);
            }
        }
    };

    public Game(List<Player> players, BoardCell board){
        this.players = players;
        this.currentTurnPlayer = players.get(0);
        this.board = board;
    }

    public Player getNextPlayer() {
        return currentTurnPlayer;
    }
}
