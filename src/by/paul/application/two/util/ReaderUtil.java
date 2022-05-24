package by.paul.application.two.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderUtil {

    public List<List<String>> getData(String pathToFile) {
        File file = new File(pathToFile);
        if (!file.exists()) {
            return null;
        } else {
            List<List<String>> dataList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(";");
                    dataList.add(Arrays.asList(values));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return dataList;
        }
    }

    public String getFirstLine(String pathToFile) {
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
