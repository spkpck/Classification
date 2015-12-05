package test;

import util.FileReaderForImageDataUtility;
import util.FileReaderForLabelDataUtility;

public class TestImplementation {

	public static void main(String[] args) {
		FileReaderForLabelDataUtility fileReader = new FileReaderForLabelDataUtility();
		FileReaderForImageDataUtility fileImageReader = new FileReaderForImageDataUtility();
		fileImageReader.readFromFile(fileReader.getListOfLabelElements());
	}
}
