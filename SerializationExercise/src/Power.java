import java.io.Serializable;

public class Power implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int power;
	

	public Power(int power) {
		super();
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "Power [power=" + power + "]";
	}
	
	

}
