package ShelterSystem.UserInterface;

import ShelterSystem.Base.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddApplicationFrame extends JDialog {
    private JButton add_Button;    //"添加"按钮。
    private JButton cancel_Button;    //"取消"按钮。
    private JLabel applicationType;    //"编码"标签。
    private JLabel applicationCode;    //"种类"标签。
    private JLabel applicationDate;    //"昵称"标签。
    private JLabel applicationAnimalCode;    //"收养日期"。
    private JLabel applicationCost;    //"描述"标签。
    private JLabel applicationTime;    //"描述"标签。
    private JLabel applicationAdjust;    //"描述"标签。
    private JLabel applicationDescribe;    //"描述"标签。
    private JTextField animalCodeText;    //"编码"文本域。
    private JTextField animalTypeText;    //"种类"文本域。
    private JTextField animalNameText;    //"昵称"文本域。
    private JTextField adoptDateText;    //"收养日期"文本域。
    private JTextField animalDescribeText;    //"描述"文本域。
    private JTextField strAText;    //"描述"文本域。
    private JTextField strBText;    //"描述"文本域。
    private JTextField strCText;    //"描述"文本域。
    private JDialog jd;    //当前窗口。

    /**
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public AddApplicationFrame(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.jd = this;
        this.setSize(350, 429);    //设置窗体大小。
        this.setLayout(null);    //设置空布局。

        JOptionPane.showMessageDialog(jd, "寄送(Deposit)申请不需要填写“开销”“收养时间”“接受调剂”！\n" +
                "领养(Adopt)申请不需要填写“描述”！", "注意！", JOptionPane.WARNING_MESSAGE);

        applicationType = new JLabel("申请种类:");
        applicationType.setBounds(78, 48, 60, 20);
        this.add(applicationType);

        animalCodeText = new JTextField();
        animalCodeText.setBounds(135, 48, 150, 20);
        this.add(animalCodeText);

        applicationCode = new JLabel("申请编码:");
        applicationCode.setBounds(78, 88, 60, 20);
        this.add(applicationCode);

        animalTypeText = new JTextField();
        animalTypeText.setBounds(135, 88, 150, 20);
        this.add(animalTypeText);

        applicationDate = new JLabel("申请日期:");
        applicationDate.setBounds(78, 128, 60, 20);
        this.add(applicationDate);

        animalNameText = new JTextField();
        animalNameText.setBounds(135, 128, 150, 20);
        this.add(animalNameText);

        applicationAnimalCode = new JLabel("动物编码:");
        applicationAnimalCode.setBounds(78, 168, 60, 20);
        this.add(applicationAnimalCode);

        adoptDateText = new JTextField();
        adoptDateText.setBounds(135, 168, 150, 20);
        this.add(adoptDateText);

        applicationCost = new JLabel("期望开销:");
        applicationCost.setBounds(78, 208, 60, 20);
        this.add(applicationCost);

        animalDescribeText = new JTextField();
        animalDescribeText.setBounds(135, 208, 150, 20);
        this.add(animalDescribeText);

        applicationTime = new JLabel("收养时长：");
        applicationTime.setBounds(78, 248, 60, 20);
        this.add(applicationTime);

        strAText = new JTextField();
        strAText.setBounds(135, 248, 150, 20);
        this.add(strAText);

        applicationAdjust = new JLabel("接受调剂？");
        applicationAdjust.setBounds(78, 288, 60, 20);
        this.add(applicationAdjust);

        strBText = new JTextField();
        strBText.setBounds(135, 288, 150, 20);
        this.add(strBText);

        applicationDescribe = new JLabel("具体描述：");
        applicationDescribe.setBounds(78, 328, 60, 20);
        this.add(applicationDescribe);

        strCText = new JTextField();
        strCText.setBounds(135, 328, 150, 20);
        this.add(strCText);

        add_Button = new JButton("添加");
        add_Button.setBounds(70, 360, 60, 25);

        //注册"确认"按钮事件监听
        add_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String code = animalCodeText.getText().trim();
                String type = animalTypeText.getText().trim();
                String nickname = animalNameText.getText().trim();
                String date = adoptDateText.getText().trim();
                String describe = animalDescribeText.getText().trim();
                String stra = strAText.getText().trim();
                String strb = strBText.getText().trim();
                String strc = strCText.getText().trim();

                //数据校验部分
                if (code.equals("")) {
                    JOptionPane.showMessageDialog(jd, "申请种类不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (type.equals("")) {
                    JOptionPane.showMessageDialog(jd, "申请编码不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (nickname.equals("")) {
                    JOptionPane.showMessageDialog(jd, "申请日期！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (date.equals("")) {
                    JOptionPane.showMessageDialog(jd, "动物编码不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (code.equals("Adopt") && describe.equals("")) {
                    JOptionPane.showMessageDialog(jd, "期望开销不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (code.equals("Adopt") && stra.equals("")) {
                    JOptionPane.showMessageDialog(jd, "收养动物的时间不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (code.equals("Adopt") && strb.equals("")) {
                    JOptionPane.showMessageDialog(jd, "接受调剂不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (code.equals("Deposit") && strc.equals("")) {
                    JOptionPane.showMessageDialog(jd, "描述不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (code.equals("Adopt") && !describe.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(jd, "请输入正确的开销格式！需要纯数字！", "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (code.equals("Adopt")) {
                    AdoptApplication application = new AdoptApplication(type, nickname, AnimalShelterSystem.system.animalCatalog.getAnimal(date), Integer.parseInt(describe), stra, toBool(strb));
                    AnimalShelterSystem.system.applicationManager.addApplicationItem(new ApplicationItem(application));
                } else if (code.equals("Deposit")) {
                    DepositApplication application = new DepositApplication(type, nickname, AnimalShelterSystem.system.animalCatalog.getAnimal(date), strc);
                    AnimalShelterSystem.system.applicationManager.addApplicationItem(new ApplicationItem(application));
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
        cancel_Button.setBounds(260, 360, 60, 25);
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

    private static boolean toBool(String str) {
        return str.equals("true") || str.equals("yes");
    }

}