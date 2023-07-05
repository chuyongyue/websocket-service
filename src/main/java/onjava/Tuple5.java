package onjava;

/**
 * @Description
 * @Author cy
 * @Date 2023/7/5 10:08
 **/
public class Tuple5<A, B, C, D, E>
        extends Tuple4<A, B, C, D> {
    public final E a5;
    public Tuple5(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        a5 = e;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a5;
    }
}