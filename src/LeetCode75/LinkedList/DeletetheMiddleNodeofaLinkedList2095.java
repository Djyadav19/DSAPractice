package LeetCode75.LinkedList;

public class DeletetheMiddleNodeofaLinkedList2095 {
    /**
     * Definition for singly-linked list.
     * */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            if(head == null || head.next == null) return null;

            // let's try with first and slow .
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }
            prev.next = slow.next;
            return head;
            /*
            int size = 0;
            ListNode temp = head;
            while(temp != null){
                size++;
                temp = temp.next;
            }

            int middle = size/2;
            ListNode temp1 = head;
            boolean flag = true;
            ListNode prev = null;
            int i = 0;
            while(temp1 != null){
                //System.out.println("i: "+i+" middle:"+middle);
                if(i == middle){
                    flag = false;
                    prev.next = temp1.next;
                    return head;
                }
                i++;
                prev = temp1;
                temp1 = temp1.next;
            }
            return null;
            */
        }
    }

    public static void main(String[] args) {
        DeletetheMiddleNodeofaLinkedList2095 outer = new DeletetheMiddleNodeofaLinkedList2095();
        Solution solution = outer.new Solution();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = outer.new ListNode(1);
        head.next = outer.new ListNode(2);
        head.next.next = outer.new ListNode(3);
        head.next.next.next = outer.new ListNode(4);
        head.next.next.next.next = outer.new ListNode(5);

        // Delete middle node
        ListNode result = solution.deleteMiddle(head);

        // Print resulting list
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        // Expected output: 1 2 4 5
    }
}
