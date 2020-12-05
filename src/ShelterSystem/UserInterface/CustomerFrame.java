package ShelterSystem.UserInterface;

import ShelterSystem.Base.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

//主界面
public class CustomerFrame extends JFrame {
    private JMenuBar menuBar;    //应用菜单条。

    private JMenu animalManagemer;    //"动物管理"菜单。
    private JMenu applicationManager;  //"申请管理"菜单。
    private JMenu personalManagement;   //"个人管理"菜单。

    private JMenuItem queryAnimal;    //"查询动物信息"菜单项。

    private JMenuItem addApplication;    //"添加申请"菜单项。
    private JMenuItem queryApplication;    //"查询申请"菜单项。

    private JMenuItem changeInformation;    //"修改用户信息"菜单项。
    private JMenuItem logout;    //"退出登录"菜单项。

    private JFrame jf;    //当前窗口。
    private User user;//当前用户。

    public CustomerFrame(User user) {
        super("普通用户界面    在线用户：" + user.getName());
        this.user = user;
        this.jf = this;
    }

    public void run() {
        menuBar = new JMenuBar();    //创建菜单条。
        this.setJMenuBar(menuBar);    //添加菜单条。

        animalManagemer = new JMenu("动物");
        menuBar.add(animalManagemer);

        queryAnimal = new JMenuItem("查询动物信息");
        queryAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                QueryAnimalFrame queryAnimalFrame = new QueryAnimalFrame(jf, "查询动物信息", true);
            }
        });
        animalManagemer.add(queryAnimal);

        applicationManager = new JMenu("申请");
        menuBar.add(applicationManager);

        addApplication = new JMenuItem("提交申请");
        addApplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO
                AddApplicationFrame addApplicationFrame = new AddApplicationFrame(jf, "提交申请", true);
            }
        });
        applicationManager.add(addApplication);

        queryApplication = new JMenuItem("申请查询");
        queryApplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryFrame queryFrame = new QueryFrame(jf, "申请查询", true, "User");
            }
        });
        applicationManager.add(queryApplication);

        personalManagement = new JMenu("个人管理");
        menuBar.add(personalManagement);

//        changeInformation = new JMenuItem("信息修改");
//        changeInformation.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO
//                //UpdatePasswordFrame frame = new UpdatePasswordFrame(jf, "修改密码", true, user);
//            }
//        });
//        personalManagement.add(changeInformation);

        logout = new JMenuItem("退出登录");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();    //关闭当前窗口
                //修改登陆状态
                user = null;
                try {
                    LoginFrame loginFrame = new LoginFrame();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        personalManagement.add(logout);    //添加"退出登录"菜单项。

        this.setSize(578, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        WindowUtil.setFrameCenter(this);//设置窗体居中。

        ImagePanel imagePanel = new ImagePanel();
        setContentPane(imagePanel);

        this.setVisible(true);//设置窗体可见。
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosed(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

}