package meta.hierarchy;

public class Lion extends Mammels {

	String sound;
	public Lion(String name, double age, double weight, String food,String category, String sound) {
		super(name, age, weight, food, category);
		this.sound = sound;
	}

	public String getSound(){
		return this.sound;
	}
}
