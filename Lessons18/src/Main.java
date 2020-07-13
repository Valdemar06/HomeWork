import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        long time =  System.currentTimeMillis();
        ObjectMapper mapper = new ObjectMapper();
        ObjectInputStream objectInputStream = new ObjectInputStream
                (new FileInputStream("OutStream.out"));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (new FileOutputStream("OutStream.out"));
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 100001 ; i++) {
            list.add(i, new Student(i, i));
        }
        try {

            /**
             * Create file
             */
            File file = new File("Test.json");
            /**
             * Write to file format Json
             */
            long usedBytesJson = Runtime.getRuntime().totalMemory()
                    - Runtime.getRuntime().freeMemory();
            String memory = "Memory (" + usedBytesJson / 1048576 + ")  mb" + " JSON";
            list.add(memory);
            System.out.println("How much memory is the file: " + memory);
            double first = (double) (System.currentTimeMillis() - time);
            String timeRecordJson = "Record execution JSON: " + first + " ms";
            list.add(timeRecordJson);
            mapper.writeValue(file, list);
            System.out.println(timeRecordJson);

            /**
             * Serialized
             */
            long usedBytes = Runtime.getRuntime().totalMemory()
                    - Runtime.getRuntime().freeMemory();
            String memorySerialized = "Memory (" + usedBytes / 1048576 + ")  mb" + " Serialized";
            list.remove(memory);
            list.remove(timeRecordJson);
            list.add(memorySerialized);
            double middle = (double) (System.currentTimeMillis() - time);
            String timeSerialized = "Record execution Serialized: " + middle + " ms";
            list.add(timeSerialized);
            System.out.println(timeSerialized);


            /**
             * Deserialize
             */
            double deserialize = (double) (System.currentTimeMillis() - time);
            String timeDeserialize = "Read execution Deserialize: " + deserialize + " ms";
            list.add(timeDeserialize);
            objectOutputStream.writeObject(list);
            List student = (List) objectInputStream.readObject();
            System.out.println(student);
            System.out.println(timeDeserialize);
            System.out.println("How much memory is the file: " + memorySerialized);
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            objectInputStream.close();
            objectOutputStream.close();
        }
    }
}
