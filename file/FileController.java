package file;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileController {
	
	/** Creates a folder with the selected name within the current working directory
	 * 
	 * @param folderName  name of the folder to create
	 * @return boolean was folder created
	 */
	public boolean createPathInDir(String folderName) {
		//Get working folder and OS separator symbol
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		
		//Set file path and folder within working directory
		File filePath = new File(fDirectory + fSeparator + folderName + fSeparator);
		if(filePath.mkdirs()) {
			System.out.println("Directory has been created: " + filePath);
			return true;
		}
		else
			System.out.println("Directory " + folderName + " exists.");
		return false;
	}
	
	
	/** Creates a file with the selected name and folder within the current working directory.
	 * Only one level of depth.
	 * 
	 * @param fileName  name of the file to create
	 * @param folderInDir  name of the folder to create file in
	 * @return boolean was file created
	 */
	public boolean createFileInDir(String fileName, String folderInDir)
	{
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		createPathInDir(folderInDir);
		
		//Get file location
		File file = new File(fDirectory + fSeparator + folderInDir + fSeparator + fileName);
		
		//Create file
		try {
			if(file.createNewFile()) {
				System.out.println("File Created: " + file.getName());
				return true;
			}
			else
				System.out.println("File " + fileName + " exists");
			
			
		} catch(IOException e) {
			System.out.println("Error: file create failed.");
			e.printStackTrace();
		}
		
		return false;
	}
	
	/** Creates a file with the selected name within the current working directory.
	 * Only one level of depth.
	 * 
	 * @param fileName  name of the file to create
	 * @return boolean was file created
	 */
	public boolean createFile(String fileName)
	{
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		
		//Get file location
		File file = new File(fDirectory + fSeparator + fileName);
		
		//Create file
		try {
			if(file.createNewFile()) {
				System.out.println("File Created: " + file.getName());
				return true;
			}
			else
				System.out.println("File " + fileName + " exists");
			
			
		} catch(IOException e) {
			System.out.println("Error: file create failed.");
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	/**Deletes the requested file within its folder in the working directory
	 * 
	 * @param fileName
	 * @param folderInDir
	 * @return delete success
	 */
	public boolean delFileInDir(String fileName, String folderInDir)
	{
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		createPathInDir(folderInDir);
		
		//Get file location
		File file = new File(fDirectory + fSeparator + folderInDir + fSeparator + fileName);
		
		
		if(file.delete()) {
			System.out.println("File " + fileName + " delete succeeded.");
			return true;
		}
		else
			System.out.println("File " + fileName + " delete failed.");
		
		return false;
	}
	
	
	/** Deletes the requested file in the working directory
	 * 
	 * @param fileName
	 * @param folderInDir
	 * @return delete success
	 */
	public boolean delFile(String fileName)
	{
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		
		//Get file location
		File file = new File(fDirectory + fSeparator + fileName);
		
		if(file.delete()) {
			System.out.println("File " + fileName + " delete succeeded.");
			return true;
		}
		else
			System.out.println("File " + fileName + " delete failed.");
		
		return false;
	}
	
	/** Gets the file within the specified folder, and returns it to the user.
	 * Creates the file if it does not exist.
	 * 
	 * @param fileName  name of the file to get
	 * @param folderInDir  name of the folder to the file exists in
	 * @return file
	 */
	public File getFileInDir(String fileName, String folderInDir)
	{
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		
		createFileInDir(fileName, folderInDir);
		File file = new File(fDirectory + fSeparator + folderInDir + fSeparator + fileName);
		
		return file;
	}
	
	
	/** Returns the user an ArrayList containing all file names as strings 
	 * 
	 * @param folder the location to check
	 * @return An ArrayList of all files in the working directory's folder. If empty, returns null
	 */
	public static ArrayList<String> getDirContent(String folder)
	{
		ArrayList<String> dirContent = new ArrayList<String>();
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		
		
		File dir = new File(fDirectory + fSeparator + folder);
		File[] allFiles = dir.listFiles();

		if(allFiles == null) //No files in folders
			return null;
		
		for(int i = 0; i < allFiles.length; i++) {
			if(allFiles[i].isFile())
			{
				dirContent.add(allFiles[i].getName());
				//System.out.println("File " + (i+1) + ": " + dirContent.get(i));
			}
		}
		
		return dirContent;
	}
	
	
	
	/**Returns the user an ArrayList containing all file names with directory attached as strings
	 * 
	 * @param folder the location to check
	 * @return An ArrayList of all files in the working directory and their folder. If empty, returns null
	 */
	public static ArrayList<String> getDirAndContent(String folder)
	{
		ArrayList<String> dirContent = new ArrayList<String>();
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		
		
		File dir = new File(fDirectory + fSeparator + folder);
		File[] allFiles = dir.listFiles();
		
		if(allFiles == null) //No files in folders
			return null;
		
		for(int i = 0; i < allFiles.length; i++) {
			if(allFiles[i].isFile())
			{
				dirContent.add(fSeparator + folder + fSeparator + allFiles[i].getName());
				//System.out.println("File " + (i+1) + ": " + fSeparator + folder + fSeparator + allFiles[i].getName());
			}
		}
		
		return dirContent;
	}
	

	/** Creates a new dish FXML page for admin users
	 * 
	 * @param fileName
	 * @param folderInDir
	 */
	public boolean writeNewDish(String fileName, String folderInDir)
	{
		File file = getFileInDir(fileName, folderInDir);
		
		try {
			if(file.canWrite()) {
				FileWriter fwrite = new FileWriter(file.getCanonicalPath());
				System.out.println(file.getCanonicalPath());
				FileFXML dishFXML = new FileFXML("");
				
				fwrite.write(dishFXML.toString());
				fwrite.close();
				System.out.println("Successfully wrote to file");
				return true;
			}
			else 
				System.out.println("Write permissions not enabled for: " + file.getName());
			
			
		} catch(IOException e) {
			System.out.println("Error: Could not create new dish");
			e.printStackTrace();
		}
		return false;
	}
	
	
}	
		
