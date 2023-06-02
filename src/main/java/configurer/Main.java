package configurer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @Author cy
 * @Date 2023/6/2 15:22
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        SampleComponent bean = applicationContext.getBean(SampleComponent.class);
        System.out.println(bean.getName());
        System.out.println(bean.getAge());
    }
}
