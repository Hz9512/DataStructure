package com.tree;

public class TowTreeDemo {
    public static void main(String[] args) {
        TwoTree tree=new TwoTree();
        ListNode root=new ListNode("张三",1);
        ListNode node2=new ListNode("李四",2);
        ListNode node3=new ListNode("王五",3);
        ListNode node4=new ListNode("周六",4);
        ListNode node5=new ListNode("刘七",5);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        tree.setRoot(root);
        tree.preOrder();
    }

}

class TwoTree {
    private ListNode root;

    public void setRoot(ListNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 中序遍历
     */
    public void minOrder() {
        if (this.root != null) {
            this.root.minOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 后续遍历
     */
    public void reOrder() {
        if (this.root != null) {
            this.root.reOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

}

class ListNode {
    private ListNode left;
    private ListNode right;
    private String name;
    private int no;

    public ListNode(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public ListNode getLeft() {
        return left;
    }

    public void setLeft(ListNode left) {
        this.left = left;
    }

    public ListNode getRight() {
        return right;
    }

    public void setRight(ListNode right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void minOrder() {
        if (this.left != null) {
            this.left.minOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.minOrder();
        }
    }

    /**
     * 后续遍历
     */
    public void reOrder() {
        if (this.left != null) {
            this.left.reOrder();
        }
        if (this.right != null) {
            this.right.reOrder();
        }
        System.out.println(this);
    }

}

