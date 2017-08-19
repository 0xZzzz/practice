package annotation;

import java.lang.annotation.Annotation;

public class Test {
	public static void main(String[] args) {
		Class<?> user = User.class;
		Annotation[] annotations = user.getAnnotations();
		for (Annotation annotation : annotations) {
			if(user.isAnnotationPresent(MyAnnotation.class)){
				MyAnnotation myAnnotation = (MyAnnotation)annotation;
				System.out.println(myAnnotation.name());
			}
		}
	}
}
