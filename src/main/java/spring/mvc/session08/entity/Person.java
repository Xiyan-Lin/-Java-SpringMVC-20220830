package spring.mvc.session08.entity;

public class Person {
	private String name;
	private Double score;
	private Integer age;
	private Boolean pass;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getPass() {
		return pass;
	}
	public void setPass(Boolean pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", score=" + score + ", age=" + age + ", pass=" + pass + "]";
	}
	
	
}
