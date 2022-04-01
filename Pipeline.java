package application;

import food.*;
import money.*;
import profiles.*;
import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import javafx.application.Application;



public class Pipeline {
	private String[] args;
	private Menu currMenu;
	private CommonU currUser;
	private LinkedList<Dish> searchResult_menu;
	
	
	
	/**
	 * 
	 * @param args
	 */
	public Pipeline(String[] args) {
		currMenu = new Menu();
		currMenu.buildMenu();
		currUser = new CommonU();
		this.args = args;
	}
	
	
	/** Primary pipeline operations, intended to setup
	 * 
	 */
	public void run() {
		
		
		//while(currUser == null) {
			//loginApp();
		//}
		
		//System.out.println(currUser.toString());
		//search();
		
		
		//Application.launch(GUI.class, this.args);
	}

	
	/**
	 * @return 
	 * 
	 */
	private void loginApp() 
	{
		CommonU user = new CommonU();
		user.setFirstName("Emerson");
		//System.out.println(user.getFirstName());
		
		user.setUserInfo("AdminUser", "Password123");
		System.out.println(user.toString());
		
		//
		//currUser.setUserInfo("AdminUser", "Password123");
		//currUser.toString();
		//if(currUser.isAdmin())
		{
			
		}
			
	}
	
	private void logoutApp()
	{
		currUser = null;
	}
	
	
	/**
	 * 
	 */
	private void search()
	{
		searchResult_menu = currMenu.searchByTerm("Lasagna");
		if(!searchResult_menu.isEmpty())
		{
			System.out.println(searchResult_menu.getFirst().getDishName());
		}
	}
	
	private void fxmlDish()
	{
		//Write to fxml file at file location .../FXML/Iteminsertnamehere.fxml
		//Save image .png file to .../images/insertnamehere.png
		int inputLine, sum = 0;
		try {
			
			//File writer
			PrintWriter outFile = new PrintWriter("numbers.fxml", );
			
			//BufferedReader
			FileReader fr = new FileReader("numbers.fxml");
			BufferedReader inFile = new BufferedReader(fr);
			//Scanner in = new Scanner(fr)
			
			String line = inFile.readLine();
		
			while (line != null)
			{
				System.out.println(line);
				inputLine = Integer.parseInt(line);
				sum += inputLine;
				line = inFile.readLine();
				
			}
			inFile.close();
			outFile.close();
			
		}
		catch(IOException e)
		{
			System.out.println("IO exception" + e);
		}
		//Add to FXML file name list
		//Have image file name list & add to it
		//Replace 
	}
	
}
