package configurer;

/**
 * @Description
 * @Author cy
 * @Date 2023/6/2 14:21
 **/
public interface SampleComponentConfigurer {
    default String getName() {
        return "default";
    }

    default Integer getAge() {
        return 18;
    }
}
