package configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description 这里模拟应用场景，@Import({ SampleComponentConfiguration.class }) 功能一般以类似 @EnableXXX 的模式提供
 * 我们提供的配置类 Config 实现 SampleComponentConfigurer 接口以支持组件属性的自定义配置
 * 示例中，我们覆盖了 SampleComponent 的 name 属性
 * @Author cy
 * @Date 2023/6/2 15:20
 **/
@Configuration
@Import(SampleComponentConfiguration.class)
public class Config implements SampleComponentConfigurer {
    // 自定义组件属性
    @Override
    public String getName() {
        return "dd";
    }
}
