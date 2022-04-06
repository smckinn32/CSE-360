package file;

import java.util.ArrayList;

public class ButtonFXML {
	
	
	/** Gets the page index within the folder of the fxml scene
	 * 
	 * @param button button that was pressed
	 * @return count of page
	 */
	public static int linkButtonToFXML(String button)
	{

		int page = 0;
		
		//NOTE: If any new pages are added or any new cases made, factor that into the remain button options
		//Currently, the page is it's count in ABC order within the folder. 
		switch(button) {
		
		case "YourOrdersButton" :
			//YourOrders
			page = 11;
			break;		
		
		case "shoppingCartButton" :
			//ShoppingCart
			page = 10;
			break;
			
		case "SearchPreferencesButton" :
			//SearchPreferences
			page = 9;
			break;			
			
		case "orderPlacedButton" :
			//OrderPlaced
			page = 8;
			break;			
			
		case "homeButton", "Login" :
			//Menu
			page = 7;
			break;
			
		case "SignIn" :
			//LoginScreen
			page = 6;
			break;		
		
		case "searchBox" :
			//ItemPlaceholder - or new menu items
			page = 5;
			break;			
			
		case "createAccountButton" :
			//CreateAccountScene
			page = 4;
			break;			
		
		case "AdminChangeMenuButton" :
			//AdminChangeMenu
			page = 3;
			break;
			
		case "AdminAddMenuButton":
			//AdminAddMenu
			page = 2;
			break;
			
		case "settingsButton", "YourAccountButton" : 
			//AccountSettings
			page = 1;
			break;

		default:
			page = 6;
			break;							
		}
		
		//Turns count into the index
		return page-1;
	}
	
	
	/** Gets the content of a directory and converts them from a file to resource format
	 * 
	 * @param folder containing the relevant files
	 * @return ArrayList of strings containing resource names
	 */
	public static ArrayList<String> getDirectoryAsResource(String folder)
	{
		ArrayList<String> scene = FileController.getDirContent(folder);
		for(int i = 0; i < scene.size(); i++)
		{
			scene.set(i, "/" + folder + "/" + scene.get(i));
		}
		return scene;
	}
}
