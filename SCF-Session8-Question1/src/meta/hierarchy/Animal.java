package meta.hierarchy;

public class Animal {
	String name;
	double age;
	double weight;
	public Animal(String name, double age, double weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	public String getName(){
		return this.name;
	}
	public double getAge(){
		return this.age;
	}
	public double getWeight(){
		return this.weight;
	}
}
