import java.util.ArrayList;
import java.util.List;

public class BordCellFactory {

    private static volatile BordCellFactory instance = null;

    private BordCellFactory(){}

    public static BordCellFactory getInstance(){
        if(instance==null){
            synchronized (BordCellFactory.class){
                if(instance==null){
                    instance = new BordCellFactory();
                    return instance;
                }
            }
        }
        return instance;
    }


    private List<BoardCell> boardCells = new ArrayList<>();
    private BoardCell firstBoard;

    BoardCell createBoard(List<List<Integer>> snakes, List<List<Integer>> ladders){
        BoardCell temp = new BoardCell(-1);
        for(int i=1;i<=100;i++){
            temp.setNext(new BoardCell(i));
            temp = temp.getNext();
            boardCells.add(temp);
            if(temp.isFirst()){
                firstBoard = temp;
            }
        }
        addSnakes(snakes);
        addLadders(ladders);
        return firstBoard;
    }

    private void addSnakes(List<List<Integer>> snakes) {
        for (List<Integer> snake : snakes) {
            boardCells.get(snake.get(0) - 1).addSnake(boardCells.get(snake.get(1) - 1));
        }
    }

    private void addLadders(List<List<Integer>> ladders) {
        for (List<Integer> ladder : ladders) {
            boardCells.get(ladder.get(0) - 1).addLadder(boardCells.get(ladder.get(1) - 1));
        }
    }
}
