import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Consumer;

import javax.lang.model.element.Element;

public class Tree {

	Node root;
	
	private Map<Character, Integer> getCharFrequency(String text) {
		char[] array = text.toCharArray();
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char letter : array) {
            if (frequencyMap.get(letter) == null) {
                frequencyMap.put(letter, 1);
            } else {
                frequencyMap.put(letter, frequencyMap.get(letter) + 1);
            }
        }
        return frequencyMap;

	}
	
	private Map<Character, String> createBinaryMap(Map<Character, Integer> frequencyMap) {
        Map<Character, String> binaryMap = new HashMap<>(frequencyMap.size());
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            binaryMap.put(entry.getKey(), null);
        }
        return binaryMap;
    }

	private PriorityQueue<Node> initializeQueue(Map<Character, Integer> frequencyMap) {
		PriorityQueue<Node> roots = new PriorityQueue<Node>();
        for (Map.Entry<Character, Integer> e : frequencyMap.entrySet()) {
            Node node = new Node();
            node.setContent(e.getKey());
            node.setFrequency(e.getValue());
            node.setIsLeaf(true);
            roots.add(node);
        }
        return roots;
    }
	
	public void teste(PriorityQueue<Node> priorityRootList) {

		for (Node e : priorityRootList) {
	        System.out.print((char) e.getContent() + "=" + e.getFrequency() + " ");
		}
		
	}
	
	private Node createTree(String text, Map<Character, Integer> charFrequencyMap) {
		PriorityQueue<Node> priorityQueue = this.initializeQueue(charFrequencyMap);
	        
        for(int i = 0; i < charFrequencyMap.size() - 1; i++) {
        	Node newRoot = new Node();

        	newRoot.setLeft(priorityQueue.remove());
            newRoot.setRight(priorityQueue.remove());
            
            newRoot.setFrequency(newRoot.getLeft().getFrequency() + newRoot.getRight().getFrequency());

            newRoot.setContent(35);//código ascii do #
            
            priorityQueue.add(newRoot);

        }

        return priorityQueue.peek();
	}
	
	public String crypt(String text) {
		char[] arrayCryptedText = text.toCharArray();
		String cryptedText = "";
		Map<Character, Integer> charFrequencyMap = getCharFrequency(text);
		
		Map<Character, String> binaryMap = this.createBinaryMap(charFrequencyMap);
		
		this.root = createTree(text, charFrequencyMap);
		
		crypt(this.root, "", binaryMap);
		
		for (int i = 0; i < arrayCryptedText.length; i++) {
            cryptedText += binaryMap.get(arrayCryptedText[i]) + " ";
        }
		
		return cryptedText;
	}
	
	private void crypt(Node node, String currentBinary, Map<Character, String> binaryMap) {
        if (node.isLeaf()) {
            binaryMap.put((char) node.getContent(), currentBinary);
        } else {
            crypt(node.getLeft(), currentBinary.concat("0"), binaryMap);
            
            crypt(node.getRight(), currentBinary.concat("1"), binaryMap);
        }
    }

	
}
