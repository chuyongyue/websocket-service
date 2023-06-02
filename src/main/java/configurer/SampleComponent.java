package configurer;

import java.util.function.Supplier;

/**
 * @Description 模拟一个简单的组件，支持自定义配置
 * @Author cy
 * @Date 2023/6/2 10:41
 **/
public class SampleComponent {
    private String name;
    private Integer age;

    // 支持自定义配置
    public void configurer(Supplier<String> name, Supplier<Integer> age) {
        this.name = name.get();
        this.age = age.get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
