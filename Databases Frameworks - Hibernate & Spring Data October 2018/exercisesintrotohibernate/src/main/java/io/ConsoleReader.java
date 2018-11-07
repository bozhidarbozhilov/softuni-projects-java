package io;

import intefaces.Readable;

import java.util.Scanner;

public class ConsoleReader implements Readable {
    private final Scanner scanner
            ;

    public ConsoleReader(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
