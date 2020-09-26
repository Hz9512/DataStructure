package com.linklist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.addBoy(41);
        linkedList.listBoy();
        linkedList.countPerson(1,3,41);
    }
}

class CircleSingleLinkedList {
    private Person first = null;//第一个男孩指针

    /**
     * 添加节点
     *
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("非法值");
            return;
        }
        Person cur = null;//当前男孩指针
        for (int i = 1; i <= nums; i++) {
            Person boy = new Person(i);
            if (i == 1) {//如果是第一个男孩，让自己与自己构成一个环
                first = boy;
                cur = boy;
                first.setNext(boy);
            } else {//否则的话，将后来的节点指向头结点，再将当前节点的下一个指向来的节点
                boy.setNext(first);
                cur.setNext(boy);
                cur = boy;//当前节点后移
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void listBoy() {
        if (first == null) {
            System.out.println("链表为空");
        }
        Person cur = first;//遍历链表需要辅助指针
        while (true) {
            System.out.println("当前节点是：" + cur.getNo());
            if (cur.getNext() == first) {
                System.out.println("遍历结束");
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     * @param startNo  从第几个节点开始数
     * @param countNum 每次数几下
     * @param nums     链表节点总数
     */
    public void countPerson(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("值不合法");
        }
        Person helper = first;//辅助指针，放在当前节点的后面，用于删除节点
        while (true) {//保证helper指针在最后面
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //先让first和helper两个指针就位到开始遍历的节点上
        for (int i = 1; i < startNo; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {//删除到最后了只剩一个了就跳出循环
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {//比如说数三个数，就是移动2次，因为自己本身还要数一个数
                first = first.getNext();
                helper = helper.getNext();
            }
            //跳出循环的就表述数到了，当前这个节点就要删除掉
            System.out.println("删除该节点为：" + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后的幸存节点为："+first.getNo());

    }


}

class Person {
    private int no;
    private Person next;

    public Person(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }
}
