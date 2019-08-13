/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palumbo.project.four.pkg234.tree;

/**
 *
 * @author Vincent
 */
public class Tree 
{
    private Node root = new Node(); // creates the root node
    public int find(String key)
    {
        Node curNode = root;
        int childNumber;
        while (true)
        {
            if((childNumber = curNode.findItem(key)) != -1)
            {
                return childNumber; // finds it
            }
            else if(curNode.isLeaf())
            {
                return -1; // cant find it
            }
            else
            {
                curNode = getNextChild(curNode, key);
            }
        }
    }
    
    public void insert(String dValue)
    {
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);
        
        while(true)
        {
            // if node is full, split it
            if(curNode.isFull())
            {
                split(curNode);
                curNode = curNode.getParent(); // backs up
                curNode = getNextChild(curNode, dValue); // searches once
            }
            else if(curNode.isLeaf())
            {
                // if node is leaf, go to insert
                break;
            }
            // node isnt full, or a leaf, so goes to lower level
            else
            {
                curNode = getNextChild(curNode, dValue);
            }
        }
        curNode.insertItem(tempItem); // inserts new item
    }
    
    private void split(Node thisNode) // split the node
    {
        // assume node is full
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;
        
        // remove items from the nodes
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        
        // remove children from the nodes
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        
        Node newRight = new Node(); // creates new node, places it to the right
        
        // if node is the root, creates new root and connects parent
        if(thisNode == root)
        {
            root = new Node();
            parent = root; // setting new root
            root.connectChild(0, thisNode); // connects parent
        }
        else
        {
            parent = thisNode.getParent(); // gets the parent
        }
        
        itemIndex = parent.insertItem(itemB); // itemb to parent
        int n = parent.getNumItems();
        
        // moves parents connects to right
        for(int j = n - 1; j > itemIndex; j--)
        {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }
        
        parent.connectChild(itemIndex + 1, newRight);
        
        // deal with new right
        newRight.insertItem(itemC); // insert itemC to new right
        newRight.connectChild(0, child2); // connect to 0 and 1
        newRight.connectChild(1, child3); // on new right
    }
    
    // gets appropriate child of node during search for value
    private Node getNextChild(Node theNode, String theValue)
    {
        int j;
        int numItems = theNode.getNumItems();
        
        // check each item inside node
        for(j = 0; j < numItems; j++)
        {
            // checks if each item is less, if so, return left child
            if(theValue.compareToIgnoreCase(theNode.getItem(j).dData) < 0)
            {
                return theNode.getChild(j);
            }
        }
        return theNode.getChild(j); // returns right child
    }
    
    public void displayTree()
    {
        recDisplayTree(root, 0, 0);  // displays tree
    }
    
    private void recDisplayTree(Node thisNode, int level, int childNumber)
    {
        System.out.print("Level= " + level + " child= " + childNumber + " ");
        thisNode.displayNode(); // display the node
        
        // recursively call for each child of this node
        int numItems = thisNode.getNumItems();
        for(int j = 0; j < numItems + 1; j++)
        {
            Node nextNode = thisNode.getChild(j);
            // checking if null
            if(nextNode != null)
            {
                // if not null, keep calling itself until it is
                recDisplayTree(nextNode, level + 1, j);                
            }
            else
            {
                return;
            }
        }
    }   
}
