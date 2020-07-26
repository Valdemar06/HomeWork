import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
       /* List<String> array = new ArrayList<>();
        FileReader fileReader = new FileReader("C:\\Users\\Valdemar\\IdeaProjects\\Lessons19\\Password.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while (line!= null) {
            array.add(line);
            System.out.println(line);
            line = bufferedReader.readLine();
        }*/
        BruteForce bruteForce = new BruteForce("f016441d00c16c9b912d05e9d81d894d");
        BruteForce bruteForce2 = new BruteForce("5ebe2294ecd0e0f08eab7690d2a6ee69");
        BruteForce bruteForce3 = new BruteForce("13d70e09909669272b19647c2a55dacb");
        BruteForce bruteForce4 = new BruteForce("5f50dfa5385e66ce46ad8d08a9c9be68");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        threadPoolExecutor.submit(bruteForce);
        threadPoolExecutor.submit(bruteForce2);
        threadPoolExecutor.submit(bruteForce3);
        threadPoolExecutor.submit(bruteForce4);
    }
}
