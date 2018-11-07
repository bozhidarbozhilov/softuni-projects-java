package io;

import intefaces.Writable;

public class ConsoleWriter implements Writable {
    public ConsoleWriter() {
    }

    @Override
    public void write(String output) {
        System.out.print(output);
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
