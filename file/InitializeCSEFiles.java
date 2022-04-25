package file;

public class InitializeCSEFiles {
	
	public static boolean initialize()
	{
		boolean success = true;
		FileController make = new FileController();
		FileFXML placeholder = new FileFXML("/images/Web%201920%20–%205.png");
		String[] folders = {"FXML", "MENU", "IMAGES"};
		String[] fileName = {"ItemPlaceholder.fxml", "ItemPlaceholder.fxml", "Placheholder.png"};
		
		if(!make.writeNewDish(fileName[0], folders[0]))
			success = false;
		if(!make.writeNewDish(fileName[1], folders[1]))
			success = false;
		if(make.createFileInDir(fileName[2], folders[2]))
			success = false;
		
		if(success == true) {
			System.out.println("File initialization succeeded.");
			return true;
		}
		
		System.out.println("File initialization failed.");
		
		return false;
	}
}
