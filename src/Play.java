import java.sql.SQLOutput;
import java.util.Scanner;
public class Play {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean flagprisvoenia=false;
        checkers current_ch = null;
        boolean flag=false;
        byte current_color = 1;
        while (0 == 0) {
            System.out.println(game);
            System.out.println("Координаты шашки для хода: ");
            while(flagprisvoenia!=true) {
                byte nowx = sc.nextByte();
                byte nowy = sc.nextByte();
                if (game.getGameBoard()[nowx][nowy] != "0") {
                        if(((checkers) game.getGameBoard()[nowx][nowy]).getColor()==current_color) {
                            current_ch = (checkers) game.getGameBoard()[nowx][nowy];
                            flagprisvoenia = true;
                            if(current_ch.getColor()==1){
                                System.out.println("Выбранна черная шашка("+nowx+";" +
                                        ""+nowy+")");
                            }else{
                                System.out.println("Выбранна белая" +
                                        " шашка("+nowx+";"+nowy+")");
                            }
                        }else{
                            System.out.println("Не ваша очередь!");
                        }
                }else {
                    System.out.println("На данных координатах нет шашки вашего цвета, попробуйте снова)");
                    }
                }
            System.out.println("Куда хотите сходить?");
            byte x = sc.nextByte();
            byte y = sc.nextByte();
            flagprisvoenia = false;
            if (current_ch.getColor()==1) {
                if(current_ch.checkKill(game.getGameBoard(),  x, y)==true) {
                    current_ch.killCh(game.getGameBoard(), x, y);
                    System.out.println(current_ch.getX()+"^^"+current_ch.getY());
                }else{
                    current_ch.MotionWhite(game.getGameBoard(), x, y, current_color);
                    System.out.println(current_ch.getX()+"^^"+current_ch.getY());
                }
                if(current_ch.getX()==x & current_ch.getY()==y){
                    num++;
                    current_color = 0;
                }
            } else{
                    if(current_ch.checkKill(game.getGameBoard(),  x, y)==true) {
                        current_ch.killCh(game.getGameBoard(), x, y);
                        System.out.println(current_ch.getX()+"^^"+current_ch.getY());
                    }else{
                        current_ch.MotionWhite(game.getGameBoard(), x, y, current_color);
                        System.out.println(current_ch.getX()+"^^"+current_ch.getY());
                    }
                    if(current_ch.getX()==x & current_ch.getY()==y){
                        num++;
                        current_color = 1;
                    }
                }
            }
    }
        /*System.out.println(game.chb1.getX()+" "+game.chb1.getY());
        System.out.println(game.chb1.checkMotion(game.GameBoard, x,y));
        System.out.println(game.chb1.getX()+game.chb1.getY());*/
}
