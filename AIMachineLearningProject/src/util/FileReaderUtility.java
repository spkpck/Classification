package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUtility {

	private BufferedReader br = null;
	private boolean[][] elementMatrix = null;

	public void readFromFile(){
		try {
			String currentLine;
			int lineNo = 0;
			br = new BufferedReader(new FileReader("C:\\Study Material\\Artificial Intelligence - 520\\Assignments\\Project\\data\\digitdata\\trainingimages"));
	
			while ((currentLine = br.readLine()) != null) {
				if((!currentLine.contains("*")) && (!currentLine.contains("#"))){
					if(elementMatrix != null){
						elementMatrix = null;
						lineNo = 0;
					}
				}
				else{
					if(elementMatrix == null){
						elementMatrix = new boolean[30][30];
					}
					createMatrixForEachPattern(currentLine, lineNo);	
					lineNo++;
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void createMatrixForEachPattern(String currentLine, int lineNo){
		//char[] charArrayOfLines = currentLine.toCharArray();
		System.out.println("size of the char array: "+ currentLine);
		for(int i=0;i<currentLine.length();i++){
			if((currentLine.charAt(i) != '#') || (currentLine.charAt(i) != '*') ){
				elementMatrix[lineNo][i] = true;
			}
		}
		displayMatrix();
	}
	
	public void displayMatrix(){
		for(int i=0;i<elementMatrix.length;i++){
			for(int j=0;j<elementMatrix[i].length;j++){
				System.out.print(elementMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}

