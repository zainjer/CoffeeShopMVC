package com.company.shared;

import com.company.util.FilePaths;
import com.company.util.Log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class DataReader {

    public static List<String> readMenuItems() {

        Log.add("Invoked: readMenuItems in "+DataReader.class.getName());

        var path = Paths.get(FilePaths.getMenuItemsPath());

        return readFileAsLines(path);
    }

    public static List<String> readOrders(){

        Log.add("Invoked: readOrders in "+DataReader.class.getName());

        var path = Paths.get(FilePaths.getOrdersPath());

        return readFileAsLines(path);
    }

    private static List<String> readFileAsLines(Path path) {

        Log.add("Invoked: ReadFileAsLines in "+DataReader.class.getName());

        Log.add("File path:"+ path.toAbsolutePath());

        List<String> lines = null;

        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.remove(0); // This line is only for heading purpose (Not actual data)
        lines.forEach(l -> Log.add("Read line:" + l));

        return lines;
    }

}
