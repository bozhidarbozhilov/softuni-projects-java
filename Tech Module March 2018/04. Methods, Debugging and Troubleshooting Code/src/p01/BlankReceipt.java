package p01;

public class BlankReceipt {
    public static void main(String[] args){
        printReceipt();
    }
    public static void printReceiptHeader(){
        System.out.println("CASH RECEIPT");
        System.out.println("------------------------------");
    }
    public static void printReceiptBody(){
        System.out.println("Charged to____________________");
        System.out.println("Received by___________________");
    }
    public static void printReceiptFooter(){
        System.out.println("------------------------------");
        System.out.println("\u00A9 SoftUni");
    }
    public static void printReceipt(){
        printReceiptHeader();
        printReceiptBody();
        printReceiptFooter();
    }
}
