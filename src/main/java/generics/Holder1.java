package generics;

/**
 * @Description
 * @Author cy
 * @Date 2023/7/5 9:42
 **/
class Automobile {}


public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) { this.a = a; }
    Automobile get() { return a; }
}
