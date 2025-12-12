
public class Board {

    Checker[][] grid = new Checker[8][8];
    PlayerColor currentPlayer = PlayerColor.WHITE; //белые начинают

    public Board() {
        setupCheckers();
    }

    public void setupCheckers() {
        //создаем шашки
        grid[0][0] = new Checker(0, 0, PlayerColor.BLACK);
        grid[1][0] = new Checker(1, 0, PlayerColor.BLACK);
        grid[2][0] = new Checker(2, 0, PlayerColor.BLACK);
        grid[0][1] = new Checker(0, 1, PlayerColor.BLACK);
        grid[1][1] = new Checker(1, 1, PlayerColor.BLACK);
        grid[0][2] = new Checker(0, 2, PlayerColor.BLACK);

        grid[7][5] = new Checker(7, 5, PlayerColor.WHITE);
        grid[6][6] = new Checker(6, 6, PlayerColor.WHITE);
        grid[7][6] = new Checker(7, 6, PlayerColor.WHITE);
        grid[5][7] = new Checker(5, 7, PlayerColor.WHITE);
        grid[6][7] = new Checker(6, 7, PlayerColor.WHITE);
        grid[7][7] = new Checker(7, 7, PlayerColor.WHITE);
    }

    public boolean isXYinBoard(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    public boolean isSquareEmpty(int x, int y) {
        return (isXYinBoard(x, y)) && (grid[x][y] == null);
    }

    public Checker getCheckerAt(int x, int y) {
        if (isSquareEmpty(x, y) || !isXYinBoard(x, y)) {
            return null;
        } else {
            return grid[x][y];
        }
    }


}