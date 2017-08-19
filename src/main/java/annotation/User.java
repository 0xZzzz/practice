package annotation;

@MyAnnotation(name="ZQ", sex=Sex.GG, hobby={"³Ô"})
public class User {
	private String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
