public class Game {
    private byte x = 6;
    private  byte y =7;
    private byte color = 1;
    private String o = "0";
    checkers chb1 = new checkers(x,y,color);
    checkers chw1 = new checkers((byte) 1,(byte) 0,(byte) 0);
    checkers chw2 = new checkers((byte) 3,(byte) 0,(byte) 0);
    checkers chw3 = new checkers((byte) 5,(byte) 0,(byte) 0);
    checkers chw4 = new checkers((byte) 7,(byte) 0,(byte) 0);
    checkers chw5 = new checkers((byte) 0,(byte) 1,(byte) 0);
    checkers chw6 = new checkers((byte) 2,(byte) 1,(byte) 0);
    checkers chw7 = new checkers((byte) 4,(byte) 1,(byte) 0);
    checkers chw8 = new checkers((byte) 6,(byte) 1,(byte) 0);
    checkers chw9 = new checkers((byte) 1,(byte) 2,(byte) 0);
    checkers chw10 = new checkers((byte) 3,(byte) 2,(byte) 0);
    checkers chw11 = new checkers((byte) 5,(byte) 2,(byte) 0);
    checkers chw12 = new checkers((byte) 7,(byte) 2,(byte) 0);


    Object[][] GameBoard = new Object[8][8];
    public Game() {
        this.GameBoard = new Object[8][8];
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    GameBoard[i][j]= o;
                }
            }
        this.GameBoard[chb1.getX()][chb1.getY()] = chb1;
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

    }
    private short num = 2;
    public void play(checkers ch, byte x, byte y,Object[][] GameBoard) {
        if (num % 2 == 0) {
            if (ch.getColor() == 1) {
                ch.MotionWhite(GameBoard, x, y, ch.getColor());
                num++;
            }
        } else {
            if (ch.getColor() == 0) {
                ch.MotionWhite(GameBoard, x, y, ch.getColor());
                num++;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 8; i++) {
            s += "   ";
            for (int j = 0; j < 8; j++) {
                s += GameBoard[j][i] + "\t";
            }
            s += "\n\n";
        }
        return s;
    }
}
