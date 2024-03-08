package Tree;
import java.util.*;

import structures.TreeNode;

class Reversal_Of_Tree
{
    public ArrayList<Integer> reverseLevelOrder(TreeNode node)
    {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        
        q.offer(node);

        TreeNode temp;
        while(!q.isEmpty()){
            temp = q.poll();
            s.push(temp.data);
            
            if(temp.right != null) q.offer(temp.right);
            if(temp.left != null) q.offer(temp.left);
        }
        
        while(!s.isEmpty()){
            res.add(s.pop());
        }
        
        return res;
    }
}
