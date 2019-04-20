package ui;

import multithreads.Queue;
import multithreads.SignleTaskStartEngine;
import multithreads.SingleTask;
import utils.FileCheck;
import utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SuppressWarnings("serial")
public class FileChooser extends JFrame implements ActionListener{
    JButton open=null;

    public FileChooser(){
        open=new JButton("选择需要转换的qmcflac的文件");
        open.setBounds(1200,900,400,300);
        this.add(open);
        this.setBounds(800, 600, 800, 600);
        this.setVisible(true);
        this.setTitle("OnlyPiglet QmcflacToMp3");
        Toolkit tk= Toolkit.getDefaultToolkit();
        Image image = tk.getImage(this.getClass().getClassLoader().getResource("icon.jpg"));
        this.setIconImage(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        open.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.setMultiSelectionEnabled(true);
        jfc.showDialog(new JLabel(), "选择");
        File[] files = jfc.getSelectedFiles();

        if(!FileCheck.checkFilesFormat(files)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "存在非qmcflac格式的音乐"+System.lineSeparator()+"请检查后再次运行", "错误信息",JOptionPane.ERROR_MESSAGE);
        }else{
            for(File file : files){
                if(file.isDirectory()){
                    continue;
                }else if(file.isFile()){
                    Queue.addFiles(file.getAbsolutePath());
                }
            }
            new Thread(new SignleTaskStartEngine()).start();
        }

    }

}