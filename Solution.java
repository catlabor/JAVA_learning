/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val=val;}
        ListNode(int val,ListNode next){this.val=val;this.next=next;}
    }


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode currentNode;
        currentNode=head;
        for (int i = 2; i < 6; i++) {
            ListNode node=new ListNode(i);
            currentNode.next=node;
            currentNode=node;
        }
        ListNode listNode1 = reverseBetween(head, 2, 4);
        System.out.println(head);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        int len = 1;
        ListNode newListNode=new ListNode(1);
        ListNode currentNode;
        currentNode=newListNode;
        int [] tmpArray = new int[n - m + 1];
        while (head.next != null) {
            if ((len >= m)) {
                ListNode currentNodeTmp=currentNode;
                while (len <= n) {
                    currentNode=head.next;
                    tmpArray[len - m] = currentNode.val;
                    len++;
                }
                int lentmp=tmpArray.length-1;
                while(len==n+1 && lentmp>=0){
                    currentNodeTmp.val=tmpArray[lentmp];
                    currentNodeTmp=currentNodeTmp.next;
                    lentmp--;
                }
            } else {
                currentNode=head.next;
                currentNode.val = head.val;
                currentNode = currentNode.next;
                len++;
            }
        }
        return newListNode;
    }


}

