package multithreads;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectName: flactomp3
 * @Package: multithreads
 * @ClassName: ThreadExceptionHandler
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/20 10:40
 * @Version: 0.1
 */
public class ThreadExceptionHandler   {

    public static void setHandler(){
        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误信息",JOptionPane.ERROR_MESSAGE);
        });
    }
}
