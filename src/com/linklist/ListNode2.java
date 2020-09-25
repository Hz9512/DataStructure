package com.linklist;

/**
 * 双向链表节点
 */
public class ListNode2 {
    private int no;
    private String name;
    public ListNode2 pre;
    public ListNode2 next;

    public ListNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
