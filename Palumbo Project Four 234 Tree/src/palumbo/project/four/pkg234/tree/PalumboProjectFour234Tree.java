/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palumbo.project.four.pkg234.tree;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Vincent
 */
public class PalumboProjectFour234Tree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    { 
        Tree theTree = new Tree();
        
        // sets FileName to value of data.txt file
        String FileName = "data.txt";
        
        java.io.File file = new java.io.File(FileName);
        Scanner input = new Scanner(file); // used to scan file
        input.useDelimiter(" +"); 
        // display information before nodes
        System.out.println("Data before nodes:");
        System.out.println();
        while(input.hasNext())
        {
            System.out.println(Arrays.toString(input.next().toLowerCase().trim().split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+")));
            theTree.insert(Arrays.toString(input.next().toLowerCase().trim().replace("-", "").replace("\"", "").replace("'' ", "").replace(".", "").replace(",", "").replace("?", "").replace("] ", "").replace("!","").replace(" ", "").replace("'", "").split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+")));
        }
        
        System.out.println("Here are the nodes");
        System.out.println("****************************************");
        System.out.println("  ");
        // display tree moment of truth
        theTree.displayTree();
    }
    
}
