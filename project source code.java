package com.caltech.file.project;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path="D:\\caltech\\";
		String filename;
		String finalpath;
		File[] filesname;
		
		while(true) {
			System.out.println("==========================================================");
			System.out.println("****************File Opertions Test***********************");
			System.out.println("==========================================================");
			System.out.println("Enter a digit to perform following operations:\n");
			System.out.println("1. Create a file");
			System.out.println("2. Delete a file");
			System.out.println("3. Display the files of a directory in ascending order");
			System.out.println("4. Search a file");
			
			Scanner sc=new Scanner(System.in); 
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("Enter a file name to be created: ");
				filename=sc.next();
				finalpath=path+filename;
				System.out.println(finalpath);
				//create a file
				File file=new File(finalpath);
				boolean res=file.createNewFile();
				if(res!=true) {
					System.out.println("File is not created");
				}
				else {
					System.out.println("File is created successfully.");
				}
				break;
			case 2:
				System.out.println("Enter the file name to be deleted: ");
				filename=sc.next();
				finalpath=path+filename;
				System.out.println(finalpath);				
				file=new File(finalpath);
				//delete operation
				file.delete();
				System.out.println("File is deleted successfully.");
				break;
			case 3:
				file=new File(path);
				//display operation
				filesname = file.listFiles();
				//for-each
				System.out.println("The list of files in asscending order in the directory \""+ path +"\" is: ");
				for(File ff:filesname) {
					System.out.println(ff.getName());
				}
				break;
			case 4:
				System.out.println("Enter a file name to search:");
				String filenamesearch=sc.next();
				file=new File(path);
				//display operation
				filesname = file.listFiles();
				//for-each
				int flag=0;
				for(File ff:filesname) {
					if(ff.getName().equals(filenamesearch)) {
						flag=1;
						break;
					}
					else {
						flag=0;
					}
				}
				
				if(flag==1) {
					System.out.println("File is found");
				}
				else {
					System.out.println("File is not found");
				}				
				break;
			default:
				System.out.println("Invalid input. Enter a valid number.");
				break;
			}
		}				
	}
}
