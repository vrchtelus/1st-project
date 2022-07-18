import java.util.Scanner;
import games.ttt.ttt;
//commit 1
//commit 2

public class menu {
    public static void main(String[] args) {
        Scanner             userInputReader = new Scanner(System.in);

        System.out.println("1.- Admin players");
        System.out.println("2.- Estadistics");
        System.out.println("3.- Play Tic Tac Toe");
        System.out.println("4.- Play Hangman");
        System.out.println("--------------------------------------------");
        System.out.println("Please enter a option:");

        int menu = userInputReader.nextInt();
        if (menu == 1){

        }
        else if (menu == 2){

        }
        else if (menu == 3){
            ttt.main();
        }
        else if (menu == 4){

        }

}
