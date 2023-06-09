package configurer;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author cy
 * @Date 2023/6/2 14:24
 **/
@Configuration
public abstract class AbstractSampleComponentConfiguration {
    Supplier<String> name;
    Supplier<Integer> age;

    /**
     * 基于自定义提供的SampleComponentConfigurer 来配置对应属性
     */
    @Autowired
    public void setConfigurer(ObjectProvider<SampleComponentConfigurer> configurers) {
        List<SampleComponentConfigurer> configurerList = configurers.stream().collect(Collectors.toList());
        Supplier<SampleComponentConfigurer> supplier = () -> {
            if (CollectionUtils.isEmpty(configurerList)) {
                return null;
            }
            if (configurerList.size() > 1) {
                throw new RuntimeException("只允许指定一个 SampleComponentConfigurer");
            }
            return configurerList.get(0);
        };
        name = adapt(supplier, SampleComponentConfigurer::getName);
        age = adapt(supplier, SampleComponentConfigurer::getAge);
    }

    private <T> Supplier<T> adapt(Supplier<SampleComponentConfigurer> supplier, Function<SampleComponentConfigurer, T> function) {
        return () -> {
          SampleComponentConfigurer sampleComponentConfigurer = supplier.get();
          return sampleComponentConfigurer == null ? null : function.apply(sampleComponentConfigurer);
        };
    }
}
