import java.util.ArrayList;

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val=val;
    }
}

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

        ArrayList que = new ArrayList<Tuple>();
        que.add(new Tuple(1,root));


        while(que.size()>0){
            Tuple tuple = (Tuple) que.get(0);
            que.remove(0);

            int curno = tuple.no;
            TreeNode node = tuple.node;

            if(curno*2<no){
                if(node.left==null) node.left=new TreeNode(1);
                que.add(new Tuple(curno*2,node.left));
            }
            if((curno*2+1)<no){
                if(node.right==null) node.right=new TreeNode(1);
                que.add(new Tuple(curno*2+1,node.left));
            }

        }

        return root;
    }

}
