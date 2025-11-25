public class Game {
    private byte x;
    private  byte y;
    private byte color;
    private String o = "0";
    Сheckers chw1 = new Сheckers((byte) 1,(byte) 0,(byte) 0);
    Сheckers chw2 = new Сheckers((byte) 3,(byte) 0,(byte) 0);
    Сheckers chw3 = new Сheckers((byte) 5,(byte) 0,(byte) 0);
    Сheckers chw4 = new Сheckers((byte) 7,(byte) 0,(byte) 0);
    Сheckers chw5 = new Сheckers((byte) 0,(byte) 1,(byte) 0);
    Сheckers chw6 = new Сheckers((byte) 2,(byte) 1,(byte) 0);
    Сheckers chw7 = new Сheckers((byte) 4,(byte) 1,(byte) 0);
    Сheckers chw8 = new Сheckers((byte) 6,(byte) 1,(byte) 0);
    Сheckers chw9 = new Сheckers((byte) 1,(byte) 2,(byte) 0);
    Сheckers chw10 = new Сheckers((byte) 3,(byte) 2,(byte) 0);
    Сheckers chw11 = new Сheckers((byte) 5,(byte) 2,(byte) 0);
    Сheckers chw12 = new Сheckers((byte) 7,(byte) 2,(byte) 0);

    Сheckers chb1 = new Сheckers((byte) 6,(byte) 7,(byte) 1);
    Сheckers chb2 = new Сheckers((byte) 4,(byte) 7,(byte) 1);
    Сheckers chb3 = new Сheckers((byte) 2,(byte) 7,(byte) 1);
    Сheckers chb4 = new Сheckers((byte) 0,(byte) 7,(byte) 1);
    Сheckers chb5 = new Сheckers((byte) 7,(byte) 6,(byte) 1);
    Сheckers chb6 = new Сheckers((byte) 5,(byte) 6,(byte) 1);
    Сheckers chb7 = new Сheckers((byte) 3,(byte) 6,(byte) 1);
    Сheckers chb8 = new Сheckers((byte) 1,(byte) 6,(byte) 1);
    Сheckers chb9 = new Сheckers((byte) 6,(byte) 5,(byte) 1);
    Сheckers chb10 = new Сheckers((byte) 4,(byte) 5,(byte) 1);
    Сheckers chb11 = new Сheckers((byte) 2,(byte) 5,(byte) 1);
    Сheckers chb12 = new Сheckers((byte) 0,(byte) 5,(byte) 1);


    private Object[][] GameBoard;
    public Game() {
        this.GameBoard = new Object[8][8];
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    GameBoard[i][j]= o;
                }
            }
        this.GameBoard[chw1.getX()][chw1.getY()] = chw1;
        this.GameBoard[chw2.getX()][chw2.getY()] = chw2;
        this.GameBoard[chw3.getX()][chw3.getY()] = chw3;
        this.GameBoard[chw4.getX()][chw4.getY()] = chw4;
        this.GameBoard[chw5.getX()][chw5.getY()] = chw5;
        this.GameBoard[chw6.getX()][chw6.getY()] = chw6;
        this.GameBoard[chw7.getX()][chw7.getY()] = chw7;
        this.GameBoard[chw8.getX()][chw8.getY()] = chw8;
        this.GameBoard[chw9.getX()][chw9.getY()] = chw9;
        this.GameBoard[chw10.getX()][chw10.getY()] = chw10;
        this.GameBoard[chw11.getX()][chw11.getY()] = chw11;
        this.GameBoard[chw12.getX()][chw12.getY()] = chw12;

        this.GameBoard[chb1.getX()][chb1.getY()] = chb1;
        this.GameBoard[chb2.getX()][chb2.getY()] = chb2;
        this.GameBoard[chb3.getX()][chb3.getY()] = chb3;
        this.GameBoard[chb4.getX()][chb4.getY()] = chb4;
        this.GameBoard[chb5.getX()][chb5.getY()] = chb5;
        this.GameBoard[chb6.getX()][chb6.getY()] = chb6;
        this.GameBoard[chb7.getX()][chb7.getY()] = chb7;
        this.GameBoard[chb8.getX()][chb8.getY()] = chb8;
        this.GameBoard[chb9.getX()][chb9.getY()] = chb9;
        this.GameBoard[chb10.getX()][chb10.getY()] = chb10;
        this.GameBoard[chb11.getX()][chb11.getY()] = chb11;
        this.GameBoard[chb12.getX()][chb12.getY()] = chb12;
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
