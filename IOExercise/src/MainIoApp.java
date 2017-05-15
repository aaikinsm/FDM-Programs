import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainIoApp {
	public static void main(String[] args) {
		
		String path = "C:/Users/Albert.Mensah/Desktop/";
		System.out.println("The number of '{' is: " + countChar('{', path + "Hello.txt"));

		//addUser(path +"testFile.txt");
		
		ArrayList<User> users = getUsers(path +"testFile.txt");
		for (User user : users) {
			System.out.println(user);
		}

	}

	private static ArrayList<User> getUsers(String path) {
		ArrayList<User> users = new ArrayList<>();
		// read
				DataInputStream dis = null;
				String[] data = null;
				try {
					dis = new DataInputStream(new FileInputStream(path));
					while (dis.available() > 1) {
						data = dis.readLine().split(",");
						users.add(new User(data[0], data[1], data[2]));
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		return users;
	}

	private static int countChar(char c, String filename) {

		DataInputStream dis = null;
		int count = 0;
		try {
			dis = new DataInputStream(new FileInputStream(filename));
			while (dis.available() > 1) {
				byte ch = dis.readByte();
				if ((char) ch == c)
					count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;

	}

	public static void addUser(String path) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		System.out.print("Enter your address: ");
		String adrs = input.nextLine();
		System.out.print("Enter your email: ");
		String email = input.nextLine();
		// read
		DataInputStream dis = null;
		String data = "";
		try {
			dis = new DataInputStream(new FileInputStream(path));
			while (dis.available() > 1) {
				data += dis.readLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// write
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			fw.write(data + name + "," + adrs + "," + email);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
