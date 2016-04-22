/**
 * A standard AVL Tree.
 * 
 * @author Sean Reddell
 * @version 4/22/16
 */
public class AVLTree
{
    /**
     * A Node on the tree.
     * Private nested class.
     */
    private class AVLNode
    {
        //the element contained in the node
        public int element;
        
        //left and right children
        public AVLNode left = null;
        public AVLNode right = null;
        
        /**
         * Constructor for a node.
         * 
         * @param e Element to be contained.
         */
        public AVLNode(int e)
        {
            element = e;
        }
    }
    
    
}
