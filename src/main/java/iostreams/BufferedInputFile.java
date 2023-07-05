package iostreams;

import util.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @Description 缓冲输入文件,打开一个文件进行进行字符输入
 * @Author cy
 * @Date 2023/5/31 9:40
 **/
public class BufferedInputFile {
    public static String read(String filename) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(filename))) {
            return in.lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        System.out.print(
                read(FileUtils.FILE_PATH + "iostreams/input"));
    }
}
