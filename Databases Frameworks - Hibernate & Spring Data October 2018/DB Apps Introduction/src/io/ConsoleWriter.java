package io;

import Contracts.Writable;

public class ConsoleWriter implements Writable {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void write(String output) {
        System.out.print(output);
    }
}
