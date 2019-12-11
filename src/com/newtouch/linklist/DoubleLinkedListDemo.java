package com.newtouch.linklist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		DoubleLinkedList doubleList = new DoubleLinkedList();
		HeroNode2 node1 = new HeroNode2(1, "ղķ˹", "С�ʵ�");
		HeroNode2 node2 = new HeroNode2(2, "����", "�ڹ�");
		HeroNode2 node3 = new HeroNode2(3, "����", "����");
		HeroNode2 node4 = new HeroNode2(4, "����", "����");
		doubleList.add2(node1);
		doubleList.add2(node3);
		doubleList.add2(node4);
		doubleList.add2(node2);
		
		doubleList.list();
		System.out.println("--------------------------");
		//�޸�
		HeroNode2 newHeroNode=new HeroNode2(2, "����", "����");
		doubleList.update(newHeroNode);
		doubleList.list();
		
		
	}
}

class DoubleLinkedList {
	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead() {
		return head;
	}

	// ����
	public void list() {
		if (head.next == null) {
			System.out.println("�����ǿյ�");
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

	// ���
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

	// �������
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
			System.out.printf("�Ѵ���%d\n", heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
			heroNode.pro = temp;
		}
	}

	// �޸�
	public void update(HeroNode2 newHeroNode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		boolean flag = false;
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;// ��ʾ����������
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;// �ҵ�
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("û���ҵ�%d�Ľڵ�\n", newHeroNode.no);
			System.out.printf("û���ҵ�%d�Ľڵ�\n", newHeroNode.no);
		}
	}

	// ɾ��
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
			System.out.printf("û�ҵ�%d\n", no);
			System.out.printf("û�ҵ�%d\n", no);
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
