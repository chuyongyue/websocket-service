package generics;

/**
 * @Description 尽管可以同时对类及其方法进行参数化，但这里未将 GenericMethods 类参数化。只有方法 f() 具有类型参数，该参数由方法返回类型之前的参数列表指示。
 *
 * 对于泛型类，必须在实例化该类时指定类型参数。使用泛型方法时，通常不需要指定参数类型，因为编译器会找出这些类型。
 * 这称为 类型参数推断。因此，对 f() 的调用看起来像普通的方法调用，并且 f() 看起来像被重载了无数次一样。它甚至会接受 GenericMethods 类型的参数。
 *
 * 如果使用基本类型调用 f() ，自动装箱就开始起作用，自动将基本类型包装在它们对应的包装类型中。
 * @Author cy
 * @Date 2023/7/5 14:20
 **/
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}