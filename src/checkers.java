public class checkers {
    private byte x;
    private byte y;
    private byte color;
    public byte type;
    public checkers(byte x,byte y,byte color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public byte getX(){
        return this.x;
    }

    public byte getY() {
        return this.y;
    }

    public boolean checkMotion(Object[][] GameBoard, byte x, byte y, byte color){
        if(color == 0) {
            if (y == this.y + 1 & ((x == this.x - 1) || (x == this.x + 1))) {
                return true;
            }
        } else if (color == 1) {
            if (y == this.y - 1 & ((x == this.x - 1) || (x == this.x + 1))) {
                return true;
            }
        }
        return false;
    }
    public void MotionWhite(Object[][] GameBoard, byte x, byte y, byte color) {
        if (checkMotion(GameBoard, x, y, color) == true) {
            GameBoard[x][y] = new checkers(x, y, color);
            GameBoard[this.x][this.y] = "0";
            this.x = x;
            this.y = y;
        }
    }

    public byte getColor(){
        return this.color;
    }
    public static  void main(String[] args){
        table table = new table(0);
        table.arrangement();
        System.out.println(table);
    }
    @Override
    public String toString(){
        if (this.color == 1){
            return "|1|";
        }
        return "|0|";
    }
}
