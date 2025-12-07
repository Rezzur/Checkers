import java.util.Scanner;

public class PlayCheckers {
    public static boolean theEnd(Object[][] GameBoard) {
        byte countBlack = 0;
        byte countWhite = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!"0".equals(GameBoard[i][j])) {
                    assert GameBoard[i][j] instanceof Checkers;
                    if (((Checkers) GameBoard[i][j]).getColor() == 1)
                        countBlack++;
                    else if (((Checkers) GameBoard[i][j]).getColor() == 0)
                        countWhite++;
                }
            }
        }
        if (countBlack == 0 || countWhite == 0) {
            return true;
        }
        return false;
    }

    public static class Main {
        private Game game; // Игровая доска
        private boolean end; // Флаг конца игры
        private boolean flagprisvoenia; // Флаг присвоения текущей шашки
        private boolean flagColor; // Флаг присвоения цвета
        private Checkers current_ch; // Текущая шашка
        private byte current_color = -1; // Цвет шашки 1 - черные, 0 - белые
        private byte type; // Тип
        private byte currentX;
        private byte currentY;
        Scanner sc = new Scanner(System.in);
        public Main() { // Конструктор класса мэйн, где присваивается текущая шашка
            game = new Game();
            flagprisvoenia = false;
            current_ch = null;
            current_color = -1;
            end = false;
            flagColor = false;
        }
        public Checkers getCurrent_ch() {
            return current_ch;
        }
        public void identificationChecker(boolean flagprisvoenia, Checkers current_ch) {
            while (!flagColor) { // Цикл выбора цвета
                System.out.println("0 - Белый цвет\n1 - Черный цвет\nВведите цвет:");
                try {
                    current_color = sc.nextByte();
                } catch (Exception e) {
                    System.out.println("Выбран неверный цвет");
                    sc.nextLine();
                }
                if (current_color == 0 || current_color == 1) {
                    flagColor = true;
                    if (current_color == 0) System.out.println("Выбран белый цвет");
                    if (current_color == 1) System.out.println("Выбран черный цвет");
                } else {
                    System.out.println("Выбран неверный цвет");
                }
            }
            while (!flagprisvoenia) { // Цикл выбора шашки
                System.out.println("Выберите координаты вашей шашки: ");
                try {
                    currentX = sc.nextByte();
                    currentY = sc.nextByte();
                    if (currentX < 0 || currentY < 0 || currentX > 8 || currentY > 8) {
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Вы ввели неверные координаты.");
                    sc.nextLine();
                    continue;
                }
                if (!"0".equals(game.getGameBoard()[currentX][currentY])) {
                    current_ch = (Checkers) game.getGameBoard()[currentX][currentY];
                    if (current_ch.getColor() == current_color) {
                        if (current_ch.getColor() == 1) {
                            if (current_ch.getType() == 0)
                                System.out.println("Выбрана шашка черного цвета " + "(" + currentX + ":" + currentY + ")");
                            else
                                System.out.println("Выбрана шашка(Дамка) черного цвета " + "(" + currentX + ":" + currentY + ")");
                            flagprisvoenia = true;
                        } else {
                            if (current_ch.getType() == 0)
                                System.out.println("Выбрана шашка белого цвета " + "(" + currentX + ":" + currentY + ")");
                            else
                                System.out.println("Выбрана шашка(Дамка) белого цвета " + "(" + currentX + ":" + currentY + ")");
                            flagprisvoenia = true;
                        }
                    }else System.out.println("Не ваша очередь");
                } else System.out.println("На выбранных координатах нет шашки");
            }
        }

        public void play() {
            identificationChecker(false, getCurrent_ch());
        }
    }

    public static void main(String[] args) {
            Main m = new Main();
            m.play();

    }
}
