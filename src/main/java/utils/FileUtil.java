package utils;

import java.io.*;
import java.nio.channels.FileChannel;

public class FileUtil {

    public static String readFile(String filePath) {
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error!";
    }

    public static boolean copy(String srcFilePath, String destFilePath) {
        FileChannel in = null;
        FileChannel out = null;
        try {
            in = new FileInputStream(srcFilePath).getChannel();
            out = new FileOutputStream(destFilePath).getChannel();

            in.transferTo(0, in.size(), out);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
