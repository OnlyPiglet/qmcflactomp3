package multithreads;

/**
 * @ProjectName: flactomp3
 * @Package: multithreads
 * @ClassName: ThreadException
 * @Author: 吴成昊
 * @Description:
 * @Date: 2019/4/20 10:37
 * @Version: 0.1
 */
public class ThreadException extends RuntimeException {
    public ThreadException(){
        super();
    }

    public ThreadException(Throwable e){
        super(e);
    }

    public ThreadException(String msg){
        super(msg);
    }

    public ThreadException(String msg,Throwable e){
        super(msg,e);
    };


}
