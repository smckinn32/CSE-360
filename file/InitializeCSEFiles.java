package file;

public class InitializeCSEFiles {
	
	public static boolean initialize()
	{
		FileController make = new FileController();
		FileFXML placeholder = new FileFXML("/images/Web%201920%20–%205.png");
		String[] folders = {"FXML", "MENU", "IMAGES"};
		String[] fileName = {"ItemPlaceholder.fxml", "ItemPlaceholder.fxml", "Placheholder.png"};
		
		make.writeNewDish(fileName[0], folders[0]);
		make.writeNewDish(fileName[1], folders[1]);
		make.createFileInDir(fileName[2], folders[2]);
		
		System.out.println("File initialization failed.");
		return false;
	}
}
