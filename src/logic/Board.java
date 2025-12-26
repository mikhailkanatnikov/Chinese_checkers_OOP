package logic;

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

    public boolean isCheckerBelongToCurrent(int x, int y) {
        Checker checker = getCheckerAt(x, y);
        return (checker != null) && (checker.color == currentPlayer);
    }


    public boolean isValidStep(int fromX, int fromY, int toX, int toY) {
        return isCheckerBelongToCurrent(fromX, fromY) &&
                isSquareEmpty(toX, toY) &&
                Math.abs(toX - fromX) == 1 && Math.abs(toY - fromY) == 1;
    }

    public boolean isValidJump(int fromX, int fromY, int toX, int toY) {
        return isCheckerBelongToCurrent(fromX, fromY) &&
                isSquareEmpty(toX, toY) &&
                Math.abs(toX - fromX) == 2 && Math.abs(toY - fromY) == 2 &&
                !isSquareEmpty(Math.abs(toX + fromX) / 2, Math.abs(toY + fromY) / 2);
    }

    public boolean canMove(int fromX, int fromY, int toX, int toY) {
        return isValidJump(fromX, fromY, toX, toY) || isValidStep(fromX, fromY, toX, toY);

    }

    public void makeMove(int fromX, int fromY, int toX, int toY) {
        if (!canMove(fromX, fromY, toX, toY)) {
            throw new IllegalArgumentException("Недопустимый ход!");
        } else {

            //перемещение
            Checker checker = getCheckerAt(fromX, fromY);
            grid[toX][toY] = checker;
            grid[fromX][fromY] = null;

            checker.x = toX;
            checker.y = toY;

            //////////////////////проверка победы//////////////////////////////////
            if (checkWin(currentPlayer)) {
                if (currentPlayer == PlayerColor.BLACK) {
                    System.out.println("Конец игры. Выиграли черные");
                } else {
                    System.out.println("Конец игры. Выиграли белые");
                }
            }

                //сменить игрока
                if (currentPlayer.equals(PlayerColor.WHITE)) {
                    currentPlayer = PlayerColor.BLACK;
                } else {
                    currentPlayer = PlayerColor.WHITE;
                }
            }
        }

        public void checkSquareInfo ( int x, int y){

            if (isSquareEmpty(x, y)) {
                System.out.println("В клетке (" + x + ";" + y + ") ничего нет");
            } else {
                if (getCheckerAt(x, y).color.equals(PlayerColor.WHITE)) {
                    System.out.println("В клетке (" + x + ";" + y + ") есть БЕЛАЯ шашка");
                } else {
                    System.out.println("В клетке (" + x + ";" + y + ") есть ЧЕРНАЯ шашка");
                }
            }


        }

        public boolean checkWin (PlayerColor color){
            int[][] targets;
            int[][] whiteTarget = {{0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 1}, {0, 2}};
            int[][] blackTarget = {{7, 5}, {6, 6}, {7, 6}, {5, 7}, {6, 7}, {7, 7}};

            if (color == PlayerColor.WHITE) {
                targets = whiteTarget;
            } else {
                targets = blackTarget;
            }

            for (int[] cell : targets) {
                if (grid[cell[0]][cell[1]] == null || grid[cell[0]][cell[1]].color != color) {
                    return false;
                }
            }
            return true;
        }


    }


