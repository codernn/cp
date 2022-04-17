import java.io.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) throws Exception{
        File file = new File("contacts.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        String[] name = new String[50];
        String[] phone = new String[50];
        String[] email = new String[50];
        int i=0;
        try{
            while ((str = br.readLine()) != null && i<50){
                String[] splitStr = str.trim().split("\\s+");
                name[i] = splitStr[0]+" "+splitStr[1];
                phone[i] = splitStr[2];
                email[i] = splitStr[3];
                i++;
            }
        }
        catch(IOException e){
            System.out.println("Couldn't read from the file");
        }
            
        while(true){
            System.out.println("MAIN MENU");
            System.out.println("---------");
            System.out.println("Enter 1 to Add a contact");
            System.out.println("Enter 2 to Search for a contact");
            System.out.println("Enter 3 to List all contacts");
            System.out.println("Enter 4 to Save & Exit");
            Scanner sc  = new Scanner(System.in);
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    Console cnsl = System.console();
                    if(i<50){    
                        name[i] = cnsl.readLine( "Enter name : ");
                        phone[i] = cnsl.readLine( "Enter phone number : ");
                        email[i] = cnsl.readLine( "Enter email : ");
                        i++;
                    }
                    else{
                        System.out.println("Can't add contacts anymore");
                    }
                    break;
                case 2:
                    Console cnsl1Console = System.console();
                    String str1 = cnsl1Console.readLine( "Enter name to search: ");
                    int ans = -1;
                    for(int j=0;j<i;j++){
                        if(name[j].equalsIgnoreCase(str1)){
                            ans = j;
                        }
                    }
                    if(ans==-1){
                        System.out.println("Couldn't find the name you searched for");
                    }
                    else{
                        System.out.println("The contact info is: "+ name[ans]+" "+phone[ans]+" "+email[ans]);
                    }
                    break;
                case 3:
                    for(int j=0;j<i;++j){
                        System.out.println(name[j]+" "+phone[j]+" "+email[j]);
                    }
                    break;
                case 4:
                    FileWriter outFile;
                    try
                    {
                        outFile = new FileWriter("contacts.txt");
                        BufferedWriter brw = new BufferedWriter(outFile);
                        brw.write("");
                        for(int j=0;j<i;++j){
                            brw.write(name[j]+" "+phone[j]+" "+email[j]);
                            brw.newLine();
                        }
                        brw.close();
                        System.out.println("Data Saved. Good-bye!");
                    }
                    catch (IOException except)
                    {
                        System.out.println("Couldn't write to the file");
                    }
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
            if(ch==4){
                break;
            }
        }
    }
}