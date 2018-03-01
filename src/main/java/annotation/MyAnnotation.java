package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited //表示可以被子类继承
@Documented //可以被文档注释
@Target({ElementType.TYPE}) //表示注解应用的范围(方法, 类, 属性等)
@Retention(RetentionPolicy.RUNTIME) //注解的作用范围(源码, class字节码, 运行期)
public @interface MyAnnotation {
	String name(); //注解中的属性 没有默认值的属性在使用注解时必须指定并赋值
	String info() default "默认值"; //有默认值的属性, 使用时可以不必指定
	String[] hobby(); //属性可以为数组类型
	Sex sex(); //属性可以为枚举类型
}
