import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreeTest {
    BinaryTree binaryTree = new BinaryTree();
    int size = 0;

    @Test
    public void size() {
        size = 1;
        binaryTree.add(1);
        Assert.assertEquals(size,binaryTree.size());
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(0,binaryTree.size());
    }

    @Test
    public void contains() {
        binaryTree.add(1);
        binaryTree.contains(1);
        Assert.assertTrue(true);
        System.out.println(binaryTree);
    }

    @Test
    public void iterator() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void add() {
        binaryTree.add(1);
        Assert.assertEquals(1,binaryTree.size());
        binaryTree.add(2);
        Assert.assertEquals(2,binaryTree.size());
        binaryTree.add(-1);
        binaryTree.add(-2);
        Assert.assertEquals(4,binaryTree.size());
        System.out.println(binaryTree);
    }

    @Test
    public void remove() {
        binaryTree.add(1);
        binaryTree.remove(1);
        Assert.assertEquals(0,binaryTree.size());
        System.out.println(binaryTree);
    }

    @Test
    public void addAll() {
        binaryTree.add(9);
        binaryTree.add(6);
        binaryTree.add(-5);
        List list = new ArrayList();
        list.add(5);
        list.add(-8);
        binaryTree.addAll(list);
        System.out.println(binaryTree);
        Assert.assertEquals(5,binaryTree.size());

    }

    @Test
    public void clear() {
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(-5);
        binaryTree.clear();
        Assert.assertEquals(0, binaryTree.size());
    }

    @Test
    public void removeAll() {
        binaryTree.add(9);
        binaryTree.add(7);
        binaryTree.add(-5);
        List list = new ArrayList();
        list.add(5);
        list.add(-8);
        list.add(6);
        binaryTree.addAll(list);
        System.out.println(binaryTree);
        Assert.assertEquals(6, binaryTree.size());
        binaryTree.removeAll(list);
        System.out.println(binaryTree);
        Assert.assertEquals(3, binaryTree.size());
    }

    @Test
    public void retainAll() {
        binaryTree.add(1);
        binaryTree.add(-2);
        binaryTree.add(3);
        List list = new ArrayList();
        list.add(4);
        list.add(-5);
        list.add(6);
        binaryTree.addAll(list);
        binaryTree.retainAll(list);
        Assert.assertEquals(3, binaryTree.size());
    }

    @Test
    public void containsAll() {
        binaryTree.add(1);
        binaryTree.add(-2);
        binaryTree.add(3);
        List list = new ArrayList();
        list.add(4);
        list.add(-5);
        list.add(6);
        binaryTree.addAll(list);
        System.out.println(binaryTree.containsAll(list));
        Assert.assertTrue(binaryTree.containsAll(list));
    }

    @Test
    public void testToArray() {
    }
}