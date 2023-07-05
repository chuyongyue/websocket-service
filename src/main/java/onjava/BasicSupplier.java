// Supplier from a class with a no-arg constructor

//此类提供了产生以下对象的基本实现：
//
//是 public 的。 因为 BasicSupplier 在单独的包中，所以相关的类必须具有 public 权限，而不仅仅是包级访问权限。
//
//具有无参构造方法。要创建一个这样的 BasicSupplier 对象，请调用 create() 方法，
// 并将要生成类型的类型令牌传递给它。通用的 create() 方法提供了 BasicSupplier.create(MyType.class)
// 这种较简洁的语法来代替较笨拙的 new BasicSupplier <MyType>(MyType.class)。
package onjava;
import java.util.function.Supplier;
public class BasicSupplier<T> implements Supplier<T> {
    private Class<T> type;
    public BasicSupplier(Class<T> type) {
        this.type = type;
    }
    @Override
    public T get() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch (InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    // Produce a default Supplier from a type token:
    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}