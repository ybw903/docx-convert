package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileUtil {
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
