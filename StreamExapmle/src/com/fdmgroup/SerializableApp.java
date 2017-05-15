package com.fdmgroup;

import com.fdmgroup.model.User;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.Stock;

public class SerializableApp {
	public static void main(String[] args) {
		User u1 = new User(1, "Albert Mensah", 100.0, new Company(1, "Google", new Stock("GGL")));
		u1.count = 10;
		serialize(u1, "C:/Users/Albert.Mensah/Desktop/user.ser");
		User u2 = deserialize("C:/Users/Albert.Mensah/Desktop/user.ser");
		System.out.println(u2);
		//System.out.println(u1.equals(u2));
		
	}

	private static User deserialize(String filename) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
			User u = (User)ois.readObject();
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			close (ois);
		}
		return null;
	}

	private static void serialize(User user, String filename) {
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
