public class Game {
    private Object[][] GameBoard;
    public Game() {
        this.GameBoard = new Object[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                GameBoard[i][j] = "0";
            }
        }
        this.GameBoard[5][2]=new Checkers((byte) 3, (byte) 3, (byte) 1, (byte) 1);
        this.GameBoard[1][6]=new Checkers((byte) 3, (byte) 3, (byte) 1, (byte) 1);
/*
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                GameBoard[i][j] = "0";
                for(int k = 1; k <= 14; k+=2){
                    if(i+j==k && j <3){
                        this.GameBoard[i][j] = new Checkers((byte) i, (byte) j, (byte) 0, (byte) 0);
                    }else if(i+j==k && j > 4){
                        this.GameBoard[i][j] = new Checkers((byte) i, (byte) j, (byte) 1, (byte) 0);
                    }
                }
            }
        }*/
    }
    public Object[][] getGameBoard() {
        return this.GameBoard;
    }
    @Override
    public String toString() {
        String s = "   0    1    2    3    4    5    6    7\n";
        for (int i = 0; i < 8; i++) {
            s+=i;
            for (int j = 0; j < 8; j++) {
                if(GameBoard[j][i]=="0"){
                    s+= "  "+GameBoard[j][i]+"  ";
                }else {
                    s += " " + GameBoard[j][i] + " ";
                }
            }
            s += "\n\n";

        }
        return s;
    }
}
