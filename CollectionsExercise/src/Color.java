
public class Color {
	String color = "nothing";

	public Color(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Color [The color is " + color + "]";
	}
	
	
}
