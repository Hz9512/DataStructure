package com.newtouch.linklist;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode h1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode h2 = new HeroNode(2, "¬����", "������");
		HeroNode h3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode h4 = new HeroNode(4, "�ֳ�", "����ͷ");

		HeroNode h5 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode h6 = new HeroNode(2, "¬����", "������");
		HeroNode h7 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode h8 = new HeroNode(4, "�ֳ�", "����ͷ");

		SingleLinkedList list = new SingleLinkedList();
		SingleLinkedList list2 = new SingleLinkedList();
//		list.add(h1);
//		list.add(h2);
//		list.add(h3);
//		list.add(h4);

		list.add2(h1);
		list.add2(h3);
		list.add2(h4);
		list.add2(h2);

		list2.add2(h5);
		list2.add2(h6);
		list2.add2(h7);
		list2.add2(h8);

		System.out.println("-------------------------------------------------");
		list.list();
		list2.list();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		SingleLinkedList hebing = SingleLinkedList.hebing(list.getHead(), list2.getHead());
		hebing.list();
		

		System.out.println("-------------------------------------------------");
		System.out.println("����update");
		HeroNode newHeroNode = new HeroNode(2, "¬����", "������");
		list.update(newHeroNode);
		list.list();

		System.out.println("����delete");
//		list.delete(4);
//		list.delete(3);
		list.delete(2);
		list.list();

		System.out.println("��ǰ������Ч����Ϊ��" + SingleLinkedList.length(list.getHead()));

		// ������K���ڵ�
		HeroNode heroNode = SingleLinkedList.findLastIndexNode(list.getHead(), 2);
		System.out.println("������K���ڵ�Ϊ��" + heroNode);

		System.out.println("��ת�������Ϊ��");
		SingleLinkedList.reverse(list.getHead());
		list.list();

	}

}

class SingleLinkedList {
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	// ���
	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	// �Ľ������
	public void add2(HeroNode heroNode) {
		HeroNode temp = head;
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
		}
	}

	// �ϲ���������ĵ�������Ϊһ������ĵ�����
	public static SingleLinkedList hebing(HeroNode head1, HeroNode head2) {
		SingleLinkedList single = new SingleLinkedList();
		HeroNode temp1 = head1.next;
		HeroNode temp2 = head2.next;
		HeroNode head3 = single.head;

		if (head1.next == null) {
			head3.next = head2.next;
		} else if (head2.next == null) {
			head3.next = head1.next;
		}

		while (temp1 != null || temp2 != null) {
			if (temp1 == null && temp2 != null) {
				head3.next = temp2;
				temp2 = temp2.next;
			} else if (temp2 == null && temp1 != null) {
				head3.next = temp1;
				temp1 = temp1.next;
			} else {
				if (temp1.no <= temp2.no) {
					head3.next = temp1;
					temp1 = temp1.next;
				} else {
					head3.next = temp2;
					temp2 = temp2.next;
				}
			}
			head3 = head3.next;
		}
		return single;
	}

	// ����
	public void list() {
		if (head.next == null) {
			System.out.println("�����ǿյ�");
			return;
		}

		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}

	}

	// �޸�
	public void update(HeroNode newHeroNode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		boolean flag = false;
		HeroNode temp = head.next;
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
		}
	}

	// ɾ��
	public void delete(int no) {
		HeroNode temp = head;
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
			System.out.printf("û�ҵ�%d\n", no);
		}
	}

	// ��ȡ������Ч����
	public static int length(HeroNode head) {
		if (head.next == null) {// ������
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;
		while (cur != null) {
			length++;
			cur = cur.next;// ����
		}
		return length;
	}

	// ���ҵ�����k���ڵ�
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if (head.next == null) {
			return null;
		}
		int size = length(head);
		if (index <= 0 || index > size) {
			return null;
		}
		HeroNode cur = head.next;
		for (int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}

	// ����ת
	public static void reverse(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			return;
		}

		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		while (cur != null) {
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}