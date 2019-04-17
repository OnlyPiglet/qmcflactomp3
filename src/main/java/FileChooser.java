
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SuppressWarnings("serial")
public class FileChooser extends JFrame implements ActionListener{
    JButton open=null;

    public FileChooser(){

        open=new JButton("open");
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
        // TODO Auto-generated method stub  
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.setMultiSelectionEnabled(true);
        jfc.showDialog(new JLabel(), "选择");
        File[] files = jfc.getSelectedFiles();
        for(File file : files){
            if(file.isDirectory()){
                continue;
            }else if(file.isFile()){
                Queue.addFiles(file.getAbsolutePath());
            }
        }

        CountDownLatch cl = new CountDownLatch(Resources.Thread_Count);
        ExecutorService es = Executors.newFixedThreadPool(Resources.Thread_Count);
        for(int i=0;i<Resources.Thread_Count;i++){
            es.submit(new SingleTask(cl));
        }
        try {
            cl.await();
        }catch (InterruptedException ie){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, ie.getMessage(), "错误信息",JOptionPane.ERROR_MESSAGE);
        }finally {
            es.shutdown();
            if(es.isShutdown()){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "转化完毕", "操作提示",JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

}