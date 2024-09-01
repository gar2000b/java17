package com.onlineinteract.leetcode.middle_linked_list;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode middleNode = head;
        ListNode endNode = head;

        while(endNode != null && endNode.next != null) {
            middleNode = middleNode.next;
            endNode = endNode.next.next;
        }

        return middleNode;
    }

    public static void main(String[] args) {
        ListNode ll = new ListNode();
        ListNode nextNode = ll;

        for(int i = 1; i <= 6; i++) {
            nextNode.val = i;

            if(i == 5)
                continue;

            nextNode.next = new ListNode();
            nextNode = nextNode.next;
        }

        nextNode = ll;

        do{
            System.out.println(nextNode.val);
            nextNode = nextNode.next;
        } while (nextNode != null);

        System.out.println();

        ListNode middleNode = new Solution().middleNode(ll);
        System.out.println(middleNode.val);
    }
}
