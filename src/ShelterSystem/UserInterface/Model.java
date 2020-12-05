package ShelterSystem.UserInterface;

import ShelterSystem.Base.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

//rowData用来存放行数据
//columnNames存放列名
public class Model extends AbstractTableModel {
    private Vector<Animal> animals;
    private Vector<String> columnNames = null;    //列名
    private Vector<Vector<String>> rowData = null;    //行数据


    public Model(String type, JDialog jd) {

        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("详细信息");

        if (type.equals("Application")) {
            for (ApplicationItem applicationItem : AnimalShelterSystem.system.applicationManager) {

                Vector<String> hang = new Vector<String>();
                hang.add(applicationItem.toString());
                rowData.add(hang);
            }
        } else if (type.equals("User")) {
            for (User user : AnimalShelterSystem.system.userCatalog) {

                Vector<String> hang = new Vector<String>();
                hang.add(user.toString());
                rowData.add(hang);
            }
        }
        if (getRowCount() != 0) {
            JOptionPane.showMessageDialog(jd, "一共有" + getRowCount() + "条记录！");
        } else {
            JOptionPane.showMessageDialog(jd, "没有任何记录！");
        }
    }

    //得到共有多少行
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
    }

    //得到共有多少列
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.columnNames.size();
    }

    //得到某行某列的数据
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return ((Vector) this.rowData.get(rowIndex)).get(columnIndex);
    }

    //重写方法 getColumnName
    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String) this.columnNames.get(column);
    }

}