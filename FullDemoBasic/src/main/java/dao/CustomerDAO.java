package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import configPkg.ConfigInfo;
import entity.Customer;

public class CustomerDAO {
	private String pathStr = ConfigInfo.getCtxRealPath() + "\\BackupData\\";
	private String fileNameByte = "CustomerData_Byte.dat";
	private String fileNameChar = "CustomerData_Char.txt";

	public CustomerDAO() {

		this.createFolder();
	}

	public void createFolder() {
		File folder = new File(pathStr);

		if (folder.exists()) {
			System.out.println("Folder exists");
		} else {
			System.out.println("Folder not exists");
			folder.mkdir();
			System.out.println("Folder created");
		}
		System.out.println("Did it!!!Customer " + folder.getAbsolutePath());
	}

	public void saveListCustomerAsByte(ArrayList<Customer> listCustomers) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(this.pathStr + "\\" + this.fileNameByte);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(listCustomers);
			oos.flush();

		} catch (IOException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	public ArrayList<Customer> readListCustomerAsByte() {

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(this.pathStr + "\\" + this.fileNameByte);
			ois = new ObjectInputStream(fis);

			ArrayList<Customer> listCustomers = (ArrayList<Customer>) ois.readObject();

			return listCustomers;

		} catch (IOException ex) {
			System.out.println("Exception: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return null;
	}

	public void saveListCustomerAsChar(ArrayList<Customer> listCustomers) {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(this.pathStr + "\\" + this.fileNameChar);
			bw = new BufferedWriter(fw);
			Customer tempCustomer;

			for (int i = 0; i < listCustomers.size(); i++) {
				tempCustomer = listCustomers.get(i);
				bw.write(tempCustomer.getCustomerInfor());
				bw.newLine();
			}
			bw.flush();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
