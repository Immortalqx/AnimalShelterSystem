package ShelterSystem.UserInterface;

import ShelterSystem.Base.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddAnimalFrame extends JDialog {
    private JButton addButton;    //"添加"按钮。
    private JButton cancelButton;    //"取消"按钮。
    private JLabel animalCode;    //"编码"标签。
    private JLabel animalType;    //"种类"标签。
    private JLabel animalName;    //"昵称"标签。
    private JLabel adoptDate;    //"收养日期"。
    private JLabel animalDescribe;    //"描述"标签。
    private JTextField animalCodeText;    //"编码"文本域。
    private JTextField animalTypeText;    //"种类"文本域。
    private JTextField animalNameText;    //"昵称"文本域。
    private JTextField adoptDateText;    //"收养日期"文本域。
    private JTextField animalDescribeText;    //"描述"文本域。
    private JDialog jd;    //当前窗口。

    /**
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public AddAnimalFrame(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.jd = this;
        this.setSize(350, 429);    //设置窗体大小。
        this.setLayout(null);    //设置空布局。

        animalCode = new JLabel("编码:");
        animalCode.setBounds(78, 48, 30, 20);
        this.add(animalCode);

        animalCodeText = new JTextField();
        animalCodeText.setBounds(116, 48, 150, 20);
        this.add(animalCodeText);

        animalType = new JLabel("种类:");
        animalType.setBounds(78, 88, 30, 20);
        this.add(animalType);

        animalTypeText = new JTextField();
        animalTypeText.setBounds(116, 88, 150, 20);
        this.add(animalTypeText);

        animalName = new JLabel("昵称:");
        animalName.setBounds(78, 128, 30, 20);
        this.add(animalName);

        animalNameText = new JTextField();
        animalNameText.setBounds(116, 128, 150, 20);
        this.add(animalNameText);

        adoptDate = new JLabel("日期:");
        adoptDate.setBounds(78, 168, 30, 20);
        this.add(adoptDate);

        adoptDateText = new JTextField();
        adoptDateText.setBounds(116, 168, 150, 20);
        this.add(adoptDateText);

        animalDescribe = new JLabel("描述:");
        animalDescribe.setBounds(78, 208, 30, 20);
        this.add(animalDescribe);

        animalDescribeText = new JTextField();
        animalDescribeText.setBounds(116, 208, 150, 20);
        this.add(animalDescribeText);

        addButton = new JButton("添加");
        addButton.setBounds(70, 330, 60, 25);

        //注册"确认"按钮事件监听
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String code = animalCodeText.getText().trim();
                String type = animalTypeText.getText().trim();
                String nickname = animalNameText.getText().trim();
                String date = adoptDateText.getText().trim();
                String describe = animalDescribeText.getText().trim();

                //数据校验部分
                if (code.equals("")) {
                    JOptionPane.showMessageDialog(jd, "编号不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (type.equals("")) {
                    JOptionPane.showMessageDialog(jd, "种类不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (nickname.equals("")) {
                    JOptionPane.showMessageDialog(jd, "昵称不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (describe.equals("")) {
                    JOptionPane.showMessageDialog(jd, "描述不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (date.equals("")) {
                    JOptionPane.showMessageDialog(jd, "日期不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!date.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(jd, "日期格式不正确！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Animal animal = new Animal(code, type, nickname, Integer.parseInt(date), describe);
                AnimalShelterSystem.system.animalCatalog.addAnimal(animal);
                try {
                    AnimalShelterSystem.system.saveDada();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(jd, "添加成功！");
                jd.dispose();    //关闭当前窗口
            }
        });
        this.add(addButton);

        cancelButton = new JButton("取消");
        cancelButton.setBounds(230, 330, 60, 25);
        //注册"取消"按钮事件监听
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                jd.dispose();

            }
        });
        this.add(cancelButton);

        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }


}