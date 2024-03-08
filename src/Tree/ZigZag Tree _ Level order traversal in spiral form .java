package Tree;
import structures.TreeNode;

import java.util.*;

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.
    
    // ZigZag Tree Traversal
    ArrayList<Integer> findSpiral(TreeNode root)
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        TreeNode temp;
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            
            while(!s1.isEmpty()){
                temp = s1.pop();
                if(temp != null){
                    res.add(temp.data);
                    if(temp.right != null) s2.add(temp.right);
                    if(temp.left != null) s2.add(temp.left);
                }
                
            }
            
            while(!s2.isEmpty()){
                temp = s2.pop();
                if(temp != null){
                    res.add(temp.data);
                    if(temp.left != null) s1.add(temp.left);
                    if(temp.right != null) s1.add(temp.right);
                }
            }
            
        }
        
        return res;
    }
}