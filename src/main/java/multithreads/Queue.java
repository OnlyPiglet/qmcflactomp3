package multithreads;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ProjectName: flactomp3
 * @Package: PACKAGE_NAME
 * @ClassName: multithreads.Queue
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/17 23:30
 * @Version: 0.1
 */
public class Queue
{

    private static final ConcurrentLinkedQueue<String> files  = new ConcurrentLinkedQueue<>();


    public static void addFiles(String filename){
        files.add(filename);
    }

    public static synchronized String getFile(){
        return files.poll();
    }

    public static void reset(){
        files.clear();
    }

}
