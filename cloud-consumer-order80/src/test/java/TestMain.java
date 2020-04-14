import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunbaojin
 * @date 2020/4/14 19:01
 */
public class TestMain {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
    }

    public final  int getIndex(){
        int num1 ;
        int num2;
        do{
            num1 = atomicInteger.get();
            num2 = num1 +1;
        } while (atomicInteger.compareAndSet(num1,num2));
        return  num2;
    }

}
