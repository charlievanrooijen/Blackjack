import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        Integer[] cards = { drawRandomCard(), drawRandomCard() };
        Integer playerTotal = cards[0] + cards[1];
        System.out.println("You get a \n" + cardString(cards[0]) + "\n And a \n" + cardString(cards[1]) + "\n");
        System.out.println("your total is: " + playerTotal);

        scan.nextLine();

        int cpuCard1 = drawRandomCard();
        int cpuCard2 = drawRandomCard();

        System.out.println("The dealer shows \n" + cardString(cpuCard1) + "\n And a \n" + faceDown() + "\n");
        System.out.println(" \nThe dealer's total is hidden");

        String hitOrStayChoice = hitOrStay();

        while (hitOrStayChoice.equals("hit")) {
            Integer ExtraCard = drawRandomCard();

            playerTotal += ExtraCard;

            System.out.println(" \nYou get a \n" + cardString(ExtraCard));
            System.out.println("your total is: " + playerTotal);

            if (playerTotal > 21) {
                System.out.println("\n Bust! Player loses");
                System.exit(0);
            }

            hitOrStayChoice = hitOrStay();
            if (hitOrStayChoice.equals("stay")) {
                break;
            }
        }

        Integer cpuTotal = cpuCard1 + cpuCard2; 

        System.out.println(" \nThe dealer's turn");

        while (cpuTotal < playerTotal) {
            Integer cpuExtraCard = drawRandomCard();
            cpuTotal += cpuExtraCard;
            System.out.println(" \n CPU gets a \n" + cardString(cpuExtraCard));
            System.out.println("CPU total is: " + cpuTotal);
            if(cpuTotal > 21){
                System.out.println("Bust! Dealer loses");
                break;
            }
            if(cpuTotal > playerTotal){
                System.out.println("Dealer wins!");
                break;
            }
            if(cpuTotal == playerTotal){
                System.out.println("Draw!");
                break;
            }
        }
        scan.close();

    }

    public static int drawRandomCard() {
        int randomCard = ((int) Math.floor(Math.random() * (12 - 0 + 1) + 1));
        return randomCard;
    }

    public static String cardString(Integer index) {
        switch (index) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";

            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";

            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";

            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";

            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";

            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";

            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";

            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";

            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";

            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";

            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";

            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";
            default:
                return "";
        }
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    public static String hitOrStay() {
        System.out.println(" \n hit or stay?");
        String response = scan.nextLine();

        while (!(response.equals("stay") || response.equals("hit"))) {
            System.out.println(" \n Please write 'hit' or 'stay'");
            response = scan.nextLine();
        }

        return response;
    }
}
