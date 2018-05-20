import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class p02_OptimizedBankSystem {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<bankAccount> accounts = new ArrayList<>();
        String inputStr = scanner.nextLine();

        while(!inputStr.equals("end")){
            bankAccount account = bankAccount.parseAccount(inputStr);
            accounts.add(account);

            inputStr=scanner.nextLine();
        }

        accounts.stream()
                .sorted((a,b)->{
            int index = b.getBalance().compareTo(a.getBalance());
            if(index==0){
                index = Integer.compare(a.getBank().length(),b.getBank().length());
            }
            return index;
                })
                .forEach(ba-> System.out.printf("%s -> %s (%s)%n",ba.getName(),ba.getBalance(),ba.getBank()));
    }
}
class bankAccount{
    private String name;
    private String bank;
    private BigDecimal balance;

    public bankAccount(String nameIn, String bankIn, BigDecimal balanceIn){
        this.name = nameIn;
        this.bank = bankIn;
        this.balance = balanceIn;
    }

    public static bankAccount parseAccount(String input){
        String[] inputTokens = input.split(" \\| ");
        String nameIn = inputTokens[1];
        String bankIn = inputTokens[0];
        BigDecimal balanceIn = new BigDecimal(inputTokens[2]);


        return new bankAccount(nameIn, bankIn, balanceIn);
    }
    public String getName(){return name;}
    public String getBank(){return bank;}
    public BigDecimal getBalance() {return balance;}
}
