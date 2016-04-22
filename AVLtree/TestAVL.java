/**
 * A test driver for the AVLTree class.
 * Tests the insertion, deletion(?), find,
 * height, single/outter rotation, toString,
 * and double/inner rotation methods.
 * 
 * @author Sean Reddell
 * @version 4/22/16
 */
public class TestAVL
{
    /**
     * Builds an unbalanced tree to test the
     * outter left rotation method.
     * 
     * @return True if tree is balanced (passes test).
     */
    private boolean testSLR()
    {
        String targ1 = "12 8 4 2 6 10 16 14";
        String targ2 = "12 4 2 1 8 6 10 16 14";
        
        AVLTree slr = new ALVTree();
        slr.insert(12);
        slr.insert(8);
        slr.insert(16);
        slr.insert(4);
        slr.insert(10);
        slr.insert(14);
        slr.insert(2);
        slr.insert(6);
        
        if (!(slr.toString().equals(targ1))) return false;
        
        slr.insert(1);
        
        return slr.toString().equals(targ2);
        
    }
    
    /**
     * Builds an unbalanced tree to test the
     * outter left rotation method.
     * 
     * @return True if tree is balanced (passes test).
     */
    private boolean testSRR()
    {
        String targ1 = "12 8 10 20 15 25 23 28";
        String targ2 = "12 8 10 25 20 15 23 28 30";
        
        AVLTree srr = new AVLTree();
        srr.insert(12);
        srr.insert(8);
        srr.insert(20);
        srr.insert(10);
        srr.insert(15);
        srr.insert(25);
        srr.insert(23);
        srr.insert(28);
        
        if (!(srr.toString().equals(targ1))) return false;
        
        srr.insert(30);
        
        return srr.toString().equals(targ2);
    }
    
    /**
     * Builds an unbalanced tree to test the
     * inner left rotation method.
     * 
     * @return True if tree is balanced (passes test).
     */
    private boolean testDLR()
    {
    }
    
    /**
     * Builds an unbalanced tree to test the
     * inner right rotation method.
     * 
     * @return True if tree is balanced (passes test).
     */
    private boolean testDRR()
    {
    }
    
    /**
     * Tests whether node heights are correct
     * after rotations.
     * 
     * @return True if heights are correct (passes test).
     */
    private boolean testHeight()
    {
        AVLTree testH = new AVLTree();
        
        if (testH.height() != -1) return false;
        
        testH.insert(12);
        
        if (testH.height() != 0) return false;
        if (testH.heightOf(12) != 0) return false;
        
        testH.insert(8);
        testH.insert(16);
        testH.insert(4);
        testH.insert(10);
        testH.insert(14);
        testH.insert(2);
        testH.insert(6);
        
        if (testH.height() != 3) return false;
        if (testH.heightOf(12) != 3) return false;
        if (testH.heightOf(8) != 2) return false;
        if (testH.heightOf(4) != 1) return false;
        if (testH.heightOf(2) != 0) return false;
        if (testH.heightOf(10) != 0) return false;
        
        testH.insert(1);
        
        if (testH.height() != 3) return false;
        if (testH.heightOf(12) != 3) return false;
        if (testH.heightOf(4) != 2) return false;
        if (testH.heightOf(8) != 1) return false;
        if (testH.heightOf(2) != 1) return false;
        if (testH.heightOf(1) != 0) return false;
        if (testH.heightOf(10) != 0) return false;
    }
    
    /**
     * Tests that find method returns true when
     * the tree contains the node and false when
     * it does not.
     * 
     * @return True if find() passes test.
     */
    private boolean testFind()
    {
    }
    
    /**
     * Tests that insert method does not add duplicates.
     * 
     * @return True if duplicate is not inserted.
     */
    private boolean testInsert()
    {
    }
    
    /**
     * Unbalances a tree by deleting a node to test the 
     * remove method.
     * 
     * @return True if tree is balanced after deletion (passes test).
     */
    private boolean testRemove()
    {
    }
    
    /**
     * Tests if the string representation of the AVLTree
     * is correct.
     * 
     * @return True if format of string is correct (passes test).
     */
    private boolean testToString()
    {
    }
}
