package morseCodeTranslator;

public interface morseCodeInterface {
	void add (Object letter, Object morse);
	//adds the letter to the object at the morse code in a tree
	
	String solver(String input);
	// this is the solver that transverses the tree and looks at the inputed
	// morse code line and in turn returns it
	
	
}
