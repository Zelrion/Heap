import java.io.*;
import java.util.*;

public class Driver {
	public static void main(String[]args) {
		Heap intHeap = new Heap<Integer>(), strHeap = new Heap<String>();
		for (Integer val:(ArrayList<Integer>)readFile(new File("Integers.txt"),true)) {intHeap.enqueue(val);}
		for (String val:(ArrayList<String>)readFile(new File("Strings.txt"),false)) {strHeap.enqueue(val);}
		for (System.out.println("\nInteger Tree: "+intHeap);!intHeap.isEmpty();System.out.println("Dequeued: "+intHeap.dequeue()+"\nInteger Tree: "+intHeap));
		for (System.out.println("\nString Tree: "+strHeap);!strHeap.isEmpty();System.out.println("Dequeued: \""+strHeap.dequeue()+"\"\nString Tree: "+strHeap));
	}

	private static ArrayList readFile(File f,boolean intType) {
		try {
			FileReader fileReader = new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			ArrayList returnList = new ArrayList();
			String line;
			while ((line = bufferedReader.readLine())!=null) {if (intType) {returnList.add(Integer.parseInt(line));} else {returnList.add(line);}}
			fileReader.close();
			return returnList;
		} catch (IOException e) {return null;}
	}
}

