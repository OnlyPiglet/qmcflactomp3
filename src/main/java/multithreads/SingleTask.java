package multithreads;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.concurrent.CountDownLatch;

/**
 * @ProjectName: flactomp3
 * @Package: PACKAGE_NAME
 * @ClassName: multithreads.SingleTask
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/17 17:33
 * @Version: 0.1
 */
public class SingleTask implements Runnable {

    private CountDownLatch cl;

    private volatile boolean isRun = true;

    public SingleTask(CountDownLatch cl){
        this.cl = cl;
    }

    @Override
    public void run() throws ThreadException{
        try {
            while (isRun) {
                System.out.println(Thread.currentThread().getName());
                String filename = multithreads.Queue.getFile();
                if (filename == null) {
                    isRun = false;
                    break;
                }
                FileInputStream fis = new FileInputStream(new File(filename));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                algorithm.Decode dc = new algorithm.Decode();
                for (int i = 0; i < buffer.length; ++i) {
                    buffer[i] = (byte) (dc.NextMask() ^ buffer[i]);
                }
                System.out.println(filename);
                FileOutputStream fos = new FileOutputStream(new File(filename.replace(".qmcflac",".mp3")));
                fos.write(buffer);
                fos.flush();
                fos.close();
                fis.close();
            }
        }catch ( IOException e){
            //在发生异常时弹出警告
            throw new ThreadException(e);
        }finally {
            cl.countDown();
            isRun = false;
        }
    }

}
