import java.util.Random;
import java.util.Scanner;
public class Play {
    public static boolean theEnd(Object[][] GameBoard) {
        byte countBlack = 0;
        byte countWhite = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (GameBoard[i][j] != "0") {
                    if(((Checkers) GameBoard[i][j]).getColor()==1)
                        countBlack++;
                    else  if(((Checkers) GameBoard[i][j]).getColor()==0)
                        countWhite++;
                }
            }
        }
        if (countBlack == 0 || countWhite == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        boolean end = false;
        boolean flagprisvoenia=false;
        Checkers current_ch = null;
        System.out.println("Введите цвет(1 - черные, 0 - белые, 3 - Рандом)");
        byte current_color = sc.nextByte();
        if (current_color == 3){
            current_color = (byte) rn.nextInt(2);
            if(current_color==1){
                System.out.println("Черные");
            } else{
                System.out.println("Белые");
            }
        }
        while (end == false) {
            System.out.println(game);
            System.out.println("Координаты шашки для хода: ");
            boolean flag_rubka = false;
            short count=0;
            while(!flagprisvoenia) {
                byte nowx = sc.nextByte();
                byte nowy = sc.nextByte();
                        for (int i = 0; i <= 7; i++) {
                            for (int j = 0; j <= 7; j++) {
                                try {
                                    if (((Checkers) game.getGameBoard()[i][j]).checkKill(game.getGameBoard()) == true & ((Checkers) game.getGameBoard()[i][j]).getColor() == current_color) {
                                        flag_rubka = true;
                                        count++;
                                    }
                                } catch (Exception e) {}
                            }
                        }
                    if(flag_rubka) {
                        if (count == 1) {
                            if(current_ch.getClass()==game.getGameBoard()[nowx][nowy].getClass()) {
                                if (((Checkers) game.getGameBoard()[nowx][nowy]).checkKill(game.getGameBoard()) != true) {
                                    System.out.println("Рубка обязательна!");
                                    continue;
                                }
                            }
                        } else {
                            if(current_ch.getClass()==game.getGameBoard()[nowx][nowy].getClass()) {
                                if (((Checkers) game.getGameBoard()[nowx][nowy]).checkKill(game.getGameBoard()) != true) {
                                    System.out.println("Рубка обязательна!");
                                    continue;
                                }
                            }
                        }
                    }
                if (game.getGameBoard()[nowx][nowy] != "0") {
                        if(((Checkers) game.getGameBoard()[nowx][nowy]).getColor()==current_color) {
                            current_ch = (Checkers) game.getGameBoard()[nowx][nowy];
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
            if(current_ch.getX() == x && current_ch.getY() == y) {
                System.out.println("Неверные координаты!");
                continue;
            }
            flagprisvoenia = false;
            if (current_ch.getColor()==1) {
                if(current_ch.checkKill(game.getGameBoard())==true) {
                    while((current_ch.сheckKillForMultiKill(game.getGameBoard())[0])!=-1 & (current_ch.сheckKillForMultiKill(game.getGameBoard())[1])!=-1){
                        current_ch.killCh(game.getGameBoard(), x, y);
                        System.out.println(game);
                        if((current_ch.сheckKillForMultiKill(game.getGameBoard())[0])!=-1 & (current_ch.сheckKillForMultiKill(game.getGameBoard())[1])!=-1) {
                            System.out.println("Рубка обязательна!");
                            x = sc.nextByte();
                            y = sc.nextByte();
                        }
                    }
                }else{
                    current_ch.MotionCh(game.getGameBoard(), x, y, current_color);
                }
                if(current_ch.getX()==x & current_ch.getY()==y){
                    current_color = 0;
                }
            } else{
                    if(current_ch.checkKill(game.getGameBoard())==true) {
                        while((current_ch.сheckKillForMultiKill(game.getGameBoard())[0])!=-1 & (current_ch.сheckKillForMultiKill(game.getGameBoard())[1])!=-1){
                            current_ch.killCh(game.getGameBoard(), x, y);
                            System.out.println(game);
                            if((current_ch.сheckKillForMultiKill(game.getGameBoard())[0])!=-1 & (current_ch.сheckKillForMultiKill(game.getGameBoard())[1])!=-1) {
                                System.out.println("Рубка обязательна!");
                                x = sc.nextByte();
                                y = sc.nextByte();
                            }
                        }

                    }else{
                        current_ch.MotionCh(game.getGameBoard(), x, y, current_color);
                    }
                    if(current_ch.getX()==x & current_ch.getY()==y){
                        current_color = 1;
                    }
                }
            end = theEnd(game.getGameBoard());
            }
        if(current_ch.getColor()==1) {
            System.out.println("ИГРА ОКОНЧЕНА!\nПобедили черные!");
        }else{
            System.out.println("ИГРА ОКОНЧЕНА!\nПобедили белые!");
        }
    }
}
