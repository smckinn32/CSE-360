package file;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

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
			System.out.println("Directory exists.");
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
				System.out.println("File exists");
			
			
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
				System.out.println("File exists");
			
			
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
			System.out.println("File delete succeeded.");
			return true;
		}
		else
			System.out.println("File delete failed.");
		
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
			System.out.println("File delete succeeded.");
			return true;
		}
		else
			System.out.println("File delete failed.");
		
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
	
	
	
	/**
	 * 
	 * @param fileName
	 * @param folderInDir
	 */
	public void writeTo(String fileName, String folderInDir)
	{
		String fDirectory = System.getProperty("user.dir");
		String fSeparator = System.getProperty("file.separator");
		createFileInDir(fileName, folderInDir);
		//System.getProperties();
		//System.out.println(fDirectory);
		//System.out.println(fSeparator);
		
		File file = new File(fDirectory + fSeparator + folderInDir + fSeparator + fileName);

		try {
			if(file.canWrite()) {
				FileWriter fwrite = new FileWriter(file.getName());
				fwrite.write("//This is just a test");
				fwrite.close();
				System.out.println("Successfully wrote to file");
			}
			else
				System.out.println("Write permissions not enabled for: " + file.getName());
			
			
			
		} catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
		

	/** Creates a new dish FXML page for admin users
	 * 
	 * @param fileName
	 * @param folderInDir
	 */
	public void writeNewDish(String fileName, String folderInDir)
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
			}
			else 
				System.out.println("Write permissions not enabled for: " + file.getName());
			
			
		} catch(IOException e) {
			System.out.println("Error: Could not create new dish");
			e.printStackTrace();
		}
	}
	
	
}	
		
		
		
		
		/*		
		try {
			
			//File writer
			PrintWriter outFile = new PrintWriter(filename);
			
			outFile.print("1234");
			outFile.close();
			
			//BufferedReader
			FileReader fr = new FileReader(filename);
			BufferedReader inFile = new BufferedReader(fr);
			//Scanner in = new Scanner(fr)
			
			String line = inFile.readLine();
		
			while (line != null) {
				System.out.println(line);
				inputLine = Integer.parseInt(line);
				sum += inputLine;
				line = inFile.readLine();
				
			}
			inFile.close();
			
			} catch(IOException e) {
				System.out.println("IO exception" + e);
			}
			
		
		try {

			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			
			objOut.writeChars("1234");
			
			fileOut.close();
			objOut.close();
		}
		catch(IOException ioe) {
			System.out.print("Data file written exception\n");
		}

		//Deserialize DeptManagement from a File
		System.out.print("Please enter a file name which we will read from:\n");
		filename = stdin.readLine().trim();
		try {
/************************************************************************************
***  Complete the follwing statement, read object from the data file and save the object
as deptManage1
***********************************************************************************/
/*			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			deptManage1 = (DeptManagement)objIn.readObject();
						
			fileIn.close();
			objIn.close();
		} catch(Exception e) {}
		
		
/************************************************************************************
***  Complete the follwing statement, write above string inside the relevant file
***********************************************************************************/
/*		//Create output stream
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
								
			//Get string to write
			System.out.print("Please enter a string to write inside the file:\n");
			String temp = stdin.readLine();
			temp += "\n";
				
			//Write String
			writer.write(temp);
			System.out.print(filename + " is written\n");
						
			//Close output stream
			writer.close();
		} catch(Exception e) {
			System.out.print("Write string inside the file error\n");
		}

		System.out.print("Please enter a file name which we will read from:\n");
		filename = stdin.readLine().trim();
		
/************************************************************************************
***  Complete the follwing statement, read from above text file
***********************************************************************************/
/*		try {	
			BufferedReader reader = new BufferedReader(new FileReader(filename));
							
			System.out.print(filename + " was read\n");
							
			String temp = reader.readLine();
			System.out.print("The first line of the file is:\n");
			System.out.print(temp + "\n");
			
			reader.close();
		}
			catch(FileNotFoundException fe) {
			System.out.print(filename + " not found error\n");
		}
			catch(IOException ioe) {
			System.out.print("Read string from the file error\n");
		}
		
		//Serialize DeptManagement to a File
		System.out.print("Please enter a file name which we will write to:\n");
		filename = stdin.readLine().trim();
		
/************************************************************************************
***  Complete the follwing statement, write object deptManage1 inside the data file
***********************************************************************************/
/*		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
								
			objOut.writeObject(deptManage1);
								
			fileOut.close();
			objOut.close();
		}
		catch(NotSerializableException se) {
			System.out.print("Not serializable exception\n");
		}
		catch(IOException ioe) {
			System.out.print("Data file written exception\n");
		}

		//Deserialize DeptManagement from a File
		System.out.print("Please enter a file name which we will read from:\n");
		filename = stdin.readLine().trim();
		
/************************************************************************************
***  Complete the follwing statement, read object from the data file and save the object
as deptManage1
***********************************************************************************/
/*		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
						
			deptManage1 = (DeptManagement)objIn.readObject();
						
			fileIn.close();
			objIn.close();
		}
		catch(ClassNotFoundException ce) {
			System.out.print("Class not found exception\n");
		}
	}
*/

