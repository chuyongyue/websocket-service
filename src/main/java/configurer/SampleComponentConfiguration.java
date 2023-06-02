package configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author cy
 * @Date 2023/6/2 14:57
 **/
@Configuration
public class SampleComponentConfiguration extends AbstractSampleComponentConfiguration {
    @Bean
    public SampleComponent sampleComponent() {
        SampleComponent sampleComponent = new SampleComponent();
        // 基于sampleComponentConfigurer 进行配置
        sampleComponent.configurer(name, age);
        return sampleComponent;
    }
}
