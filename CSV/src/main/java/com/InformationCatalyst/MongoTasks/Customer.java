package com.InformationCatalyst.MongoTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {
	private static final Logger logger = LoggerFactory.getLogger(MongoMain.class);

	public static void main(String[] args) throws IOException {
//sets the file path to the following string
		String FilePath = "src/main/resources/customers.csv";

		// logger.info("Results of the file \n" + (readAll(FilePath)));
		read34(FilePath);

	}

	public static String read34(String FilePath) {

		BufferedReader buffr = null;
		String column = "";
		String seperate = ",";
		try {
//creates new buffer with the contents of the CSV
			buffr = new BufferedReader(new FileReader(FilePath));
//        	While the buffers still has lines to run through it will continue
			while ((column = buffr.readLine()) != null) {
//here I am adding the lines to the "colomn and then adding that to the info array. the values are split up using the seperator string
				String[] info = column.split(seperate);
//                here i take the first value of each name
				char firstName = info[2].charAt(0);
//                switch case to sort out what gets printed and what gets skipped. if it snags on any of the letters the value wont be logged
				switch (firstName) {
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
					break;
				default:
//                		logs the output
					System.out.println("Output:: first name=  " + info[2] + " , last name = " + info[3]);
					break;

				}
			}
//            if the CSV does not connect this gets run
		} catch (IOException fileNotFound) {
			logger.info("The File can not be reached");
			logger.info(fileNotFound.getMessage());
			logger.info("\n");
		}

		return column;
	}

//	public static String readAll(String FilePath) throws IOException {
//		String CustomerCSV = "";
//		return CustomerCSV;
//	}

}
