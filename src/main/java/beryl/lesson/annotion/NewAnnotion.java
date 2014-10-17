package beryl.lesson.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;



@Documented  // 生成javadoc时，该注解写入文档
@Retention(RUNTIME) //编译和运行时，该注解写入.class文件
@Target({TYPE}) // 该注解只用于类标识
public @interface NewAnnotion {
    
}
