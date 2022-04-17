public class BankAccount {
   // Attributes
   private int accountNumber;
   private String name;
   private double balance; 
      
   // Constructors
    public BankAccount(int an, String n, double b) {
      accountNumber = an; 
      name = n;
      balance = b;
   }

   // Methods
   public int getAccountNumber(){
      return accountNumber;
   }
   public String getName() {
      return name;
   }
   public double getBalance() {
      return balance;
   }
    
   public void addDeposit(double deposit) {
      balance += deposit;
   }
   public void withdraw(double amount) {
      balance -= amount;
   }
}