import java.sql.SQLOutput;
import java.util.*;


public class TicTacLul {

    public static int BOARD_SIZE = 3;
    static Scanner sc = new Scanner(System.in);
    static String[] field;
    static String winner = null;
    static int countround = 0;
    static int pocether = 0;

    public static String playerA = "X";
    public static String playerB = "O";

    public static void main(String[] args) {
        do {
            field = new String[BOARD_SIZE * BOARD_SIZE];
            for (int i = 0; i < field.length; i++) {
                field[i] = "" + (i + 1);
            }

            if(pocether==0) {
                System.out.println("Vítej v ťik ťac tou");
            }
            else if(pocether>0){
                System.out.println("Máš asi hodně boring life, že hraješ tuhle hru, ale tady máš nové poleso");
            }
            printfield();

            win();
            if (winner != null) {
                System.out.println("Let's gou " + winner + " vyhráli.");
                novaHra();
            }

        }while(1<2);
    }
    public static void novaHra(){

        System.out.println("Chceš hrát další kolesa a křížosky?");
        Scanner sc = new Scanner(System.in);
        int proceed;
        proceed = sc.nextInt();
        switch (proceed){
            case 1: {
                winner = null;
                countround = 0;
                pocether++;

                break;
            }
            case 2: {
                
                return;
            }
            default: {

            }
        }
    }
    static String checkViteza() {
        for (int i = 0; i <= 7; i++) {
            String row = switch (i) {
                case 0 -> field[0] + field[1] + field[2];
                case 1 -> field[3] + field[4] + field[5];
                case 2 -> field[6] + field[7] + field[8];
                case 3 -> field[0] + field[3] + field[6];
                case 4 -> field[1] + field[4] + field[7];
                case 5 -> field[2] + field[5] + field[8];
                case 6 -> field[0] + field[4] + field[8];
                case 7 -> field[2] + field[4] + field[6];
                default -> null;
            };


            if (row.equals("XXX")) {
                return "Křížosky";
            }
            else if (row.equals("OOO")) {
                return "Kolesa";
            }
            else if(i==7){
                System.out.println("Další kolo lulw");
            }


        }

        return null;
    }

    public static void movePlayerA() {
        System.out.println("Hráč " + playerA + " je na řadě");

    }

    public static void movePlayerB() {
        System.out.println("Hráč " + playerB + " je na řadě");
    }


    public static void printfield() {
        for (int i = 0; i < field.length; i++) {
            if(i% BOARD_SIZE == 0){
                System.out.print("| ");
            }
            System.out.print(field[i] + " | ");
            if ((i + 1) % BOARD_SIZE == 0) {
                System.out.println("");
            }
        }
        System.out.println();
    }

    public static String win() {

        while (winner == null) {
            int playerInputos;

            got:

            if (countround % 2 == 1) {
                movePlayerA();
                playerInputos = sc.nextInt();
                if (field[playerInputos- 1].compareTo(playerB) == 0 || field[playerInputos- 1].compareTo(playerA) == 0) {
                    countround--;
                    break got;

                }
                field[playerInputos - 1] = playerA;

            } else if (countround % 2 == 0) {
                movePlayerB();
                 playerInputos = sc.nextInt();
                if (field[playerInputos- 1].compareTo(playerB) == 0 || field[playerInputos- 1].compareTo(playerA) == 0) {
                    countround--;
                    break got;
                }
                field[playerInputos - 1] = playerB;
            }


            printfield();
            winner = checkViteza();
            countround++;
            if (countround > 8) {
                System.out.println("Remízos");
                novaHra();
                return winner;


            }

        }

        return winner;
    }

}



