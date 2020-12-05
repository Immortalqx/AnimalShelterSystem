package ShelterSystem.UserInterface;

import ShelterSystem.Base.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

//主界面
public class AdministratorFrame extends JFrame {
    private JMenuBar menuBar;    //应用菜单条。

    private JMenu userManager;         //"用户管理"菜单。
    private JMenu animalManagemer;    //"动物管理"菜单。
    private JMenu applicationManager;  //"申请管理"菜单。
    private JMenu personalManagement;   //"个人管理"菜单。

    private JMenuItem addUser;    //"添加用户"菜单项。
    private JMenuItem queryUser;    //"查询用户信息"菜单项。
    private JMenuItem modifyUser;    //"修改用户信息"菜单项。
    private JMenuItem deleteUser;    //"删除用户"菜单项。

    private JMenuItem addAnimal;    //"添加动物"菜单项。
    private JMenuItem queryAnimal;    //"查询动物信息"菜单项。
    private JMenuItem modifyAnimal;    //"修改动物信息"菜单项。
    private JMenuItem deleteAnimal;    //"删除动物"菜单项。

    private JMenuItem addApplication;    //"添加申请"菜单项。
    private JMenuItem modifyApplication;    //"修改申请"菜单项。
    private JMenuItem queryApplication;    //"查询申请"菜单项。
    private JMenuItem removeApplication;    //"删除申请"菜单项。

    private JMenuItem changeInformation;    //"修改用户信息"菜单项。
    private JMenuItem logout;    //"退出登录"菜单项。

    private JFrame jf;    //当前窗口。
    private User user;//当前用户。

    public AdministratorFrame(User user) {
        super("管理员界面    在线用户：" + user.getName());
        this.user = user;
        this.jf = this;
    }

    public void run() {
        menuBar = new JMenuBar();    //创建菜单条。
        this.setJMenuBar(menuBar);    //添加菜单条。

        userManager = new JMenu("用户管理");
        menuBar.add(userManager);

        addUser = new JMenuItem("添加用户");
        addUser.addActionListener(new ActionListener() {        //注册"添加用户"菜单项事件监听
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUserFrame addUserFrame = new AddUserFrame(jf, "添加用户", true);
            }
        });
        userManager.add(addUser);

        queryUser = new JMenuItem("查询用户信息");
        queryUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                QueryFrame queryFrame = new QueryFrame(jf, "申请查询", true, "User");
            }
        });
        userManager.add(queryUser);

//        modifyUser = new JMenuItem("修改用户信息");
//        modifyUser.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO
//                //ModifyStudentFrame modifyStudentFrame = new ModifyStudentFrame(jf, "修改学生信息", true);
//            }
//        });
//        userManager.add(modifyUser);
//
//        deleteUser = new JMenuItem("删除用户");
//        deleteUser.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO
//                //DeleteStudentFrame deleteStudentFrame = new DeleteStudentFrame(jf, "删除学生", true);
//            }
//        });
//        userManager.add(deleteUser);

        animalManagemer = new JMenu("动物管理");
        menuBar.add(animalManagemer);

        addAnimal = new JMenuItem("添加动物");
        addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                AddAnimalFrame addAnimalFrame = new AddAnimalFrame(jf, "添加动物", true);
            }
        });
        animalManagemer.add(addAnimal);

        queryAnimal = new JMenuItem("查询动物信息");
        queryAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                QueryAnimalFrame queryAnimalFrame = new QueryAnimalFrame(jf, "查询动物信息", true);
            }
        });
        animalManagemer.add(queryAnimal);

//        modifyAnimal = new JMenuItem("修改动物信息");
//        modifyAnimal.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO
//                //ModifyStudentFrame modifyStudentFrame = new ModifyStudentFrame(jf, "修改学生信息", true);
//            }
//        });
//        animalManagemer.add(modifyAnimal);
//
//        deleteAnimal = new JMenuItem("删除动物");
//        deleteAnimal.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO
//                //DeleteStudentFrame deleteStudentFrame = new DeleteStudentFrame(jf, "删除学生", true);
//            }
//        });
//        animalManagemer.add(deleteAnimal);

        applicationManager = new JMenu("申请管理");
        menuBar.add(applicationManager);

        addApplication = new JMenuItem("添加申请");
        addApplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AddApplicationFrame frame = new AddApplicationFrame(jf, "添加申请", true);
            }
        });
        applicationManager.add(addApplication);

//        modifyApplication = new JMenuItem("修改申请");
//        modifyApplication.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO
//                //UpdateStudentScoreFrame frame = new UpdateStudentScoreFrame(jf, "修改学生成绩", true);
//            }
//        });
//        applicationManager.add(modifyApplication);

        queryApplication = new JMenuItem("申请查询");
        queryApplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
                QueryFrame queryFrame = new QueryFrame(jf, "申请查询", true, "Application");
            }
        });
        applicationManager.add(queryApplication);

//        removeApplication = new JMenuItem("删除申请");
//        removeApplication.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO
//                //ScoreAnalyzeOption analyzeOption = new ScoreAnalyzeOption(jf, "成绩分析选项", true);
//            }
//        });
//        applicationManager.add(removeApplication);

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