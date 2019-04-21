package multithreads;

import ui.FileChooser;
import ui.InfiniteProgressPanel;
import ui.Loading;
import utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

/**
 * @ProjectName: flactomp3
 * @Package: multithreads
 * @ClassName: SignleTaskStartEngine
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/20 10:52
 * @Version: 0.1
 */
public class SignleTaskStartEngine implements Runnable{

    private FileChooser filechooser;

    public SignleTaskStartEngine(FileChooser filechooser){
        this.filechooser = filechooser;
    }

    @Override
    public void run() {
        CountDownLatch cl = new CountDownLatch(Resources.Thread_Count);
        for(int i = 0; i< Resources.Thread_Count; i++){
            new Thread(new SingleTask(cl)).start();
        }
        Loading loading = new Loading(filechooser);
        try {
            loading.startloading();
            cl.await();
        }catch (InterruptedException ie){
        //ingore I think this won't happen ever.

        }finally {
            loading.stoploading();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "本次转化完毕,转换后的MP3音频在QMCFLAC目录下", "操作提示",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
