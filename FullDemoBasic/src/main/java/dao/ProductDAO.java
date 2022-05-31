package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import java.util.Iterator;

import configPkg.ConfigInfo;

import java.io.IOException;

import entity.Product;

public class ProductDAO {

	private String pathStr = ConfigInfo.getCtxRealPath()+"\\BackupData\\";
	private String fileNameByte = "ProductData_Byte.dat";
	private String fileNameChar = "ProductData_Char.txt";

	public ProductDAO() {

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
		System.out.println("Done from Product " + folder.getAbsolutePath());
	}

	public void saveListProductAsByte(ArrayList<Product> listProduct) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(this.pathStr + "\\" + this.fileNameByte);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(listProduct);
			oos.flush();

		} catch (IOException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	public ArrayList<Product> readListProductAsByte() {

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(this.pathStr + "\\" + this.fileNameByte);
			ois = new ObjectInputStream(fis);

			ArrayList<Product> listProduct = (ArrayList<Product>) ois.readObject();

			return listProduct;

		} catch (IOException ex) {
			System.out.println("Exception: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return null;
	}

	public void saveListProductAsChar(ArrayList<Product> listProduct) {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(this.pathStr + "\\" + this.fileNameChar);
			bw = new BufferedWriter(fw);
			Product tempProduct;

			for (int i = 0; i < listProduct.size(); i++) {
				tempProduct = listProduct.get(i);
				bw.write(tempProduct.getProductInfor());
				bw.newLine();
			}
			bw.flush();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
