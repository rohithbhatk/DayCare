package edu.neu.csye6200;

public class MyLinkedList {
	int size;
	ListNode head;
	ListNode tail;
	
	public MyLinkedList() {
		size = 0;
		head = new ListNode(0);
		tail = new ListNode(0);
		head.next = tail;
		tail.prev = head; 
	}
	
	public int get(int index) {
		if (index < 0|| index >=size) {
			return -1;
		}
		ListNode pred = head;
		//ListNode succ = head.next;
		
		if (index+1<size-index) {
		for ( int i=0;i<index + 1; ++i) {
			pred = pred.next;
		}}
		else {
			pred = tail;
			for(int i=0;i<size-index;i++) {
				pred = pred.prev;
			}
		}
		return pred.val;
	}
	public void addAtHead(int val) {
		ListNode pred = head;
		ListNode succ = head.next;
		ListNode addNode = new ListNode(val);
		++size;
		addNode.prev = pred;
		addNode.next = succ;
		pred.next = addNode;
		succ.prev = addNode;
		
	}
	public void addAtTail(int val) {
		ListNode pred = tail.prev;
		ListNode succ = tail;
		ListNode addNode = new ListNode(val);
		++size;
		addNode.next = succ;
		addNode.prev = pred;
		pred.next = addNode;
		succ.prev = addNode;
	}
	public void addAtIndex(int index, int val) {
		if(index>size) {
			return;
		}
		if (index < 0) {
			index = 0;
			return;
		}
		++size;
		ListNode pred = head;
		ListNode succ = head.next;
		if (index+1<size-index) {
		for(int i=0;i<index;i++) {
			pred = pred.next;
		}
		ListNode toAdd = new ListNode(val);
		toAdd.next = succ;
		toAdd.prev = pred;
		pred.next = toAdd;
		succ.prev = toAdd;
		}
		else {
			for(int i=0;i<size-index;i++) {
				pred = pred.prev;
			}
			ListNode toAdd = new ListNode(val);
			toAdd.next = succ;
			toAdd.prev = pred;
			pred.next = toAdd;
			succ.prev = toAdd;
		}
	}
	public void deleteAtIndex(int index) {
		if (index>size) {
			return;
		}
		if (index<0) {
			return;
		}
		--size;
		ListNode pred = head;
		for(int i=0;i<index;i++) {
			pred=pred.next;
		}
		pred.next = pred.next.next;
		
	}
}

 