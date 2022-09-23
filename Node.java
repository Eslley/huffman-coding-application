
public class Node implements Comparable<Node> {
	
	private Integer frequency;
	private Node left;
	private Node right;
	private int content;
	private boolean isLeaf;
	
	public boolean isLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
	
	public int getContent() {
		return content;
	}
	
	public void setContent(int content) {
		this.content = content;
	}
	
	public Integer getFrequency() {
		return frequency;
	}
	
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public int compareTo(Node n2) {
		 return this.getFrequency().compareTo(n2.getFrequency());
	}
	
	

}
