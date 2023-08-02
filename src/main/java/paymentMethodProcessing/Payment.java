package paymentMethodProcessing;

import paymentMethod.BankCard;

import java.util.Scanner;

public class Payment {
    public void cardPayment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter card details...");
        System.out.println("User Name: ");
        String userName = scanner.next();
        System.out.println("card number...");
        int cardNumber = scanner.nextInt();
        System.out.println("Card Name...");
        String cardName = scanner.next();
        System.out.println("expiry date...");
        int expiryDate = scanner.nextInt();
        System.out.println("cvv...");
        int cvv = scanner.nextInt();

        BankCard bankCard = new BankCard();
        bankCard.card(userName, cardNumber, cardName, expiryDate, cvv);


    }
}
