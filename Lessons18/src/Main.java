import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         * Create file
         */
        File file = new File("Test.json");
        File fileOut = new File("OutStream.out");

        long time =  System.currentTimeMillis();
        ObjectMapper mapper = new ObjectMapper();
        ObjectInputStream objectInputStream = new ObjectInputStream
                (new FileInputStream(fileOut));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (new FileOutputStream(fileOut));
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 1000001 ; i++) {
            list.add(i, new Student(i, i));
        }
        try {

            /**
             * Write to file format Json
             */
            long usedBytesJson = file.length()/(1024*1024);
            String memory = "Memory (" + usedBytesJson +")  mb" + " JSON";
            System.out.println("How much memory is the file: " + memory);
            double first = (double) (System.currentTimeMillis() - time);
            String timeRecordJson = "Record execution JSON: " + first + " ms";
            mapper.writeValue(file, list);
            System.out.println(timeRecordJson);

            /**
             * Read format file Json
             */
            String jsonInString = mapper.writeValueAsString(list);
            //System.out.println(jsonInString);
            double second = (double) (System.currentTimeMillis() - time);
            String timeReadJson = "Read execution JSON: " + second + " ms";
            System.out.println(timeReadJson);
            /**
             * Serialized
             */
            double middle = (double) (System.currentTimeMillis() - time);
            String timeSerialized = "Record execution Serialized: " + middle + " ms";
            objectOutputStream.writeObject(list);
            System.out.println(timeSerialized);

            /**
             * Deserialize
             */
            double deserialize = (double) (System.currentTimeMillis() - time);
            String timeDeserialize = "Read execution Deserialize: " + deserialize + " ms";
            List student = (List) objectInputStream.readObject();
           // System.out.println(student);
            long usedBytes =fileOut.length()/(1024*1024);
            String memorySerialized = "Memory (" + usedBytes + ")  mb" + " Serialized";
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
