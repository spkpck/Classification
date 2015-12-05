package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import constants.FeatureType;
import pojo.Features;

public class FeatureExtraction {
	private Map<Integer,Map<Integer, List<Integer>>> featureTypeMapping;
	private int countOfPixels = 0;
	private List<Integer> valuesList;
	Map<Integer, List<Integer>> digitValuesForFeature2Mapping;
	Map<Integer, List<Integer>> digitValuesForFeature3Mapping;
	
	public FeatureExtraction(){
		featureTypeMapping = new HashMap<Integer, Map<Integer, List<Integer>>>();
		digitValuesForFeature2Mapping = new HashMap<Integer, List<Integer>>();
		digitValuesForFeature3Mapping = new HashMap<Integer, List<Integer>>();
		featureTypeMapping.put(FeatureType.NO_OF_PIXELS_IN_FORWARD_DIAGONAL, digitValuesForFeature2Mapping);
		featureTypeMapping.put(FeatureType.NO_OF_PIXELS_IN_BACKWARD_DIAGONAL, digitValuesForFeature3Mapping);
	}
	
	public void calcFowardDiagonalElements(int digit, boolean[][] imageData){
		digitValuesForFeature2Mapping = featureTypeMapping.get(FeatureType.NO_OF_PIXELS_IN_FORWARD_DIAGONAL);
		for(int i=0;i<imageData.length;i++){
			for(int j=0; j< imageData[i].length; j++){
				if((i == j) && (imageData[i][j])){
					countOfPixels++;
				}
			}
		}
		if(!digitValuesForFeature2Mapping.containsKey(digit)){
			List<Integer> featureValues = new ArrayList<Integer>();
			digitValuesForFeature2Mapping.put(digit, featureValues);
		}
		/*if(!digitFeatureMapping.containsKey(digit)){
			Features<Integer> feature = new Features<Integer>();
			feature.setLabel(digit);
			valuesList = new ArrayList<Integer>();
			valuesList.add(countOfPixels);
			feature.setValues(valuesList);
			digitFeatureMapping.put(digit, feature);
		}
		else{
			digitFeatureMapping.get(digit).getValues().add(countOfPixels);
		}*/
		digitValuesForFeature2Mapping.get(digit).add(countOfPixels);
		countOfPixels = 0;
		//System.out.println("No.of forward diagonal elements for 5 is: " + digitFeatureMapping.get(5).getValues().get(0));
		//return digitFeatureMapping;
	}
	
	public void calcBackwardDiagonalElements(int digit, boolean[][] imageData){
		digitValuesForFeature3Mapping = featureTypeMapping.get(FeatureType.NO_OF_PIXELS_IN_BACKWARD_DIAGONAL);
		for(int i=0;i<imageData.length;i++){
			for(int j=0; j< imageData[i].length; j++){
				if((j == (imageData[i].length - i)) && (imageData[i][j])){
					countOfPixels++;
				}
			}
		}
		if(!digitValuesForFeature3Mapping.containsKey(digit)){
			List<Integer> featureValues = new ArrayList<Integer>();
			digitValuesForFeature3Mapping.put(digit, featureValues);
		}
		/*if(!digitFeatureMapping.containsKey(digit)){
			Features<Integer> feature = new Features<Integer>();
			feature.setLabel(digit);
			valuesList = new ArrayList<Integer>();
			valuesList.add(countOfPixels);
			feature.setValues(valuesList);
			digitFeatureMapping.put(digit, feature);
		}
		else{
			digitFeatureMapping.get(digit).getValues().add(countOfPixels);
		}*/
		digitValuesForFeature3Mapping.get(digit).add(countOfPixels);
		countOfPixels = 0;
		//System.out.println("No.of backward diagonal elements for 5 is: " + digitFeatureMapping.get(5).getValues().get(0));
		//return digitFeatureMapping;
	}
	
	public void displayMap(){
		Map<Integer, List<Integer>> tempMap;
		Set<Integer> featureTypeKeys = featureTypeMapping.keySet();
		Iterator iterate = featureTypeKeys.iterator();
		while(iterate.hasNext()){
			Integer featureType = (Integer) iterate.next();
			System.out.println("Output for feature: "+featureType);
			tempMap = featureTypeMapping.get(featureType);
			Set<Integer> digitKeys = tempMap.keySet();
			Iterator iterate1 = digitKeys.iterator();
			while(iterate1.hasNext()){
				Integer digit = (Integer) iterate1.next();
				System.out.println("Values of feature for digit "+digit);
				System.out.println(tempMap.get(digit));
			}
		}
		
		/*while(iterate.hasNext()){
			Integer key = (Integer) iterate.next();
			System.out.println("Values of feature for digit "+key);
			System.out.println(featureMap.get(key).getValues());
		}*/
	}
	
	/*public void clearMapForNextFeature(){
		digitFeatureMapping.clear();
	}*/
}
