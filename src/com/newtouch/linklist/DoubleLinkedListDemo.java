package com.newtouch.linklist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		DoubleLinkedList doubleList = new DoubleLinkedList();
		HeroNode2 node1 = new HeroNode2(1, "詹姆斯", "小皇帝");
		HeroNode2 node2 = new HeroNode2(2, "威少", "乌龟");
		HeroNode2 node3 = new HeroNode2(3, "库里", "三分");
		HeroNode2 node4 = new HeroNode2(4, "乔治", "雷霆");
		doubleList.add2(node1);
		doubleList.add2(node3);
		doubleList.add2(node4);
		doubleList.add2(node2);
		
		doubleList.list();
		System.out.println("--------------------------");
		//修改
		HeroNode2 newHeroNode=new HeroNode2(2, "威少", "龟少");
		doubleList.update(newHeroNode);
		doubleList.list();
		
		
	}
}

class DoubleLinkedList {
	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead() {
		return head;
	}

	// 遍历
	public void list() {
		if (head.next == null) {
			System.out.println("链表是空的");
			return;
		}

		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}

	}

	// 添加
	public void add(HeroNode2 heroNode) {
		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.pro = temp;
	}

	// 有序添加
	public void add2(HeroNode2 heroNode) {
		HeroNode2 temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			} else if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.printf("已存在%d\n", heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
			heroNode.pro = temp;
		}
	}

	// 修改
	public void update(HeroNode2 newHeroNode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		boolean flag = false;
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;// 表示遍历完链表
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;// 找到
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("没有找到%d的节点\n", newHeroNode.no);
			System.out.printf("没有找到%d的节点\n", newHeroNode.no);
		}
	}

	// 删除
	public void delete(int no) {
		HeroNode2 temp = head;
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
			temp.pro.next = temp.next;
			if (temp.next != null) {
				temp.next.pro = temp.pro;
			}
		} else {
			System.out.printf("没找到%d\n", no);
			System.out.printf("没找到%d\n", no);
		}
	}
}

class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pro;

	public HeroNode2(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}
