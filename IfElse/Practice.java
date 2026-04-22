
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Practice practice = new Practice();
        // practice.movieTicketSeller();
        // practice.checkoutLogic();


    }

    // You are writing a program for a cinema that calculates the price of a ticket based on a person's age. Here are the rules:

    // Children (Under 13): $8

    // Teenagers (13 to 17): $10

    // Adults (18 to 64): $15

    // Seniors (65 and older): $12
    public void movieTicketSeller(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the age of the person purchasing the ticket");
        int userInput = sc.nextInt();

        if(userInput < 13){
            System.out.println("The amount of the ticket will be 8 dollars");
        } else if(userInput >= 13 && userInput <= 17){
            System.out.println("The ticket will cost 10 dollars");
        } else if(userInput >= 18 && userInput <= 64){
            System.out.println("The ticket will cost 15 dollars");
        } else{
            System.out.println("The ticket will cost 12 dollars");
        }
    }

    public void checkoutLogic(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter your item cost");
            double itemCost = sc.nextDouble();

            System.out.println("Are you premium?");
            boolean isPremium = sc.nextBoolean();

            if(itemCost >= 50){
                System.out.println(String.format("the total cost is %s dollars", itemCost));
            } else if( itemCost >=25){
                if(isPremium){
                    System.out.println(String.format("the total cost is %s dollars", itemCost));
                } else{
                    System.out.println(String.format("the total cost is %s dollars", (double) Math.round(itemCost * 100) / 100 + 5));
                }
            } else{
                if(isPremium){
                    System.out.println(String.format("the total cost is %s dollars", itemCost));
                } else{
                    System.out.println(String.format("the total cost is %s dollars", ((double) Math.round((itemCost + 10) * 100) / 100)));
                }
            }
            System.out.println("keep going?");
            sc.nextLine();
            String keepGoing = sc.nextLine();

            if(keepGoing.equals("n") || keepGoing.equals("N")){
                break;
            }
        }

    
    }
}
