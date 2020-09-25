package com.linklist;

import java.util.Stack;

/**
 * 单链表
 */
public class SingleLinkedListTestDemo {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, "张三");
        ListNode node2 = new ListNode(2, "李四");
        ListNode node3 = new ListNode(3, "王五");
        ListNode node4 = new ListNode(4, "赵柳");
        SingleLinkedList1 linkedList = new SingleLinkedList1();
        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node3);
        linkedList.addNode(node4);

//        linkedList.updateName(new ListNode(2, "zhangsna"));
        linkedList.list();
//        ListNode lastIndexNode = linkedList.findLastIndexNode(3, linkedList.getHead());
//        System.out.println("倒数第k个：" + lastIndexNode);
//        linkedList.reverseList(linkedList.getHead());
//        System.out.println("翻转链表后");
//        linkedList.list();
        System.out.println("逆向打印链表");
        linkedList.reversePrint(linkedList.getHead());


    }
}

class SingleLinkedList1 {
    private ListNode head = new ListNode(0, "");

    public ListNode getHead() {
        return head;
    }

    /**
     * 添加节点（尾部插入）
     *
     * @param node
     */
    public void addNode(ListNode node) {
        ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 插入到指定位置
     *
     * @param node
     */
    public void addByOrder(ListNode node) {
        ListNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                flag = true;
            } else if (temp.next.no == node.no) {
                flag = false;
                break;
            } else {
                temp = temp.next;
            }

            if (flag) {
                node.next = temp.next;
                temp.next = node;
            } else {
                System.out.println("已存在，不可插入");
            }
        }
    }

    /**
     * 根据编号修改name
     *
     * @param node
     */
    public void updateName(ListNode node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }
        if (flag) {
            temp.next.name = node.name;
        } else {
            System.out.println("没找到");
        }
    }

    /**
     * 根据编号删除节点
     *
     * @param no
     */
    public void deleteNode(int no) {
        ListNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("需要删除的节点不存在");
        }
    }

    /**
     * 遍历链表
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("遍历结束");
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 遍历链表有效节点的个数
     *
     * @param head
     * @return
     */
    public int getLength(ListNode head) {
        if (head.next == null) {
            System.out.println("空链表");
            return 0;
        }
        int length = 0;
        ListNode curNode = head.next;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        return length;
    }

    /**
     * 思路
     * 1.接收head节点，同时接收一个index(表示到数第index个)
     * 2.先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 3.得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
     * 4.如果找到了，则返回该节点，否则返回nulll
     *
     * @param index
     * @param head
     * @return
     */
    public ListNode findLastIndexNode(int index, ListNode head) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if (index < 0 || index > length) {
            return null;
        }
        ListNode cur = head.next;
        for (int i = 0; i < length - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 单链表翻转（这种情况会破坏链表结构）
     * 思路：
     * 1.定义一个新的链表
     * 2.将当前节点后面的节点放在中间指针上
     * 3.将新链表所有节点补在当前节点后面
     * 4.再将当前节点放在新链表上面
     * 5.将当前节点指向中间节点就相当于后移当前节点了
     *
     * @param head
     */
    public void reverseList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            System.out.println("空链表或者只有一个节点，不必翻转");
            return;
        }
        ListNode reverseHead = new ListNode(0, "");//新链表头结点
        ListNode next = null;//中间指针，用来做交换用的
        ListNode cur = head.next;//当前节点，从第一个开始
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 逆向打印链表
     * 思路
     * 借助栈
     *
     * @param head
     */
    public void reversePrint(ListNode head) {
        if (head.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}
