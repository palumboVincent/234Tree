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
public class Node // creates the node class
{
    private static final int SIZE = 4;
    private int numItems;
    private Node parent;
    private final Node kids[] = new Node[SIZE];
    private final DataItem item[] = new DataItem[SIZE - 1];
    
    // used to connect child to node
    public void connectChild(int childNum, Node child)
    {
        kids[childNum] = child;
        if(child != null)
        {
            child.parent = this;
        }        
    }
    
    //used to disconnect child from node and return it
    public Node disconnectChild(int childNum)
    {
        Node tempNode = kids[childNum];
        kids[childNum] = null; // setting kids to null to "disconnect"
        return tempNode;
    }
    
    // used to "gather" kids
    public Node getChild(int childNum)
    {
        return kids[childNum];
    }
    
    // used to return parents
    public Node getParent()
    {
        return parent;
    }
    
    // checks if there is a kid leaf
    public boolean isLeaf()
    {
        return kids[0] == null;
    }
    
    // used to return the number of items
    public int getNumItems()
    {
        return numItems;
    }
    
    // returns the actual item
    public DataItem getItem(int index)
    {
        return item[index];
    }
    
    // when of if it is full, return number of items
    public boolean isFull()
    {
        return numItems == SIZE - 1;
    }
    
    // find item
    public int findItem(String temp)
    {
        for(int j = 0; j < SIZE; j++)
        {
            if(item[j] == null)
            {
                break;
            }
            else if(item[j].dData.equalsIgnoreCase(temp))
            {
                return j;
            }
        }
        return -1;
    }
    
    public int insertItem(DataItem newItem)
    {
        if(findItem(newItem.dData) != -1) // if the node is not full
        {            
            item[findItem(newItem.dData)].count++;
            return 0;
        }
        numItems++; // assumes node is not full and adds new item
        String newKey = newItem.dData; // key of new item
        
        for(int j = numItems -1; j >= 0; j--)
        {
            // examines items to check if null
            if(item[j] != null) // if not null print out data
            {
                System.out.println(item[j].dData);
            }
            // examines if null
            if(item[j] == null)
            {
                continue; //pass over item and keep going
            }
            else
            {
                String itsKey = item[j].dData; // declaring itsKey
                if(newKey.compareTo(itsKey) < 0)
                {
                    item[j + 1] = item[j];
                }
                else
                {
                    item[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        item[0] = newItem; // inserts new item
        return 0;
    }
    
    // function will remove the item
    public DataItem removeItem()
    {
        // will assume node isnt empty
        DataItem temp = item[numItems - 1]; // saves item
        item[numItems - 1] = null; // disconnects the item
        numItems--; //de-increment item
        return temp; // returns the item
    }
    
    // function will display the node
    public void displayNode()
    {
        for(int j = 0; j < numItems; j++)
        {
            item[j].displayItem();
        }
        System.out.println("*************************");
    }
    
    

    
}
