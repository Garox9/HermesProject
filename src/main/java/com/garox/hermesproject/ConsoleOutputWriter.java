package com.garox.hermesproject;

import com.garox.hermesproject.formatter.TextFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleOutputWriter {

    private final TextFormatter textFormatter;
    @Autowired
    public ConsoleOutputWriter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    void printl(String text) {
        String formattedText = textFormatter.format(text);
        System.out.println(formattedText);
    }
}
