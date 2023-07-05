package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Description 需要一个持有特定类型对象的列表，每次调用它的的select()方法时都随机返回一个对象元素。要求这个列表可以适用于各种类型
 * @Author cy
 * @Date 2023/7/5 10:44
 **/
public class RandomList<T> extends ArrayList<T> {
    private Random rand = new Random(47);
    public T select() {
        return get(rand.nextInt(size()));
    }
    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        Arrays.stream("The quick brown fox jumped over the lazy brown dog".split(" ")).forEach(rs::add);
        IntStream.range(0, 11).forEach(i ->
                System.out.print(rs.select() + " "));
    }
}
