import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

class Tuple{
    int no;
    TreeNode node;
    public Tuple(int no,TreeNode node){
        this.no=no;
        this.node=node;
    }
}

public class Solution {

    int no = 0;
    public void dfs(TreeNode root,int curno){
        no = Math.max(no,curno);
        if(root.left!=null) dfs(root.left,curno*2);
        if(root.right!=null) dfs(root.right,curno*2+1);
    }
    public TreeNode makeCompleteTree(TreeNode root) {
        dfs(root,1);

        ArrayDeque que = new ArrayDeque<Tuple>();
        que.add(new Tuple(1,root));

        while(que.size()>0){
            Tuple tuple = (Tuple) que.poll();

            int curno = tuple.no;
            TreeNode node = tuple.node;

            if(curno*2<no){
                if(node.left==null){
                    node.left=new TreeNode(curno*2);
                }
                que.add(new Tuple(curno*2,node.left));
            }
            if((curno*2+1)<no){
                if(node.right==null){
                    node.right=new TreeNode(curno*2+1);
                }
                que.add(new Tuple(curno*2+1,node.right));
            }

        }
        System.out.println(num);
        return root;
    }


}
