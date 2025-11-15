public class table {
    private byte[][] board;

    public table(int o) {
        this.board = new byte[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]= (byte) o;
            }
        }
    }
    public void arrangement() {
        for(int k=7;k>=0;k--){
                if(k%2==0) {
                    for(int k1=0;k1<8;k1+=2){
                        board[k][k1] = 1;
                    }
                }else {
                    for (int k1 = 1; k1 < 8; k1 += 2) {
                        board[k][k1] = 1;
                    }
                }
        }
    }
    @Override
    public String toString() {
        String s = "";
        s += "    A   B   C   D   E   F   G   H\n";
        for (int i = 0; i < 8; i++) {
            s += (8 - i) + "   ";
            for (int j = 0; j < 8; j++) {
                s += board[i][j] + "\t";
            }
            s += "\n\n";
        }
        return s;
    }
}
