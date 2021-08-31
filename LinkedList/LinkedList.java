import java.io.*;

public class LinkedList {
	
	private Node head; //The first element in a linked list
	private int size;	//Stores the size of the linked List
	//Class that makes nodes for the linkedList
	private class Node{
		public int data;	//Data stored in the node
		public Node next;	//Will point to the next node which is currently going to be null
		
	}
	public LinkedList() {
		head = null;		//Creates an empty linked list
	}
	
	//add a node at the head
	public void addStart(int data) {
		Node old = head;	//old head
		Node newNode = new Node();	//new Node to be added
		newNode.data = data;	//Gives data to new node
		head = newNode;	//head now points to the new node
		newNode.next = old;		//newNode now points to old head which points to rest of the linked list elements
		size++;
		
	}
	
	//add at the end/tail of linked list 
	public void addEnd(int data) {
		Node newNode = new Node();		//Creates a new node
		newNode.data = data;			//adds data to new node
		if(head == null) {				//There is no elements in the list just add it at the start
			head = newNode;
		}else {
			Node curr = new Node();
			curr = head;		//Keeps track of current node
			//Keep going until we he the last node of the linked list
			while(curr.next != null) {		
				curr = curr.next;
			}
			curr.next = newNode;		//make the pointer point to the new node
			size++;  	//Update the size
		}
	}
	//Add at position
	public void IndexAdd(int data, int index) {
		if(index > size) {
			return;
		}
		if(index == 0) {
			addStart(data);	//If the index is 0 add it at the start 
		}
		else {
			size++;	//Update size since we are adding a new node
			Node newNode = new Node();
			newNode.data = data;
			Node curr = new Node();
			curr = head;
			//Iterate until we are exactly one before the specified index
			for(int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			Node temp = curr.next; //Now the current element at the index is stored
			curr.next = newNode;	//Now new node is added to the index
			newNode.next = temp;	//Make new node point to old node @ index
			
		}
		
	}
	//Remove at position
	public void deleteAtIndex(int index) {
		size--;	//Update the size
		Node curr = head;
		for(int i = 0; i > index - 1; i ++) {	//1 2 3 4 5    in = 2  
			curr = curr.next;		//we are at 2
		}
		//The node right before the index will now point at one after the index
		curr.next = curr.next.next;		//node @index2 will point to index3 so now you will have 1 2 4 5
	}
	
	public int getData(int index) {
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		return curr.data;
	}
	
	public void pList() {
		System.out.println("Printing LinkedList");
		while(head!=null) {
			System.out.print(head.data + " ");
			head=head.next;
		}
	}
	public void reverse() {
		//a b c d --> d c b a
		//a== head
		//a--> d 
	}
	
	
}
