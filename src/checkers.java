public class checkers {
    private byte x;
    private byte y;
    private byte color;
    public byte type;
    // Конструктор шашек
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
    // Проверка возможен ли ход. Возвращает true если ход возможен
    public boolean checkMotion(Object[][] GameBoard, byte x, byte y, byte color){
        if(color == 0) {
            // Если цвет шашки белый, то он может ходить только вперед.
            if (y == this.y + 1 & ((x == this.x - 1) || (x == this.x + 1))) {
                if (GameBoard[this.x+1][this.y+1]=="0" || GameBoard[this.x-1][this.y+1]=="0") {
                    return true;
                }
            }
        } else if (color == 1) {
            // Если цвет шашки черный, то он может ходить только вперед.
            if (y == this.y - 1 & ((x == this.x - 1) || (x == this.x + 1))) {
                if (GameBoard[this.x+1][this.y-1]=="0" || GameBoard[this.x-1][this.y-1]=="0") {
                    return true;
                }
            }
        }
        return false;
    }
    public void killCh(Object[][] GameBoard, byte x, byte y) {
        try {
            if ((GameBoard[this.x + 1][this.y + 1] != "0" & GameBoard[this.x + 2][this.y + 2] == "0" & (this.x + 2 == x & this.y + 2 == y))) {
                if (((checkers) GameBoard[this.x + 1][this.y + 1]).getColor() != this.color) {
                    GameBoard[x][y] = GameBoard[this.getX()][this.getY()];
                    GameBoard[this.x][this.y] = "0";
                    GameBoard[this.x + 1][this.y + 1] = "0";
                    this.x = x;
                    this.y = y;
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
// Добавить проверку границ.
        try {
            if ((GameBoard[this.x + 1][this.y - 1] != "0" & GameBoard[this.x + 2][this.y - 2] == "0" & (this.x + 2 == x & this.y - 2 == y))) {
                if (((checkers) GameBoard[this.x + 1][this.y - 1]).getColor() != this.color) {
                    GameBoard[x][y] = GameBoard[this.getX()][this.getY()];
                    GameBoard[this.x][this.y] = "0";
                    GameBoard[this.x + 1][this.y - 1] = "0";
                    this.x = x;
                    this.y = y;
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        try {
            if ((GameBoard[this.x - 1][this.y + 1] != "0" & GameBoard[this.x - 2][this.y + 2] == "0" & (this.x - 2 == x & this.y + 2 == y))) {
                if (((checkers) GameBoard[this.x - 1][this.y + 1]).getColor() != this.color) {
                    GameBoard[x][y] = GameBoard[this.getX()][this.getY()];
                    GameBoard[this.x][this.y] = "0";
                    GameBoard[this.x - 1][this.y + 1] = "0";
                    this.x = x;
                    this.y = y;
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        try {
            if ((GameBoard[this.x - 1][this.y - 1] != "0" & GameBoard[this.x - 2][this.y - 2] == "0" & (this.x - 2 == x & this.y - 2 == y))) {
                if (((checkers) GameBoard[this.x - 1][this.y - 1]).getColor() != this.color) {
                    GameBoard[x][y] = GameBoard[this.getX()][this.getY()];
                    GameBoard[this.x][this.y] = "0";
                    GameBoard[this.x - 1][this.y - 1] = "0";
                    this.x = x;
                    this.y = y;
                }
            }

        } catch (Exception e) {
            System.out.println();
        }
    }
    public void MotionWhite(Object[][] GameBoard, byte x, byte y, byte color) {
        if (checkMotion(GameBoard, x, y, color) == true) {
            GameBoard[x][y] =  GameBoard[this.x][this.y];
            GameBoard[this.x][this.y] = "0";
            this.x = x;
            this.y = y;
        }
    }
    public boolean checkKill(Object[][] GameBoard, byte x, byte y) {
        if((this.x <= 5 & this.x >=0)&(this.y <= 5 & this.y >=0)){
            if (GameBoard[this.x + 1][this.y + 1] != "0" & GameBoard[this.x + 2][this.y + 2] == "0") {
                if (((checkers) GameBoard[this.x + 1][this.y + 1]).getColor() != this.color) {
                    return true;
                }
            }
        }
        if((this.x <= 5 & this.x >=0)&(this.y <= 7 & this.y >=2)) {
            if (GameBoard[this.x + 1][this.y - 1] != "0" & GameBoard[this.x + 2][this.y - 2] == "0") {
                if (((checkers) GameBoard[this.x + 1][this.y - 1]).getColor() != this.color) {
                    return true;
                }
            }
        }
        if((this.x <= 7 & this.x >=2)&(this.y <= 5 & this.y >=0)) {
            if (GameBoard[this.x - 1][this.y + 1] != "0" & GameBoard[this.x - 2][this.y + 2] == "0") {
                if (((checkers) GameBoard[this.x - 1][this.y + 1]).getColor() != this.color) {
                    return true;
                }
            }
        }
        if((this.x <= 7 & this.x >=2)&(this.y <= 7 & this.y >=2)) {
            if (GameBoard[this.x - 1][this.y - 1] != "0" & GameBoard[this.x - 2][this.y - 2] == "0") {
                if (((checkers) GameBoard[this.x - 1][this.y - 1]).getColor() != this.color) {
                    return true;
                }
            }
        }
        return false;
    }
    public byte getColor(){
        return this.color;
    }
    @Override
    public String toString(){
        if (this.color == 1){
            return "|1|";
        }
        return "|0|";
    }
}
