import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbolsCount  = new TreeMap<>();

        char[] symbols = scanner.nextLine().toCharArray();

        for (char symbol : symbols) {
            symbolsCount.putIfAbsent(symbol, 0);
            symbolsCount.put(symbol, symbolsCount.get(symbol)+1);
        }

        for (Map.Entry<Character, Integer> entry : symbolsCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
