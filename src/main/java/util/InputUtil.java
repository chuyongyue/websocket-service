package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

/**
 * @Description 输入输出工具类
 * @Author cy
 * @Date 2023/5/19 23:48
 **/
public class InputUtil {

    public static InputStream getInput(String fileName) {
        InputStream inputStream = null;
       try {
          URL url = InputUtil.class.getClassLoader().getResource("");
          if (url != null) {
              fileName = url.getPath() + "/" + fileName;
          }

          inputStream  = new FileInputStream(fileName);
       } catch (FileNotFoundException fileInputStream) {
           inputStream = System.in;
       }
       return inputStream;
    }
}
