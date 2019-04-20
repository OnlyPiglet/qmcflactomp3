import ui.FileChooser;
import ui.UiStart;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectName: flactomp3
 * @Package: PACKAGE_NAME
 * @ClassName: Application
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/17 17:11
 * @Version: 0.1
 */
public class Application {

    public static void main(String[] args) {
        new Thread(new UiStart()).start();
    }

}
