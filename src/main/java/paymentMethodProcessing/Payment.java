package paymentMethodProcessing;

import paymentMethod.BankCard;
import paymentMethod.BankTransfer;
import paymentMethod.MobilePayment;

import java.util.Scanner;

public class Payment {
    Scanner scanner = new Scanner(System.in);
    public void cardPayment(){
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
        BankCard bankCard = new BankCard(userName, cardNumber, cardName, expiryDate, cvv);

    }

    public void mobilePayment(){
        System.out.println("Enter Mobile transfer details...");
        System.out.println("Phone number: ");
        int phoneNumber = scanner.nextInt();
        System.out.println("transactionId...");
        String transactionId = scanner.next();
        System.out.println("Owner...");
        String phoneOwner = scanner.next();

        MobilePayment mobilePayment = new MobilePayment();
        mobilePayment.mobileTransfer(phoneNumber, transactionId, phoneOwner);
    }

    public void bankTransfer(){
        System.out.println("Enter Mobile transfer details...");
        System.out.println("Account number: ");
        int accountNumber = scanner.nextInt();
        System.out.println("transactionId...");
        String transactionId = scanner.next();
        System.out.println("Owner...");
        String phoneOwner = scanner.next();

        BankTransfer bankTransfer = new BankTransfer();
        bankTransfer.bankTransfer(accountNumber, transactionId, phoneOwner);
    }
}
