public class Сheckers {
    private byte x;
    private byte y;
    private byte color;
    public byte type;
    public Сheckers(byte x, byte y, byte color){
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
    public byte[] сheckKillForMultiKill(Object[][] GameBoard){
        if((this.x <=5)&(this.y <= 5)){
            if (GameBoard[this.x + 1][this.y + 1] != "0" & GameBoard[this.x + 2][this.y + 2] == "0") {
                if (((Сheckers) GameBoard[this.x + 1][this.y + 1]).getColor() != this.color) {
                    byte[] arr = new byte[]{((byte) (this.x+2)),((byte) (this.y+2))};
                    return arr;
                }
            }
        }
        if((this.x <=5)&(this.y <= 7 & this.y >=2)) {
            if (GameBoard[this.x + 1][this.y - 1] != "0" & GameBoard[this.x + 2][this.y - 2] == "0") {
                if (((Сheckers) GameBoard[this.x + 1][this.y - 1]).getColor() != this.color) {
                    byte[] arr = new byte[]{((byte) (this.x+2)),((byte) (this.y-2))};
                    return arr;
                }
            }
        }
        if((this.x <= 7 & this.x >=2)&(this.y <= 5)) {
            if (GameBoard[this.x - 1][this.y + 1] != "0" & GameBoard[this.x - 2][this.y + 2] == "0") {
                if (((Сheckers) GameBoard[this.x - 1][this.y + 1]).getColor() != this.color) {
                    byte[] arr = new byte[]{((byte) (this.x-2)),((byte) (this.y+2))};
                    return arr;
                }
            }
        }
        if((this.x <= 7 & this.x >=2)&(this.y <= 7 & this.y >=2)) {
            if (GameBoard[this.x - 1][this.y - 1] != "0" & GameBoard[this.x - 2][this.y - 2] == "0") {
                if (((Сheckers) GameBoard[this.x - 1][this.y - 1]).getColor() != this.color) {
                    byte[] arr = new byte[]{((byte) (this.x-2)),((byte) (this.y-2))};
                    return arr;
                }
            }
        }
        byte[] arr = new byte[]{-1,-1};
        return arr;
    }
    public boolean checkMotion(Object[][] GameBoard, byte x, byte y, byte color){
        if(color == 0) {
            // Если цвет шашки белый, то он может ходить только вперед.
            try {
                if (y == this.y + 1 & x == this.x + 1) {
                    if (GameBoard[this.x + 1][this.y + 1] == "0") {
                        return true;
                    }
                }
            }catch (Exception e){}
            try {
                if (y == this.y + 1 & x == this.x - 1) {
                    if (GameBoard[this.x - 1][this.y + 1] == "0") {
                        return true;
                    }
                }
            }catch (Exception e){}

        } else if (color == 1) {
            // Если цвет шашки черный, то он может ходить только вперед.
            try {
                if (y == this.y - 1 & x == this.x + 1) {
                    if (GameBoard[this.x + 1][this.y - 1] == "0") {
                        return true;
                    }
                }
            }catch (Exception e){}
            try {
                if (y == this.y - 1 & x == this.x - 1) {
                    if (GameBoard[this.x - 1][this.y - 1] == "0") {
                        return true;
                    }
                }
            }catch (Exception e){}

        }
        return false;
    }
    public void killCh(Object[][] GameBoard, byte x, byte y) {
        try {
            if ((GameBoard[this.x + 1][this.y + 1] != "0" & GameBoard[this.x + 2][this.y + 2] == "0" & (this.x + 2 == x & this.y + 2 == y))) {
                if (((Сheckers) GameBoard[this.x + 1][this.y + 1]).getColor() != this.color) {
                    GameBoard[this.x + 1][this.y + 1] = "0";
                    motion(GameBoard, x, y);
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        try {
            if ((GameBoard[this.x + 1][this.y - 1] != "0" & GameBoard[this.x + 2][this.y - 2] == "0" & (this.x + 2 == x & this.y - 2 == y))) {
                if (((Сheckers) GameBoard[this.x + 1][this.y - 1]).getColor() != this.color) {
                    GameBoard[this.x + 1][this.y - 1] = "0";
                    motion(GameBoard, x, y);
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        try {
            if ((GameBoard[this.x - 1][this.y + 1] != "0" & GameBoard[this.x - 2][this.y + 2] == "0" & (this.x - 2 == x & this.y + 2 == y))) {
                if (((Сheckers) GameBoard[this.x - 1][this.y + 1]).getColor() != this.color) {
                    GameBoard[this.x - 1][this.y + 1] = "0";
                    motion(GameBoard, x, y);
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        try {
            if ((GameBoard[this.x - 1][this.y - 1] != "0" & GameBoard[this.x - 2][this.y - 2] == "0" & (this.x - 2 == x & this.y - 2 == y))) {
                if (((Сheckers) GameBoard[this.x - 1][this.y - 1]).getColor() != this.color) {
                    GameBoard[this.x - 1][this.y - 1] = "0";
                    motion(GameBoard, x, y);
                }
            }

        } catch (Exception e) {
            System.out.println();
        }
    }
    public void motion(Object[][] GameBoard, byte x, byte y){
        GameBoard[x][y] = GameBoard[this.getX()][this.getY()];
        GameBoard[this.x][this.y] = "0";
        this.x = x;
        this.y = y;
    }
    public void MotionCh(Object[][] GameBoard, byte x, byte y, byte color) {
        if (checkMotion(GameBoard, x, y, color) == true) {
            motion(GameBoard, x, y);
        }
    }
    public boolean checkKill(Object[][] GameBoard) {
        try {
            if ((this.x <= 5 & this.x >= 0) & (this.y <= 5 & this.y >= 0)) {
                if (GameBoard[this.x + 1][this.y + 1] != "0" & GameBoard[this.x + 2][this.y + 2] == "0") {
                    if (((Сheckers) GameBoard[this.x + 1][this.y + 1]).getColor() != this.color) {
                        return true;
                    }
                }
            }
            if ((this.x <= 5 & this.x >= 0) & (this.y <= 7 & this.y >= 2)) {
                if (GameBoard[this.x + 1][this.y - 1] != "0" & GameBoard[this.x + 2][this.y - 2] == "0") {
                    if (((Сheckers) GameBoard[this.x + 1][this.y - 1]).getColor() != this.color) {
                        return true;
                    }
                }
            }
            if ((this.x <= 7 & this.x >= 2) & (this.y <= 5 & this.y >= 0)) {
                if (GameBoard[this.x - 1][this.y + 1] != "0" & GameBoard[this.x - 2][this.y + 2] == "0") {
                    if (((Сheckers) GameBoard[this.x - 1][this.y + 1]).getColor() != this.color) {
                        return true;
                    }
                }
            }
            if ((this.x <= 7 & this.x >= 2) & (this.y <= 7 & this.y >= 2)) {
                if (GameBoard[this.x - 1][this.y - 1] != "0" & GameBoard[this.x - 2][this.y - 2] == "0") {
                    if (((Сheckers) GameBoard[this.x - 1][this.y - 1]).getColor() != this.color) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {}
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