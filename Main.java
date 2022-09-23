import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Tree huffmanTree = new Tree();
		
		Scanner io = new Scanner(System.in);
        System.out.println("Digite um texto:");
        String text = io.nextLine();
        
        System.out.println(huffmanTree.crypt(text));
        
        
	}

}
