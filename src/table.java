public class table {
    int[][] board;

    public table(int o) {
        this.board = new int[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]=o;
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
