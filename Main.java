import java.awt.*;

class ListNode{
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val=val;
    }
}

public class Solution {
    public int merge(ListNode a) {
        if(a.next==null) return 0;
        int ans = 0;

        ListNode cur = a;
        while(cur.next!=null){
            if(cur.val == 0){
                if(cur.next.val==0) {
                    ans++;
                    cur = cur.next;
                }else{
                    cur=cur.next;
                }
            }else{
                if(cur.next.val==0){
                    cur=cur.next;
                }else {
                    ans++;
                    cur=cur.next;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        ListNode node = new ListNode(0);
        ListNode cur = node;
        cur.next = new ListNode(0);
        cur=cur.next;
        cur.next=new ListNode(0);

        Solution s = new Solution();

        System.out.println(s.merge(node));
    }

}
