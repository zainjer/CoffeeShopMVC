package com.company.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Log {

    private static List<String> logLines = new ArrayList<>();

    private static String currentMessage;

    // Static constructor
    static{
        try {
            var fr = new FileWriter( new File(FilePaths.getLogFilePath()),false);
            fr.write("-- Start of Log --\n");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void add(String s)
    {
        var df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        var date = df.format(new Date());
        currentMessage = "\n"+date+" - "+s;
        logLines.add(currentMessage);

        // Threading Example
        CompletableFuture.runAsync(Log::writeToLogFile);
    }

    private static void writeToLogFile() {
       var file = new File(FilePaths.getLogFilePath());

        try {
            var fr = new FileWriter(file,true);
            fr.write(currentMessage);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
