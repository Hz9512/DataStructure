package com.linklist;

/**
 * 单向链表节点
 */
public class ListNode {
    public int no;
    public String name;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
