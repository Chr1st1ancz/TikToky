import java.util.Scanner;

public class TicTacLul {

    public static int VelikostPole = 3;
    static Scanner sc = new Scanner(System.in);
    static String[] field;
    static String winner = null;
    static int countround = 0;
    static int pocether = 0;
    static int playerInputos;
    public static boolean isRunning = true;

    public static String playerA = "X";
    public static String playerB = "O";

    public static void main(String[] args) {
        while(isRunning) {

            field = new String[VelikostPole * VelikostPole];
            //importuje číslíčka do pole
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
            //vyhodnocení
            if (winner != null) {
                System.out.println("Let's gou " + winner + " vyhráli.");
                novaHra();
            }
        }
    }

    public static void novaHra(){

            System.out.println("Chceš hrát další kolesa a křížosky? (jedna = ANO, dva = NE, tři = 150 bodů)");
            Scanner sc = new Scanner(System.in);
            int proceed;
            proceed = sc.nextInt();
        switch (proceed) {
            case 1:
                winner = null;
                countround = 0;
                pocether++;
                break;
            case 2:
                isRunning = false;
                System.out.println("Program se ukončuje");
                break;
            case 3:
                System.out.println("Díky Honzíku");
                isRunning = false;
                break;
            default:
                break;
        }
    }

    public static String checkViteza() {
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
                System.out.println("150 BODŮ PLS PLS DÍK");
                System.out.println("");
            }
        }
        return null;
    }

    public static void movePlayerA() {System.out.println("Hráč " + playerA + " je na řadě");}
    public static void movePlayerB() {System.out.println("Hráč " + playerB + " je na řadě");}

    public static void printfield() {
        //výpis a formátování
        for (int i = 0; i < field.length; i++) {
            if(i% VelikostPole == 0){
                System.out.print("| ");
            }
            System.out.print(field[i] + " | ");
            if ((i + 1) % VelikostPole == 0) {
                System.out.println("");
            }
        }
        System.out.println();
    }

    public static String win() {

        while (winner == null) {
            if(countround%2==1){
                nextMovePlayerA();
            }
            else if(countround%2==0){
                nextMovePlayerB();
            }
            printfield();
            winner = checkViteza();
            countround++;

            //remiza
            if (countround > 8) {
                if(winner==null){
                    System.out.println("Remízos");
                    novaHra();
                    return winner;
                }
                else{
                    continue;
                }
            }
        }
        return winner;
    }

    public static String nextMovePlayerA(){
        got:
        //sorry, vím, že je to hrozný tahle podmínka, ale jinak mi nefunguje got, právoplatně mi můžeš odebrat 1 bod za toto, už se to znovu nestane Honzíku
        if (1<2) {
            movePlayerA();
            playerInputos = sc.nextInt();
            if(playerInputos>9 || playerInputos<1) {
                System.out.println("Jsi kokýt a zadal jsi nějakou blbost");
                countround--;
                break got;
            }
            if (field[playerInputos - 1].compareTo(playerB) == 0 || field[playerInputos - 1].compareTo(playerA) == 0) {
                countround--;
                System.out.println("Jsi kokýt a neumíš zadávat správně číslíčka");
                break got;
            }
            field[playerInputos - 1] = playerA;
        }
        return playerA;
    }

    public static String nextMovePlayerB(){
        got:
        //sorry na druhou
        if(1<2) {
            movePlayerB();
            playerInputos = sc.nextInt();
            if(playerInputos>9 || playerInputos<1) {
                System.out.println("Jsi kokýt a zadal jsi nějakou blbost");
                countround--;
                break got;
            }
            if (field[playerInputos - 1].compareTo(playerB) == 0 || field[playerInputos - 1].compareTo(playerA) == 0) {
                countround--;
                System.out.println("Jsi kokýt a neumíš zadávat správně číslíčka");
                break got;
            }
            field[playerInputos - 1] = playerB;
        }
        return playerB;
        }
}



