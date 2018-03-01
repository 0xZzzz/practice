package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited //��ʾ���Ա�����̳�
@Documented //���Ա��ĵ�ע��
@Target({ElementType.TYPE}) //��ʾע��Ӧ�õķ�Χ(����, ��, ���Ե�)
@Retention(RetentionPolicy.RUNTIME) //ע������÷�Χ(Դ��, class�ֽ���, ������)
public @interface MyAnnotation {
	String name(); //ע���е����� û��Ĭ��ֵ��������ʹ��ע��ʱ����ָ������ֵ
	String info() default "Ĭ��ֵ"; //��Ĭ��ֵ������, ʹ��ʱ���Բ���ָ��
	String[] hobby(); //���Կ���Ϊ��������
	Sex sex(); //���Կ���Ϊö������
}
