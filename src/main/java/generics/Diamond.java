package generics;

/**
 * @Description
 * @Author cy
 * @Date 2023/7/5 9:56
 **/
class Bob {}

public class Diamond<T> {

    public static void main(String[] args) {
        GenericHolder<Bob> h3 = new GenericHolder<>();
        h3.set(new Bob());
    }
}
