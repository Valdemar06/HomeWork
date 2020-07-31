import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args)  {
        MyBruteForce bruteForce = new MyBruteForce("f016441d00c16c9b912d05e9d81d894d");
        MyBruteForce bruteForce1 = new MyBruteForce("5ebe2294ecd0e0f08eab7690d2a6ee69");
        MyBruteForce bruteForce2 = new MyBruteForce("13d70e09909669272b19647c2a55dacb");
        MyBruteForce bruteForce3 = new MyBruteForce("5f50dfa5385e66ce46ad8d08a9c9be68");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        threadPoolExecutor.submit(bruteForce);
        threadPoolExecutor.submit(bruteForce1);
        threadPoolExecutor.submit(bruteForce2);
        threadPoolExecutor.submit(bruteForce3);
        threadPoolExecutor.shutdown();
    }
}