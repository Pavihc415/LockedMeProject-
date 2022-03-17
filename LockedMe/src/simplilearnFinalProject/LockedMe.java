package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.*;


public class LockedMe 
{
	static final String projectFilesPath="D:\\SimplilearnProject\\All files";	
	public static void welcomeMenu()
	{
		System.out.println("**********************************************************");
		System.out.println("\tWelcome to LockedMe.com secure app");
		System.out.println("**********************************************************");
		System.out.println("\tDeveloped by: PAVITHRA H C");
		System.out.println("**********************************************************");
		
	}
	public static void displayMenu()      /*Displays the menu options*/
	{
		System.out.println("\n----------------------------------------------------------");
		System.out.println("                          MENU                            ");
		System.out.println("----------------------------------------------------------");
		System.out.println("\t1. Display all files.");
		System.out.println("\t2. Add a new file.");
		System.out.println("\t3. Delete file.");
		System.out.println("\t4. Search file.");
		System.out.println("\t5. Exit.");
		System.out.println("----------------------------------------------------------");
	}
	public static void getAllFiles()    /*Method to fetch all files in the folder*/
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if (listOfFiles.length>0)
		{
			System.out.println("Files fetched successfully. Below is the list of files");
		for(var l:listOfFiles)
		{
			
			System.out.println(l.getName());
		}
		}
		else {
			System.out.println("The folder is empty");
		}
	}
	public static void createFile()   /*Method to add new file to the system*/
	{
		try
		{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the file name you want to add : ");
		fileName=obj.nextLine();
		if(checkFileExists(fileName))
		{
			System.out.println("This file already exists");
		}
		else
		{
		int linesCount;
		System.out.println("Enter how many lines are in the file '"+ fileName+"':" );
		linesCount=Integer.parseInt(obj.nextLine());
		
		FileWriter fw = new FileWriter(projectFilesPath+"\\"+fileName);
		//Read line by line from user
		for(int i=1;i<=linesCount;i++) {
			System.out.println("Enter line "+i+" of file '"+fileName+"'");
			fw.write(obj.nextLine()+"\n");
		}
		System.out.println("File created successfully");
		fw.close();
		}
		}catch(Exception Ex)
		{
			
		}
		
	}
	public static boolean checkFileExists(String FileName)  /*Method to check the existence of the file*/
	{
		ArrayList<String> allFileNames = new ArrayList<String>();
		File folder=new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length>0)
		{
			
		for(var l:listOfFiles)
		{
			allFileNames.add(l.getName());
		}
		}
				
		return allFileNames.contains(FileName);
			
		
	}
	public static void deleteFile()   /*Method to delete user mentioned file*/
	{
		try
		{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the file name you want to delete : ");
		fileName=obj.nextLine();
		File f = new File(projectFilesPath+"\\"+fileName);	
			
		if(checkFileExists(fileName))
		{
			f.delete();
			System.out.println("File deleted successfully");
		}
		else
		{
			System.out.println("File does not exist");
		}
		}
		catch (Exception Ex)
		{
			System.out.println("Unable to delete this file. Please contact admin@lockedme.com");
		}
	}
	public static void searchFile()    /*Method to search user mentioned file*/
	{
		try
		{
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name to be searched:");
			fileName=obj.nextLine();
			
			if(checkFileExists(fileName))
			{
				System.out.println("File is available");
			}
			else
			{
				System.out.println("This file is not available");
			}
			
		}
		catch(Exception Ex)
		{
			
		}
		
		
		
	}
}
