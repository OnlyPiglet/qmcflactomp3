package ui;

/**
 * @ProjectName: flactomp3
 * @Package: ui
 * @ClassName: UiStart
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/20 10:58
 * @Version: 0.1
 */
public class UiStart implements Runnable {
    @Override
    public void run() {
        new FileChooser();
    }
}
