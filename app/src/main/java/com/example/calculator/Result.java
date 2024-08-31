package com.example.calculator;

import java.io.StringReader;

public class Result {

    private String entry;
    private Parser parser;

    public Result(String entry) {

        StringReader reader = new StringReader(entry);
        Lexer lexer = new Lexer(reader);
        parser = new Parser(lexer);

    }

    public int getResult() {
        try {
            return parser.getResult();
        } catch (Exception e) {
            return 0;
        }
    }

}
