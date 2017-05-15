import java.io.Serializable;

public class Shield implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int shield;
	

	public Shield(int shield) {
		super();
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	public String toString() {
		return "Shield [shield=" + shield + "]";
	}
	

}
