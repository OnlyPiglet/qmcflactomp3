import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.concurrent.CountDownLatch;

/**
 * @ProjectName: flactomp3
 * @Package: PACKAGE_NAME
 * @ClassName: SingleTask
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/17 17:33
 * @Version: 0.1
 */
public class SingleTask implements Runnable {

    private CountDownLatch cl;

    private volatile  boolean isRun = true;

    public SingleTask(CountDownLatch cl){
        this.cl = cl;
    }

    @Override
    public void run() {

            while (isRun) {
                try {
                String filename = Queue.getFile();
                if (filename == null) {
                    System.out.println("isRun over");
                    isRun = false;
                    break;
                }
                FileInputStream fis = new FileInputStream(new File(filename));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                Decode dc = new Decode();
                for (int i = 0; i < buffer.length; ++i) {
                    buffer[i] = (byte) (dc.NextMask() ^ buffer[i]);
                }
                FileOutputStream fos = new FileOutputStream(new File(filename.replace(".qmcflac",".mp3")));
                fos.write(buffer);
                fos.flush();
                fos.close();
                fis.close();
                }catch ( IOException e){
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, e.getMessage(), "错误信息",JOptionPane.ERROR_MESSAGE);
                }
            }
            cl.countDown();
        System.out.println(cl.getCount());

    }

}
