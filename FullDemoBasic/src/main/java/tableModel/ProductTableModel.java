package tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entity.*;

public class ProductTableModel extends AbstractTableModel {
	private String[] columnNames = { "Product ID", "Name Of Product", "Title Of Product", "Price", "Quantity" };
	private ArrayList<Product> listData;
	private ArrayList<Object[]> listRow = new ArrayList<>();

	public ProductTableModel(ArrayList<Product> listData) {
		this.listData = listData;
		Product tempObj;
		for (int i = 0; i < this.listData.size(); i++) {
			tempObj = this.listData.get(i);
			Object[] row = { tempObj.getProductID(), tempObj.getProductName(), tempObj.getTitle(), tempObj.getPrice(),
					tempObj.getQuantity() };
			this.listRow.add(row);
		}
	}

	@Override
	public int getRowCount() {
		return this.listRow.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return listRow.get(rowIndex)[columnIndex];
	}

	public String getColumnName(int column) {
		return this.columnNames[column];
	}

	public java.lang.Class getColumnClass(int column) {
		return this.listRow.get(0)[column].getClass();
	}

	public Object getObjectAtRow(int row) {
		return this.listData.get(row);
	}

}