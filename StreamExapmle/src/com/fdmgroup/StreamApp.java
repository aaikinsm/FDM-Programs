package com.fdmgroup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StreamApp {

	public static void main(String[] args) {
		// echo();
		// echo2();
		// copyBinaryFile("C:/putty.exe","C:/Users/albert.mensah/Desktop/putty-copy.exe");
		// storeData("C:/Users/albert.mensah/Desktop/data.dat");
		// loadData("C:/Users/albert.mensah/Desktop/data.dat");
		// copyTextFile("C:/Users/albert.mensah/Desktop/Hello.java.txt","C:/Users/albert.mensah/Desktop/Hello.txt");
		fileOperation("C:\\Users\\albert.mensah\\Desktop\\MyFolder\\Hello.txt");
	}

	private static void fileOperation(String filename) {
		File file = new File(filename);
		if(file.exists()){
			file.delete();
			System.out.println("Directory deleted.");
			return;
		}
		
		file.mkdirs();
		System.out.println("Directory created");
	}

	private static void copyTextFile(String source, String destination) {
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(source));
			bw = new BufferedWriter(new FileWriter(destination));

			String line = "";
			while (line != null) {
				line = br.readLine();
				if (line != null)
					bw.write(line + "\n");
			}
			System.out.println("File copied successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(br);
			close(bw);
		}
	}

	private static void loadData(String filename) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(filename));
			while (dis.available() > 0) {
				System.out.println(dis.readUTF() + " ---> " + dis.readInt() + " ---> " + dis.readFloat() + " ---> "
						+ dis.readBoolean());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(dis);
		}
	}

	private static void storeData(String filename) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(filename));
			dos.writeUTF("Alex Smith");
			dos.writeInt(25);
			dos.writeFloat(88.50F);
			dos.writeBoolean(false);

			dos.writeUTF("Mary Jane");
			dos.writeInt(30);
			dos.writeFloat(100.0F);
			dos.writeBoolean(true);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(dos);
		}
	}

	private static void copyBinaryFile(String source, String destination) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(source);
			byte[] fileData = new byte[fis.available()];
			fis.read(fileData);

			fos = new FileOutputStream(destination);
			fos.write(fileData);
			System.out.println("The file was copied successfully");
		} catch (FileNotFoundException e) {
			System.out.println("The source file was not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The file was not copied successfully");
			e.printStackTrace();
		} finally {
			close(fis);
			close(fos);
		}
	}

	private static void echo2() {
		Scanner scanner = new Scanner(System.in);
		String line = "";

		while (!line.equalsIgnoreCase("exit")) {
			line = scanner.nextLine();
			System.out.println("You Typed: " + line);
		}

	}

	private static void echo() {
		String str = "";
		int r = 0;

		try {
			while (r != 10) {
				r = System.in.read();
				str += (char) r;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("You typed " + str);
	}

	private static void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
