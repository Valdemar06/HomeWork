import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ListGenericTest {
    List<Integer> listGeneric = new ListGeneric<>();

    @Test
    public void size() { Assert.assertEquals(0, listGeneric.size()); }

    @Test
    public void isEmpty() { Assert.assertTrue(listGeneric.isEmpty()); }

    @Test
    public void contains() {
        listGeneric.add(5);
        Assert.assertTrue(listGeneric.contains(5));
        Assert.assertFalse(listGeneric.contains(9));
    }

    @Test
    public void iterator() {
    }

    @Test
    public void toArray() {
        Object[]newArray = new Object[0];
        Assert.assertArrayEquals(newArray,listGeneric.toArray());
    }

    @Test
    public void testToArray() {
    }

    @Test
    public void add() {
        listGeneric.add(5);
        Assert.assertEquals(1, listGeneric.size());
        Assert.assertTrue(listGeneric.contains(5));
    }

    @Test
    public void remove() {
        Integer five = 5;
        listGeneric.add(6);
        listGeneric.add(five);
        listGeneric.remove(five);
        Assert.assertEquals(1, listGeneric.size());
        Assert.assertFalse(listGeneric.contains(five));
    }

    @Test
    public void containsAll() {
        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        listGeneric.add(6);
        listGeneric.add(7);
        listGeneric.add(8);
        listGeneric.add(9);
        listGeneric.add(10);
        listGeneric.addAll(list);
        Assert.assertTrue(listGeneric.containsAll(list));
    }

    @Test
    public void addAll() {
        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        listGeneric.add(6);
        listGeneric.add(7);
        listGeneric.add(8);
        listGeneric.add(9);
        listGeneric.add(10);
        listGeneric.addAll(list);
        Assert.assertEquals(10, listGeneric.size());
    }

    @Test
    public void testAddAll() {
    }

    @Test
    public void removeAll() {
        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        listGeneric.add(6);
        listGeneric.add(7);
        listGeneric.add(8);
        listGeneric.add(9);
        listGeneric.add(10);
        listGeneric.addAll(list);
        Assert.assertEquals(10,listGeneric.size());
        listGeneric.removeAll(list);
        Assert.assertEquals(5,listGeneric.size());
    }

    @Test
    public void retainAll() {
        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        listGeneric.add(6);
        listGeneric.add(7);
        listGeneric.add(8);
        listGeneric.add(9);
        listGeneric.add(10);
        listGeneric.addAll(list);
        listGeneric.retainAll(list);
        Assert.assertEquals(5, list.size());
        Assert.assertTrue(listGeneric.contains(1));
        Assert.assertTrue(listGeneric.contains(2));
        Assert.assertTrue(listGeneric.contains(3));
        Assert.assertTrue(listGeneric.contains(4));
        Assert.assertTrue(listGeneric.contains(5));
    }

    @Test
    public void clear() {
    }

    @Test
    public void get() {
    }

    @Test
    public void set() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void lastIndexOf() {
    }

    @Test
    public void listIterator() {
    }

    @Test
    public void testListIterator() {
    }

    @Test
    public void subList() {
    }
}