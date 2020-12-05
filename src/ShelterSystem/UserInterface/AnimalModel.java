package ShelterSystem.UserInterface;

import ShelterSystem.Base.Animal;
import ShelterSystem.Base.AnimalShelterSystem;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

//rowData用来存放行数据
//columnNames存放列名
public class AnimalModel extends AbstractTableModel {
    private Vector<Animal> animals;
    private Vector<String> columnNames = null;    //列名
    private Vector<Vector<String>> rowData = null;    //行数据


    public AnimalModel(String str, String option, JDialog jd) {

        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("动物编码");
        columnNames.add("动物种类");
        columnNames.add("动物昵称");
        columnNames.add("收容日期");
        columnNames.add("描述");

        for (Animal animal : AnimalShelterSystem.system.animalCatalog) {
            switch (option) {
                case "动物编号":
                    if (!animal.getCode().equals(str))
                        continue;
                    break;
                case "动物种类":
                    if (!animal.getTypename().equals(str))
                        continue;
                    break;
                case "动物昵称":
                    if (!animal.getNickname().equals(str))
                        continue;
                    break;
            }
            Vector<String> hang = new Vector<String>();
            hang.add(animal.getCode());
            hang.add(animal.getTypename());
            hang.add(animal.getNickname());
            hang.add(animal.getDate() + "");
            hang.add(animal.getDescribe());
            rowData.add(hang);
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