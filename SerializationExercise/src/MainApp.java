import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.fdmgroup.serialization.game.Backpack;
import com.fdmgroup.serialization.game.Board;
import com.fdmgroup.serialization.game.HealthPack;

public class MainApp {

	public static void main(String[] args) {
		Wizard wizard = new Wizard(new Shield(15), new Power(4));
		HealthPack healthP = new HealthPack(2);
		HealthPack healthP2 = new HealthPack(5);
		Backpack backP = new Backpack();
		backP.addHealthPack(healthP);
		backP.addHealthPack(healthP2);
		wizard.setBackpack(backP);
		wizard.setHealthPoints(4);
		wizard.setName("Woldolf");

		Wizard wizard2 = new Wizard(new Shield(10), new Power(8));
		HealthPack healthPk = new HealthPack(9);
		Backpack backPk = new Backpack();
		backPk.addHealthPack(healthPk);
		wizard2.setBackpack(backPk);
		wizard2.setHealthPoints(3);
		wizard2.setName("Jane");

		Board board = new Board();
		board.attack(wizard, wizard2);
		board.loseHealthPoint(wizard2);
		board.attack(wizard2, wizard);
		board.loseHealthPoint(wizard);
		board.attack(wizard, wizard2);
		board.loseHealthPoint(wizard2);

		System.out.println(wizard);
		serialize(wizard, "C:/Users/Albert.Mensah/Desktop/wizard.ser");

		Wizard w = deserialize("C:/Users/Albert.Mensah/Desktop/wizard.ser");
		System.out.println(w);
	}

	private static Wizard deserialize(String filename) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
			Wizard w = (Wizard) ois.readObject();
			return w;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(ois);
		}
		return null;
	}

	private static void serialize(Wizard user, String filename) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(user);
			System.out.println("Object Stored");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(oos);
		}
	}

	private static void close(Closeable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
