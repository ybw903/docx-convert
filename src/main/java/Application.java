import utils.FileUtil;
import utils.ZipUtil;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) throws IOException {

        String srcFilePath = "test.docx";
        String destFilePath = "test.zip";

        FileUtil.copy(srcFilePath, destFilePath);

        Path src = Paths.get("test.zip");
        Path target = Paths.get("/result");

        System.out.println(ZipUtil.unzipFile(src, target));
    }
}
