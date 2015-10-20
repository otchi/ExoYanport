package fr.yanport.test.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author amine
 *	chargement des données d'un fichier comme suggéré dans l'exercice
 */
public class SimpleFileInstructionLoader implements InstructionLoader {
	private String shapeDefinition;
	private String initPosition;
	private String instructions;
	
	 public SimpleFileInstructionLoader(File f) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(f));
		shapeDefinition=br.readLine();
		initPosition=br.readLine();
		instructions =br.readLine();
		br.close();
	}
	
	@Override
	public String getShapeDefinition() {
		// TODO Auto-generated method stub
		return shapeDefinition;
	}

	@Override
	public String getInitPosition() {
		// TODO Auto-generated method stub
		return initPosition;
	}

	@Override
	public String getInstructions() {
		// TODO Auto-generated method stub
		return instructions;
	}

}
