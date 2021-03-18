import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BTreeTest {
    private int order = 3;
    private BTree<Integer> btree = new BTree<Integer>(order);

    @Test
    public void insertionTest(){
        //testing the split at max amount of keys in root node
        btree.add(1);
        assertEquals(1, btree.size());
        btree.add(2);
        btree.add(3);
        btree.add(4);
        btree.add(5);
        assertEquals(0, btree.getRoot().numberOfChildren());
        btree.add(6);
        assertEquals(2, btree.getRoot().numberOfChildren());
        //testing the max amount of children
        btree.add(0);
        btree.add(-1);
        btree.add(-2);
        assertEquals(3, btree.getRoot().numberOfChildren());
        btree.add(-3);
        btree.add(-4);
        btree.add(-5);
        assertEquals(4, btree.getRoot().numberOfChildren());
        btree.add(-6);
        btree.add(-7);
        btree.add(-8);
        assertEquals(5, btree.getRoot().numberOfChildren());
        btree.add(-9);
        btree.add(-10);
        btree.add(-11);
        assertEquals(6, btree.getRoot().numberOfChildren());
        btree.add(-12);
        btree.add(-13);
        btree.add(-14);
        assertEquals(2, btree.getRoot().numberOfChildren());
    }

    //testing the restructure of the tree after delete operation
    @Test
    public void deleteTest(){
        btree.add(1);
        btree.add(2);
        btree.add(3);
        btree.add(4);
        btree.add(5);
        btree.add(6);
        assertEquals(2, btree.getRoot().numberOfChildren());
        btree.remove(5);
        assertEquals(0, btree.getRoot().numberOfChildren());
    }

    @Test
    public void minimumKeyAmountTest(){
        /*Random random = new Random();
        for (int i = 0; i < 100; i++){
            btree.add(random.nextInt());
        }*/
        btree.add(1);
        btree.add(2);
        btree.add(3);
        btree.add(4);
        btree.add(5);
        btree.add(6);
        assertTrue(checkKeyAmount(btree.getRoot()));
    }

    @Test
    public void keyOrderTest(){
        /*Random random = new Random();
        for (int i = 0; i < 100; i++){
            btree.add(random.nextInt());
        }*/
        btree.add(1);
        btree.add(2);
        btree.add(3);
        btree.add(4);
        btree.add(5);
        btree.add(6);
        assertTrue(checkKeyOrder(btree.getRoot()));
    }

    private boolean checkKeyAmount(BTree.Node<Integer> node){
        if (node.numberOfKeys() < order-1 && !node.equals(btree.getRoot()))
            return false;
        for (int i = 0; i < node.numberOfChildren(); i++){
            if (!checkKeyAmount(node.getChild(i))){
                return false;
            }
        }
        return true;
    }

    private boolean checkKeyOrder(BTree.Node<Integer> node){
        int previousKey = node.getKey(0);
        for (int i = 1; i < node.numberOfKeys(); i++){
            if (previousKey > node.getKey(i)){
                return false;
            }
        }
        for (int i = 0; i < node.numberOfChildren(); i++){
            if (!checkKeyAmount(node.getChild(i))){
                return false;
            }
        }
        return true;
    }
}
