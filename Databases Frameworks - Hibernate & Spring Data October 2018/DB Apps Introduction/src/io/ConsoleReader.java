package io;

import Contracts.Readable;

import java.util.Scanner;

public class ConsoleReader implements Readable {
    private Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine() {
        return this.scanner.nextLine();
    }
}
