import java.util.*;

public class Heap<Type extends Comparable> { 
	private int size = 0, capacity = 5;
	private Type[] theData = (Type[])new Comparable[capacity];

	private void reallocate() {
		capacity = 2*capacity;
		theData = Arrays.copyOf(theData,capacity);
	} 

	public String toString() {
		String returnString = "[";
		for (int i=0;i<size;i++) {
			returnString += String.format("%d-%s",i,theData[i]);
			if (i<size-1) {returnString+=",";}
		}
		return returnString+"]";
	}

	private void heapUp(int n) {
		if (n==0) {return;}
		int parent = (n-1)/2;
		if (theData[n].compareTo(theData[parent])<0) {
			Type tmp = theData[n];
			theData[n] = theData[parent];
			theData[parent] = tmp;
			heapUp(parent);
		}
	}

	private void heapDown(int n) {
		int child = 2*n+1; //Default, Left
		if (child>=size) {return;}
		if (theData[n].compareTo(theData[child])>0||theData[n].compareTo(theData[child+1])>0) {
			if (theData[child].compareTo(theData[child+1])>0) {child++;} 
			Type tmp = theData[n];
			theData[n] = theData[child];
			theData[child] = tmp;
			heapDown(child);
		}
	}

	public void enqueue(Type e) {
		if (size==capacity) {reallocate();}
		int pos = size;
		theData[pos] = e;
		size++;
		heapUp(pos);
	}

	public Type dequeue() {
		if (isEmpty()) {return null;}
		Type min = theData[0];
		theData[0] = theData[size-1];
		size--;
		heapDown(0);
		return min;	
	}

	public boolean isEmpty() {return size==0;}

	public int size() {return size;}
}

