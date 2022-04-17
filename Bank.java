// This is shell code to use for Unit 7 Lab 2 - Bank
// Add code where indicated below to complete the functions. 
import java.util.*;
import java.io.*;

public class Bank {
   static Scanner keyboard = new Scanner(System.in);
   
   public static void main(String args[]) {
      ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
      load_account_file(accountList); 
      
      while(true)
      {
         System.out.println("MAIN MENU");
         System.out.println("---------");
         System.out.println("Enter 1 to Add a new account");
         System.out.println("Enter 2 to Account Maintenance");
         System.out.println("Enter 3 to List all Accounts");
         System.out.println("Enter 4 to Save & Exit");
         //BONUS
         System.out.println("Enter 5 to search for an account");
         int choice = keyboard.nextInt();
         keyboard.nextLine();
      
         switch (choice) {
            case 1: add_account(accountList);
               break;
            case 2: account_maintenance(accountList);
               break;
            case 3:
               list_accounts(accountList);
               break;
            case 4:
               save_and_exit(accountList);
               break;
            case 5:
               search(accountList);
               break;
         }
      }
   }
   
   public static void load_account_file(ArrayList<BankAccount> accountList) {
      // Open the text file to load the saved accounts into the arrayList. 
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File("accounts.txt"));
      
         while (infile.hasNext()){
            int accountNumber = infile.nextInt();
            infile.nextLine();
            String name = infile.nextLine();
            double balance = infile.nextDouble();
            // Create a new account
            BankAccount account = new BankAccount(accountNumber, name, balance);
            // Add the account to the accountList
            accountList.add(account); 
         }
         infile.close();
      
      }
      catch(Exception e)
      {
          System.out.println("File not found. File will be created on exit.");  
      }
   }
   public static void add_account(ArrayList<BankAccount> accountList) {
     // *************************************************
     // Add code here to get new account information and add
     // it to the accountList (similar to file input above)
     // *************************************************
         System.out.println("Please enter the Account Details\n");
         System.out.println("Account Number: ");
         int accountNumber = keyboard.nextInt();
         keyboard.nextLine();
         System.out.println("Name: ");
         String name = keyboard.nextLine();
         System.out.println("Balance of the account: ");
         double balance = keyboard.nextDouble();
         if(!searchByNumber(accountList, accountNumber)){
            BankAccount account = new BankAccount(accountNumber, name, balance);
            accountList.add(account);
         }
         else{
            System.out.println("Account Number already exists, couldn't add the account");
         }
   }
   public static void account_maintenance(ArrayList<BankAccount> accountList) {
      System.out.println("Enter the account name: ");
      String name = keyboard.nextLine();
      boolean found = false; 
      for (int i = 0; i < accountList.size(); i++)
      {
         BankAccount account = accountList.get(i); 
         if (name.equalsIgnoreCase(account.getName())){
            found = true; 
            while(true) {
               System.out.println("ACCOUNT MAINTENANCE MENU");
               System.out.println("---------");  
               System.out.println("Enter 1 to Check account balance");
               System.out.println("Enter 2 to Deposit to Account");
               System.out.println("Enter 3 to Withdraw from Account");
               System.out.println("Enter 4 to Close Account");
               System.out.println("Enter 5 to Return to Main Menu");
               int choice = keyboard.nextInt();
               keyboard.nextLine();
            
               switch (choice) {
                  case 1: check_balance(account);
                     break;
                  case 2: deposit_account(account);
                     break;
                  case 3: withdraw_account(account);
                     break;
                  case 4: close_account(accountList, account);
                     return;
                  case 5: 
                     return;
               }
            }
         }
      }
      if (!found)
         System.out.println("Account not found. Returning to Main Menu");
   }
    
   public static void check_balance(BankAccount account) {
      // *************************************************
      // Add code here to output the account balance. 
      // *************************************************
      System.out.println("The account Balance is: "+account.getBalance());
   }
   public static void deposit_account(BankAccount account) {
      // *************************************************
      // Add code here to enter the deposit amount. 
      // Add the deposit to the account.
		// Print the new balance.
      // *************************************************
      
      System.out.println("Enter the amount to be deposited:\n");
      double deposit = keyboard.nextDouble();
      account.addDeposit(deposit);
      System.out.println("The amount is deposited successfully and your current balance is: "+account.getBalance());
      
   }
   public static void withdraw_account(BankAccount account) {
      // *************************************************
      // Add code here to enter the amount to withdraw and
      // withdraw the money from the account.  
      // Make sure the user does not withdraw more money
      // than is in the account -- printing an error message
		// containing the current account balance. 
		// Print the new account balance after the withdrawal. 
      // *************************************************
      
      System.out.println("Enter the amount to withdraw:\n");
      double withdraw = keyboard.nextDouble();
      double balance = account.getBalance();
      double diff = balance-withdraw;
      if(diff>=0.0000){
         account.withdraw(withdraw);
         System.out.println("The withdrawal is successful! \n");
      }
      else{
         System.out.println("Sorry! You do not have sufficient balance in your account to withdraw.");
      }
      System.out.println("Your current account balance is: "+account.getBalance());
   }
   public static void close_account(ArrayList<BankAccount> accountList, BankAccount account) {
      // *************************************************
      // Add code here to remove the account.
		// Print a confirmation message. 
      // *************************************************
      // for(BankAccount bAccount: accountList){
      //    if(bAccount.getAccountNumber()==account.getAccountNumber()){
            
      //       System.out.println("The account is closed successfully!");
      //    }
      //    else{
      //       System.out.println("Couldn't find the account");
      //    }
      // }
      accountList.remove(account);
      System.out.println("The account is closed successfully!");
   }

   public static void list_accounts(ArrayList<BankAccount> accountList){
      if (accountList.size() == 0) {
         System.out.println("No accounts found");
      }
      for (int i = 0; i < accountList.size(); i++) {
         BankAccount account = accountList.get(i);
         System.out.print("Account number = " + account.getAccountNumber());
         System.out.print("; Name = " + account.getName());
         System.out.println("; Balance = " + account.getBalance());
      }
   }
 
   public static void save_and_exit(ArrayList<BankAccount> accountList){
      // Open the output file.  
      PrintWriter outfile = null;
      try{
         outfile = new PrintWriter(new FileWriter("accounts.txt"));
      }
      catch (Exception e)
      {
         System.out.println("Could not open file for saving");
      }
   
      // Loop through the accountList to output each account to the file. 
      for (int i = 0; i < accountList.size(); i++) {
         BankAccount account = accountList.get(i);
         outfile.println(account.getAccountNumber());
         outfile.println(account.getName());
         outfile.println(account.getBalance());
      }
      outfile.close();
      System.out.println("Data saved. Good-bye.");
      System.exit(0);
   }

   public static boolean searchByName(ArrayList<BankAccount> accountList, String name){
      for(BankAccount account: accountList){
         if(account.getName()==name){
            System.out.print("Account number = " + account.getAccountNumber());
            System.out.print("; Name = " + account.getName());
            System.out.println("; Balance = " + account.getBalance());
            return true;
         }
      }
      return false;
   }

   public static boolean searchByNumber(ArrayList<BankAccount> accountList,int accountNumber){
      for(BankAccount account: accountList){
         if(account.getAccountNumber()==accountNumber){
            System.out.print("Account number = " + account.getAccountNumber());
            System.out.print("; Name = " + account.getName());
            System.out.println("; Balance = " + account.getBalance());
            return true;
         }
      }
      return false;
   }
   public static void search(ArrayList<BankAccount> accountList){
      
      System.out.println("Enter 1 to search by account number\n");
      System.out.println("Enter 2 to search by account name\n");
      int ch = keyboard.nextInt();
      boolean found = false;
      if(ch==1){
         System.out.println("Account Number: ");
         int accountNumber = keyboard.nextInt();
         found = searchByNumber(accountList, accountNumber);
      }
      else{
         System.out.println("Name: ");
         String name = keyboard.nextLine();
         found = searchByName(accountList, name);
      }
      if(!found){
         System.out.println("Oops! The account you were searching for is not found!");
      }
   }
}