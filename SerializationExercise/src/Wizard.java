import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.HealthPack;
import com.fdmgroup.serialization.game.Player;

public class Wizard extends Player implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Shield shield;
	private Power power;
	private transient Backpack backpack;

	
	public Wizard() {
		super();
	}

	public Wizard(Shield shield, Power power) {
		super();
		this.shield = shield;
		this.power = power;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
			oos.writeUTF(getName());
			oos.writeInt(getHealthPoints());
			oos.defaultWriteObject();
			oos.writeInt(backpack.getNumPacks());
			while (backpack.getNumPacks()>0){
				oos.writeInt(backpack.useHealthPack().getHealthPoints());
			}
			
			
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
		setName(ois.readUTF());
		setHealthPoints(ois.readInt());
		ois.defaultReadObject();
		Backpack bp = new Backpack();
		int numOfPacks = ois.readInt();
		for(int i=0; i<numOfPacks; i++){
			HealthPack hp = new HealthPack();
			hp.setHealthPoints(ois.readInt());
			bp.addHealthPack(hp);
		}
		setBackpack(bp);
	}
	
	public Backpack getBackpack() {
		return backpack;
	}
	
	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	/*@Override
	public String toString() {
		return "Wizard [shield=" + shield + ", power=" + power + ", backpack=" + backpack + ", getHealthPoints()="
				+ getHealthPoints() + ", getName()=" + getName() + "]";
	}*/
	
	

}
