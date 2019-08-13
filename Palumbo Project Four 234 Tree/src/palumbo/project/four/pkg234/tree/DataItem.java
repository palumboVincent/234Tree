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
public class DataItem 
{
    public String dData; // data item stored as a string
    public int count;    // counter to keep track of words in doc
    
    public DataItem(String term) // constructor for class
    {
        dData =  term;
        count = 1;
    }
       
    public String getItem()
    {
        return this.dData;
    }
    
    public int getCount()
    {
        return this.count;
    }
    
    public void displayItem()
    {
        if(dData.length() < 3)
        {
            System.out.print("Word: " + dData + "Counter: " + count);
        }
        else if(dData.length() < 10)
        {
            System.out.print("Word: " + dData + "Counter: " + count);
        }
        else
        {
            System.out.print("Word: " + dData + "Counter: " + count);
        }
        System.out.println();
        
    }
}
