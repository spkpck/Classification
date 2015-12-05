package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pojo.Features;

public class FileReaderForImageDataUtility {

	private BufferedReader br = null;
	private boolean[][] elementMatrix = null;
	private FeatureExtraction featureExtractor = new FeatureExtraction();
	private int noOfElement = 0;

	public void readFromFile(List<Integer> digitList){
		try {
			String currentLine;
			int lineNo = 0;
			br = new BufferedReader(new FileReader("C:\\Study Material\\Artificial Intelligence - 520\\Assignments\\Project\\data\\digitdata\\testfile.txt"));
	
			while ((currentLine = br.readLine()) != null) {
				if((!currentLine.contains("+")) && (!currentLine.contains("#"))){
					System.out.println(currentLine);
					if(elementMatrix != null){
						extractFeaturesFromElements(digitList);
						elementMatrix = null;
						lineNo = 0;
						noOfElement++;
					}
				}
				else{
					if(elementMatrix == null){
						elementMatrix = new boolean[29][29];
					}
					createMatrixForEachPattern(currentLine, lineNo);	
					lineNo++;
				}
			}
			featureExtractor.displayMap();
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
		//System.out.println("size "+ currentLine.length());
		//System.out.println("size of the char array: "+ currentLine);
		for(int i=0;i<currentLine.length();i++){
			if((currentLine.charAt(i) == '#') || (currentLine.charAt(i) == '+') ){
				elementMatrix[lineNo][i] = true;
			}
		}
		//displayMatrix();
	}
	
	public void displayMatrix(){
		for(int i=0;i<elementMatrix.length;i++){
			for(int j=0;j<elementMatrix[i].length;j++){
				System.out.print(elementMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void extractFeaturesFromElements(List<Integer> digitList){
		/*if(noOfElement == 5000){
			displayMatrix();
		}*/
	//displayMatrix();
		/*Map<Integer, Features> feature1Map = *///featureExtractor.calcFowardDiagonalElements(digitList.get(noOfElement), elementMatrix);	
		//featureExtractor.clearMapForNextFeature();
		/*Map<Integer, Features> feature2Map = *///featureExtractor.calcBackwardDiagonalElements(digitList.get(noOfElement), elementMatrix);	
		//displayMap(feature1Map);
		//displayMap(feature2Map);
		//noOfElement++;
		System.out.println("No of elements: "+noOfElement);
	}
}

