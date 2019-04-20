package utils;

import java.io.File;

/**
 * @ProjectName: flactomp3
 * @Package: utils
 * @ClassName: FileCheck
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/20 11:02
 * @Version: 0.1
 */
public class FileCheck {

    public static boolean checkFilesFormat(File[] files){
        boolean checkresult = true;
        for(File file : files){
            if(! (file.getName().endsWith("qmcflac") || file.getName().endsWith("QMCFLAC")) ){
                checkresult = false;
                break;
            }
        }
        return checkresult;
    }

}
