public class BoardCell {
    public int getVal() {
        return val;
    }

    private final int val;
    private BoardCell next;
    private BoardCell snake;

    private BoardCell ladder;

    public BoardCell getNext() {
        return next;
    }

    public void setNext(BoardCell next) {
        this.next = next;
    }

    public BoardCell getSnake() {
        return snake;
    }

    public void setSnake(BoardCell snake) {
        this.snake = snake;
    }

    public BoardCell getLadder() {
        return ladder;
    }

    public void setLadder(BoardCell ladder) {
        this.ladder = ladder;
    }

    BoardCell(int val){
        this.val = val;
    }

    public boolean isFirst() {
        return this.val==1;
    }

    public boolean isLast() {
        return this.val==100;
    }

    public void addSnake(BoardCell boardCell) {
        this.snake = boardCell;
    }

    public void addLadder(BoardCell boardCell) {
        this.ladder = boardCell;
    }
}
