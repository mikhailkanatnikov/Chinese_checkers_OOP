
public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        System.out.println("Игра началась. Ходит: "+board.currentPlayer);

        board.makeMove(6,7,5,6);
        board.checkSquareInfo(5,6);
        board.checkSquareInfo(6,7);


    }
}