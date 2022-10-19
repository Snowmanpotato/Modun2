package utils;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ReadAndWrite {
    public static List<String> readFile(String fileName) {
        List<String> items = new ArrayList<>();
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                items.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(fileName + "không có dữ liệu");
        }
        return items;
    }

    public static <E> void writeFile(String fileName, List<E> list) {
        try {
            PrintWriter printWriter = new PrintWriter(fileName);

            for(Object item : list){
                printWriter.write(item.toString());
                printWriter.println();
            }
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
