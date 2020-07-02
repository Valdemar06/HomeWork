import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMapTest {
    Student ivanov = new Student(2, "ivanov");
    Student stack = new Student(5, "stack");
    Student demo = new Student(4, "demo");

    MyMap map = new MyMap();
    Student student = new Student(2, "Student");
    Student  kto = new Student(5, "Kto");


    @Test
    public void size() {
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void isEmpty() { Assert.assertTrue(map.isEmpty()); }

    @Test
    public void containsKey() {
        map.put(student, "Normas");
        Assert.assertTrue(map.containsKey(student));
        Assert.assertFalse(map.containsKey(kto));
    }

    @Test
    public void containsValue() {
        map.put(student, "Normas");
        Assert.assertTrue(map.containsValue("Normas"));
        Assert.assertFalse(map.containsValue("KTO"));
    }

    @Test
    public void get() {
        map.get(student);
        map.put(student, "Normas");
        Assert.assertEquals("Normas", map.get(student));
    }

    @Test
    public void put() {
        map.put(student, "Normas");
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void remove() {
        map.put(student, "Normas");
        map.remove(student);
        Assert.assertEquals(0,map.size());
    }

    @Test
    public void putAll() {
        Map hash  = new HashMap();
        hash.put(demo, "Demo");
        hash.put(student, "Student");
        map.put(ivanov, "good Student");
        map.put(stack, "Hello");
        map.putAll(hash);
        Assert.assertEquals(4, map.size());
    }

    @Test
    public void clear() {
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void keySet() {
        map.put(ivanov, "Ivanov");
        map.put(stack, "Stack");
        map.put(demo, "Demo");
        Set set = map.keySet();
        Assert.assertEquals(3, set.size());
    }

    @Test
    public void values() {
        map.put(ivanov, "Ivanov");
        map.put(stack, "Stack");
        map.put(demo, "Demo");
        Collection collection = map.values();
        Assert.assertEquals(3, collection.size());
    }

    @Test
    public void entrySet() {
        map.put(ivanov, "Ivanov");
        map.put(stack, "Stack");
        map.put(demo, "Demo");
        Set entry = map.entrySet();
        Assert.assertEquals(2,entry.size());
    }
}