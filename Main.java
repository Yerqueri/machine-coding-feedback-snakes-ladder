import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BordCellFactory bordCellFactory = BordCellFactory.getInstance();
        Scanner in = new Scanner(System.in);
        List<List<Integer>> snakes = new ArrayList<>();
        List<List<Integer>> ladders = new ArrayList<>();
        String player1Name = "";
        String player2Name = "";
        int snakeCount = Integer.parseInt(in.nextLine());
        for(int i=0;i<snakeCount;i++){
            String next = in.nextLine();
            String[] split = next.split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            snakes.add(List.of(from,to));
        }
        int ladderCount = Integer.parseInt(in.nextLine());
        for(int i=0;i<ladderCount;i++){
            String next = in.nextLine();
            String[] split = next.split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            ladders.add(List.of(from,to));
        }
        List<String> playerNames  = new ArrayList<>();
        int playerCount = Integer.parseInt(in.nextLine());
        for(int i=0;i<playerCount;i++){
            playerNames.add(in.nextLine());
        }
        List<Player> players = new ArrayList<>();
        in.close();
        BoardCell boardCell = BordCellFactory.getInstance().createBoard(snakes,ladders);
        for(String player: playerNames){
            players.add(new Player(player, boardCell));
        }
        Game game = new Game(players,boardCell);
        while(!game.isWinnerDeclared()){
            Player player = game.getNextPlayer();
            int diceRoll = player.rollDice();
            game.makeMove(player,diceRoll);
        }
    }
}
