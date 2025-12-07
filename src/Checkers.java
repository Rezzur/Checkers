public class Checkers {
    private byte x;
    private byte y;
    private byte color;
    public byte type;
    byte[] arr = new byte[]{1, -1};

    public byte getType() {
        return this.type;
    }

    public void killQueen(Object[][] GameBoard, byte x, byte y) {
        byte dx;
        byte dy;
        byte nowx = this.x;
        byte nowy = this.y;
        if (!"0".equals(GameBoard[x][y])) {
            System.out.println("Сюда сходить не можете!");
        } else {
            if (this.x < x) dx = 1;
            else dx = -1;
            if (this.y < y) dy = 1;
            else dy = -1;
            if (Math.abs(this.x - x) == Math.abs(this.y - y)) {
                while (nowx != x && nowy != y) {
                    nowx += dx;
                    nowy += dy;
                    if ((nowx < 8 && nowx > 0) && (nowx < 8 && nowx > 0)) {
                        if ("0".equals(GameBoard[nowx][nowy])) {
                            motion(GameBoard, nowx, nowy);
                        } else {
                            killCh(GameBoard, (byte) (nowx + dx), (byte) (nowy + dy));
                            nowx += dx;
                            nowy += dy;
                        }
                    }
                }
            }
        }
    }
    public boolean checkKillQueen(Object[][] GameBoard) {
        for (byte dx : arr){
            for (byte dy : arr) {
                byte nowx = (byte)(this.x+dx);
                byte nowy = (byte)(this.y+dy);
                while ((nowx >=0 && nowx <=7) && (nowy >=0 && nowy<=7)) {
                    System.out.println("(" + nowx + ":" + nowy + ")");
                        if (!"0".equals(GameBoard[nowx][nowy])&&(nowx+dx < 8 && nowx+dx > 0 && nowy+dy < 8 && nowy+dy > 0)){
                            if("0".equals(GameBoard[nowx + dx][nowy + dy])) {
                                return true;
                            }
                        }
                    nowx += dx;
                    nowy += dy;
                }
            }
        }
        return false;
    }

    /*
    public byte[] checkKillQueen1(Object[][] GameBoard, byte x, byte y, byte type){
        byte dx=this.x;
        byte dy=this.y;
        byte sumInd=(byte) (dx+dy);
        byte[] arr = new byte[]{-1,-1};
        for(byte i = sumInd;i>=0; i--){
            for(byte j = 0; j<=sumInd; j++){
                if(i!=dx && j!=dy){
                    if (!"0".equals(GameBoard[i][j])) {
                        arr[0]=i;
                        arr[1]=j;
                    }
                }
            }
        }
        return arr;
    }
    public byte[] checkKillQueen2(Object[][] GameBoard, byte x, byte y, byte type){
        byte dx=this.x;
        byte dy=this.y;
        byte minInd;
        if(dx>dy) {
            minInd = dy;
        }else {
            minInd = dx;
        }
        byte[] arr = new byte[]{-1,-1};
        for(byte i = 1;minInd<8; i++){
            if(!"0".equals(GameBoard[dx+i][dy+i])){
                arr[0]= (byte) (dx+i);
                arr[1]= (byte) (dy+i);
                }
            }
        return arr;
    }
    public byte[] checkQueenKill(Object[][] GameBoard, byte x, byte y, byte type) {
        byte[] arr = new byte[2];
        if(((Checkers) GameBoard[this.x][this.y]).checkKillQueen2(GameBoard, x, y, type)[0]!=-1){
            arr = ((Checkers) GameBoard[this.x][this.y]).checkKillQueen2(GameBoard, x, y, type);
        }
        if(((Checkers) GameBoard[this.x][this.y]).checkKillQueen1(GameBoard, x, y, type)[0]!=-1)
            arr=((Checkers) GameBoard[this.x][this.y]).checkKillQueen1(GameBoard, x, y, type);
        return arr;
    }
*/
    public boolean checkMotionQueen(byte x, byte y, byte type) {
        if (type == 1) {
            if (Math.abs(this.x - x) == Math.abs(this.y - y)) {
                return true;
            }
        }
        return false;
    }

    public void motionQueen(Object[][] GameBoard, byte x, byte y) {
        motion(GameBoard, x, y);
    }

    public Checkers(byte x, byte y, byte color, byte type) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = type;
    }

    public boolean indexCheck(byte i, byte j) {
        return this.x + i <= 7 &&
                this.y + j <= 7 &&
                this.x + i >= 0 &&
                this.y + j >= 0;
    }

    public byte getX() {
        return this.x;
    }

    public byte getY() {
        return this.y;
    }

    public byte[] сheckKillForMultiKill(Object[][] GameBoard) {
        for (byte i : arr) {
            for (byte j : arr) {
                if (indexCheck(i, j) && indexCheck((byte) (i * 2), (byte) (j * 2))) {
                    if (!"0".equals(GameBoard[this.x + i][this.y + j]) & "0".equals(GameBoard[this.x + i * 2][this.y + j * 2])) {
                        if (((Checkers) GameBoard[this.x + i][this.y + j]).getColor() != this.color) {
                            byte[] arr = new byte[]{((byte) (this.x + i * 2)), ((byte) (this.y + j * 2))};
                            return arr;
                        }
                    }
                }
            }
        }
        byte[] arr = new byte[]{-1, -1};
        return arr;
    }

    public boolean checkMotion(Object[][] GameBoard, byte x, byte y, byte color) {
        if (color == 0) {
            for (byte i : arr) {
                // Если цвет шашки белый, то он может ходить только вперед.
                if (indexCheck(i, (byte) 1)) {
                    if (y == this.y + 1 & x == this.x + i) {
                        if ("0".equals(GameBoard[this.x + i][this.y + 1])) {
                            return true;
                        }
                    }
                }
            }
        } else if (color == 1) {
            // Если цвет шашки черный, то он может ходить только вперед.
            for (byte i : arr) {
                if (indexCheck(i, (byte) -1)) {
                    if (y == this.y - 1 & x == this.x + i) {
                        if ("0".equals(GameBoard[this.x + i][this.y - 1])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void killCh(Object[][] GameBoard, byte x, byte y) {
        for (byte i : arr) {
            for (byte j : arr) {
                if (indexCheck(i, j) && indexCheck((byte) (i * 2), (byte) (j * 2))) {
                    if (!"0".equals(GameBoard[this.x + i][this.y + j]) & "0".equals(GameBoard[this.x + i * 2][this.y + j * 2]) & (this.x + i * 2 == x & this.y + j * 2 == y)) {
                        if (((Checkers) GameBoard[this.x + i][this.y + j]).getColor() != this.color) {
                            GameBoard[this.x + i][this.y + j] = "0";
                            motion(GameBoard, x, y);
                        }
                    }
                }
            }
        }
    }

    public void motion(Object[][] GameBoard, byte x, byte y) {
        GameBoard[x][y] = GameBoard[this.getX()][this.getY()];
        GameBoard[this.x][this.y] = "0";
        this.x = x;
        this.y = y;
    }

    public void MotionCh(Object[][] GameBoard, byte x, byte y, byte color) {
        if (checkMotion(GameBoard, x, y, color)) {
            motion(GameBoard, x, y);
        }
    }

    public boolean checkKill(Object[][] GameBoard) {
        for (byte i : arr) {
            for (byte j : arr) {
                if (indexCheck(i, j) && indexCheck((byte) (i * 2), (byte) (j * 2))) {
                    if (!"0".equals(GameBoard[this.x + i][this.y + j]) & "0".equals(GameBoard[this.x + i * 2][this.y + j * 2])) {
                        if (((Checkers) GameBoard[this.x + i][this.y + j]).getColor() != this.color) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public byte getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        if (this.color == 1) {
            return "|1|";
        }
        return "|0|";
    }
}