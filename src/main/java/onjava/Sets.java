package onjava;

/**
 * @Description 这四种方法代表数学集合操作：
 * union() 返回一个包含两个参数并集的 Set ，
 * intersection() 返回一个包含两个参数集合交集的 Set ，
 * difference() 从 superset 中减去 subset 的元素 ，
 * 而 complement() 返回所有不在交集中的元素的 Set。
 * @Author cy
 * @Date 2023/7/5 17:15
 **/
import java.util.HashSet;
import java.util.Set;
public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    public static <T>
    Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    // Subtract subset from superset:
    public static <T> Set<T>
    difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }
    // Reflexive--everything not in the intersection:
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}