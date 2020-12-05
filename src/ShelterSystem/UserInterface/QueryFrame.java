package ShelterSystem.UserInterface;

import ShelterSystem.Base.Animal;
import ShelterSystem.Base.AnimalShelterSystem;
import ShelterSystem.Base.ApplicationItem;
import ShelterSystem.Base.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

//查询学生信息界面
public class QueryFrame extends JDialog {
    private JPanel jp1, jp2, jp3;    //面板。
    private JLabel query_Label;    //标签。
    private JButton query_Button;    //"查询"按钮。
    private JComboBox query_List;    //"查询"选项。
    private JButton preciseQuery_Button;    //"精确查询"按钮。
    private JTextField query_Text;    //"查询"文本域。
    private JTable jt;    //表格。
    private JScrollPane jsp;    //滚动条。
    private JDialog jd;    //当前窗口。
    private JButton details_Button;    //"详细信息"按钮。
    private Model model;

    /**
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public QueryFrame(JFrame owner, String title, boolean modal, String type) {
        super(owner, title, modal);
        this.jd = this;
        Container c = this.getContentPane();

        jp1 = new JPanel();

        preciseQuery_Button = new JButton("查看所有信息");
        //注册"多条件查询"按钮事件监听
        preciseQuery_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model = new Model(type, jd);//构建新的数据模型类，并更新
                jt.setModel(model);//更新Jtabler
            }
        });
        jp1.add(preciseQuery_Button);

        c.add(jp1, BorderLayout.NORTH);    //添加面板

        jp2 = new JPanel();
        jt = new JTable();

        jsp = new JScrollPane(jt);
        jp2.add(jsp);
        c.add(jp2, BorderLayout.CENTER);    //添加面板

        jp3 = new JPanel();
        details_Button = new JButton("删除");

        details_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int rowNum = jt.getSelectedRow();
                if (rowNum == -1) {
                    JOptionPane.showMessageDialog(jd, "请选择要删除的那一行！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String str = (String) model.getValueAt(rowNum, 0);
                if (type.equals("User")) {
                    for (User user : AnimalShelterSystem.system.userCatalog) {
                        if (user.toString().equals(str))
                            AnimalShelterSystem.system.userCatalog.removeUser(user);
                    }
                } else {
                    for (ApplicationItem applicationItem : AnimalShelterSystem.system.applicationManager) {
                        if (applicationItem.toString().equals(str))
                            AnimalShelterSystem.system.applicationManager.removeApplicationItem(applicationItem);
                    }
                }
                try {
                    AnimalShelterSystem.system.saveDada();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(jd, "删除成功！请刷新页面！", "", JOptionPane.WARNING_MESSAGE);
            }
        });
        jp3.add(details_Button);
        c.add(jp3, BorderLayout.SOUTH);

        this.setSize(600, 540);
        this.setResizable(false);
        WindowUtil.setFrameCenter(this);//设置窗体居中。
        this.setVisible(true);
    }
}