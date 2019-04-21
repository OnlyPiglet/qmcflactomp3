package ui;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectName: flactomp3
 * @Package: ui
 * @ClassName: Loading
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/21 17:58
 * @Version: 0.1
 */
public class Loading {

    private JFrame frame;
    private InfiniteProgressPanel glasspane;

    public Loading(JFrame frame){
        this.frame = frame;
    }
    {
         glasspane = new InfiniteProgressPanel();
    }

    public void startloading(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        glasspane.setBounds(100, 100, (dimension.width) / 2, (dimension.height) / 2);
        frame.setGlassPane(glasspane);
        glasspane.start();//开始动画加载效果
    }

    public void stoploading(){
        glasspane.stop();
    }

}
