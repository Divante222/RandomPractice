
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Practice practice = new Practice();
        // practice.movieTicketSeller();
        // practice.checkoutLogic();
        // practice.passwordSecurityValidator();
        practice.theLibraryFineCalculator();


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


    // The Challenge: The "Free Shipping" Logic
    // You are building the checkout logic for an online store. The user’s shipping cost depends on two things: their total purchase amount and whether they are a "Premium" member.

    // The Rules:

    // Premium Members: Always get Free Shipping, regardless of the cost.

    // Standard Members:

    // Spend $50 or more: Shipping is Free.

    // Spend $25 to $49.99: Shipping is $5.

    // Spend less than $25: Shipping is $10.
    public void checkoutLogic(){
        Scanner sc = new Scanner(System.in);

        Integer test = Integer.MAX_VALUE;
        System.out.println(test);

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

    // The Challenge: The "Password Security" Validator
    // You are writing a system that checks how "strong" a password is based on two requirements: its length and whether it contains a special character.

    // The Rules:

    // Length < 5: Print "Rejected: Too Short".

    // Length >= 5 AND it does NOT contain a special character (#): Print "Weak: Add a # symbol".

    // Length >= 5 AND it DOES contain a special character (#): Print "Strong: Password accepted".

    public void passwordSecurityValidator(){
        System.out.println("Enter your password");
        Scanner sc = new Scanner(System.in);

        String password = sc.nextLine();

        if(password.length() < 5){
            System.out.println("Rejected: Too Short");
        } else if(password.length() >= 5 && !password.contains("#")){
            System.out.println("Weak: Add a # symbol");
        } else{
            System.out.println("Strong: Password accepted");
        }
    }

    // The Challenge: The Library Fine Calculator
    // You need to calculate a late fee based on the number of days a book is overdue and whether the book is a "New Release."

    // The Rules:

    // If the book is NOT overdue (days <= 0): Fine is $0.

    // If the book IS overdue:

    // Standard Book: $1 per day.

    // New Release: $3 per day.

    // Maximum Cap: If the fine ever exceeds $30, just charge a flat $30.

    // The Task:
    // Write a Java method using int daysOverdue and boolean isNewRelease.

    public void theLibraryFineCalculator(){

        int daysOverdue;
        boolean isNewRelease;

        String bookAdd;
        String isNewReleaseUserInput = "";
        int total = 0;

        Scanner sc = new Scanner(System.in);

        List<Integer> listOfOverdueBooks = new ArrayList<>();

        while(true){

            System.out.println("Do you have an overdue book to add?");
            bookAdd = sc.nextLine();

            if(bookAdd.equals("y") || bookAdd.equals("yes")){
                try {
                    System.out.println("Enter the amount of day the book is overdue: ");
                    daysOverdue = sc.nextInt();
                    sc.nextLine();
                    System.out.println("is the book a new release?");
                    isNewReleaseUserInput = sc.nextLine();
                    if(isNewReleaseUserInput.equals("y") || isNewReleaseUserInput.equals("yes")){
                        isNewRelease = true;
                    } else{
                        isNewRelease = false;
                    }

                    if(isNewRelease == true){
                        if(3 * daysOverdue > 30){
                            listOfOverdueBooks.add(30);
                        } else{
                            listOfOverdueBooks.add(3 * daysOverdue);
                        }
                    } else{
                        if(daysOverdue > 30){
                            listOfOverdueBooks.add(30);
                        } else{
                            listOfOverdueBooks.add(daysOverdue);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("something went wrong press enter to continue: ");
                    sc.nextLine();
                }
                
            } else{
                break;
            }

            total = 0;
            for(Integer t : listOfOverdueBooks){
                total += t;
            }

            if(total > 30){
                total = 30;
                System.out.println("Total can not exceet $30");
            }

            System.out.println("Total so far: " + total);
        }
        System.out.println("The total you have to pay is: " + total);

    }
}
