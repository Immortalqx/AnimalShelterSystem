package ShelterSystem.UserInterface;

import ShelterSystem.Base.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddUserFrame extends JDialog {
    private JButton add_Button;    //"添加"按钮。
    private JButton cancel_Button;    //"取消"按钮。
    private JLabel userCode;    //"编码"标签。
    private JLabel userType;    //"种类"标签。
    private JLabel userName;    //"昵称"标签。
    private JLabel adoptDate;    //"收养日期"。
    private JLabel userDescribe;    //"描述"标签。
    private JTextField userCodeText;    //"编码"文本域。
    private JTextField userTypeText;    //"种类"文本域。
    private JTextField userNameText;    //"昵称"文本域。
    private JTextField adoptDateText;    //"收养日期"文本域。
    private JTextField userDescribeText;    //"描述"文本域。
    private JDialog jd;    //当前窗口。

    /**
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public AddUserFrame(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.jd = this;
        this.setSize(350, 429);    //设置窗体大小。
        this.setLayout(null);    //设置空布局。

        userCode = new JLabel("权限:");
        userCode.setBounds(78, 48, 30, 20);
        this.add(userCode);

        userCodeText = new JTextField();
        userCodeText.setBounds(116, 48, 150, 20);
        this.add(userCodeText);

        userType = new JLabel("账号:");
        userType.setBounds(78, 88, 30, 20);
        this.add(userType);

        userTypeText = new JTextField();
        userTypeText.setBounds(116, 88, 150, 20);
        this.add(userTypeText);

        userName = new JLabel("密码:");
        userName.setBounds(78, 128, 30, 20);
        this.add(userName);

        userNameText = new JTextField();
        userNameText.setBounds(116, 128, 150, 20);
        this.add(userNameText);

        adoptDate = new JLabel("姓名:");
        adoptDate.setBounds(78, 168, 30, 20);
        this.add(adoptDate);

        adoptDateText = new JTextField();
        adoptDateText.setBounds(116, 168, 150, 20);
        this.add(adoptDateText);

        userDescribe = new JLabel("电话:");
        userDescribe.setBounds(78, 208, 30, 20);
        this.add(userDescribe);

        userDescribeText = new JTextField();
        userDescribeText.setBounds(116, 208, 150, 20);
        this.add(userDescribeText);

        add_Button = new JButton("添加");
        add_Button.setBounds(70, 330, 60, 25);

        //注册"确认"按钮事件监听
        add_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String code = userCodeText.getText().trim();
                String type = userTypeText.getText().trim();
                String nickname = userNameText.getText().trim();
                String date = adoptDateText.getText().trim();
                String describe = userDescribeText.getText().trim();

                //数据校验部分
                if (code.equals("")) {
                    JOptionPane.showMessageDialog(jd, "用户权限设置不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (type.equals("")) {
                    JOptionPane.showMessageDialog(jd, "账号不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (nickname.equals("")) {
                    JOptionPane.showMessageDialog(jd, "密码不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (describe.equals("")) {
                    JOptionPane.showMessageDialog(jd, "姓名不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (date.equals("")) {
                    JOptionPane.showMessageDialog(jd, "电话不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                switch (code) {
                    case "管理员", "Administrator" -> {
                        Administrator administrator = new Administrator(type, nickname, date, describe, null, 0);
                        AnimalShelterSystem.system.userCatalog.addUser(administrator);
                    }
                    case "员工", "Employee" -> {
                        Employee employee = (Employee) new Employee(type, nickname, date, describe, null, null, 0);
                        AnimalShelterSystem.system.userCatalog.addUser(employee);
                    }
                    case "普通用户", "Customer" -> {
                        Customer customer = (Customer) new Customer(type, nickname, date, describe);
                        AnimalShelterSystem.system.userCatalog.addUser(customer);
                    }
                    default -> {
                        JOptionPane.showMessageDialog(jd, "权限设置错误！！！", "", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                try {
                    AnimalShelterSystem.system.saveDada();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(jd, "添加成功！");
                jd.dispose();    //关闭当前窗口
            }
        });
        this.add(add_Button);

        cancel_Button = new JButton("取消");
        cancel_Button.setBounds(230, 330, 60, 25);
        //注册"取消"按钮事件监听
        cancel_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                jd.dispose();

            }
        });
        this.add(cancel_Button);

        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }


}