package generics.coffee;

/**
 * @Description
 * @Author cy
 * @Date 2023/7/5 9:38
 **/
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
