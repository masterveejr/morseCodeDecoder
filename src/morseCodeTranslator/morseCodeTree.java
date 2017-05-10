package morseCodeTranslator;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class morseCodeTree implements morseCodeInterface {

	protected binaryTreeNode root;
	protected binaryTreeNode current;
	int size;
	protected final static String dot = ".";
	protected final static String dash = "-";
	boolean found;

	public morseCodeTree() throws FileNotFoundException{
		root = new binaryTreeNode(null);
		File file = new File("morseCode.txt");
		Scanner kb = new Scanner(file);
		String letter = null;
		String morseCode = null;
		String[] array;

		while(kb.hasNextLine()){ //this scans through and adds morsecode to tree
			array = kb.nextLine().split(" ");
			letter = array[0];
			morseCode = array[1];
			add(array[0],array[1]);
		}

	}
	public void add(Object letter, Object code){//adds the letters and corresponding morse to tree
		String element = (String)letter;
		String tree = (String)code;
		String sign = "";
		binaryTreeNode runner = getRoot();
		binaryTreeNode temp = new binaryTreeNode(null);
		for (int b = 0;b < tree.length(); b++){
			sign = tree.substring(b,b+1);
			if (sign.equals(dot)) {
				if (runner.hasLeft()) {
					runner = runner.getLeft();
				} else {
					runner.setLeft(new binaryTreeNode(runner));
					size += 1;
					temp = runner;
					runner = runner.getLeft();
					runner.setParent(temp);
				}
			} else {
				if (runner.hasRight()) {
					runner = runner.getRight();
				} else {
					runner.setRight(new binaryTreeNode(runner));
					size += 1;
					temp = runner;
					runner = runner.getRight();
					runner.setParent(temp);
				}

			}
		}
		runner.setInfo(element);
	}
	public String solver (String input) throws RuntimeException{//decodes the morse code inputted
		String line = input;
		String sign = "";
		binaryTreeNode runner = getRoot();
		for (int b = 0; b < line.length();b++){
			sign = line.substring(b, b+1);
			if (sign.equals(dot)){
				if(runner.hasLeft()){
					runner = runner.getLeft();
				} else {
					throw new RuntimeException("unkonow entry");
				}
			} else if (sign.equals(dash)) {
				if (runner.hasRight()) {
					runner = runner.getRight();
				} else {
					throw new RuntimeException("unknown entry ");
				}
			}
		} 
		return (String) runner.getInfo();
	}
	private binaryTreeNode getRoot() {//gets the root or base of the tree
		return root;
	}

	public static void main (String[] args) throws FileNotFoundException {
		morseCodeTree decoder = new morseCodeTree();
		Scanner keyboard = new Scanner(System.in);
		String[] input;
		// prints out MorseTree location
		System.out.println("MorseTree location of file : " + decoder);

		//solve inputed morse code
		String userInput = null;
		System.out.println("would you like to translate morse code? (Y/N)");
		userInput = keyboard.nextLine();
		while(userInput.equalsIgnoreCase("y")){
				String code = null;
				System.out.println("enter the code: (finish with (space)#) ");
				code = keyboard.nextLine();
				input = code.split(" ");
				for(int b = 0; b<input.length;b++){
					if(input[b].equals("#")){
						System.out.println("");
						break;//exits when # is input
						
					}
					else if(input[b]==null)
						System.out.print(" ");
				else
					System.out.print(decoder.solver(input[b]));
			}
				System.out.println("continue? ");
				userInput = keyboard.nextLine();
				
		}
		System.out.println("thankyou for using");


	}
}
