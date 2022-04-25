package file;

public class FileFXML {
	
	private String imgLocale = null;
	private String dishFXML = null;
	
	public FileFXML(String imageLocation)
	{
		imgLocale = "/images/Web%201920_5.png";
		dishFXML = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
			+ "\r\n"
			+ "<?import javafx.scene.control.Button?>\r\n"
			+ "<?import javafx.scene.control.ListView?>\r\n"
			+ "<?import javafx.scene.control.TextField?>\r\n"
			+ "<?import javafx.scene.image.Image?>\r\n"
			+ "<?import javafx.scene.image.ImageView?>\r\n"
			+ "<?import javafx.scene.layout.AnchorPane?>\r\n"
			+ "<?import javafx.scene.layout.Pane?>\r\n"
			+ "<?import javafx.scene.text.Font?>\r\n"
			+ "\r\n"
			+ "<AnchorPane xmlns=\"http://javafx.com/javafx/17\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"application.PipeLine\">\r\n"
			+ "   <children>\r\n"
			+ "      <Pane prefHeight=\"1080.0\" prefWidth=\"1920.0\">\r\n"
			+ "         <children>\r\n"
			+ "            <ImageView fitHeight=\"1080.0\" fitWidth=\"1920.0\" pickOnBounds=\"true\" preserveRatio=\"true\">\r\n"
			+ "               <image>\r\n"
			+ "                  <Image url=\"@../images/Web%201920_5.png\" />\r\n"
			+ "               </image>\r\n"
			+ "            </ImageView>\r\n"
			+ "            <Button fx:id=\"exitButton\" layoutX=\"90.0\" layoutY=\"20.0\" mnemonicParsing=\"false\" onAction=\"#logoutFunction\" opacity=\"0.0\" prefHeight=\"47.0\" prefWidth=\"62.0\" text=\"Exit Button\" />\r\n"
			+ "            <Button fx:id=\"shoppingCartButton\" layoutX=\"1627.0\" layoutY=\"25.0\" mnemonicParsing=\"false\" onAction=\"#changeScene\" opacity=\"0.0\" prefHeight=\"38.0\" prefWidth=\"40.0\" text=\"Shopping Cart Button\" />\r\n"
			+ "            <Button fx:id=\"settingsButton\" layoutX=\"1716.0\" layoutY=\"25.0\" mnemonicParsing=\"false\" onAction=\"#changeScene\" opacity=\"0.0\" prefHeight=\"38.0\" prefWidth=\"40.0\" text=\"Settings Button\" />\r\n"
			+ "            <Button fx:id=\"homeButton\" layoutX=\"185.0\" layoutY=\"20.0\" mnemonicParsing=\"false\" onAction=\"#changeScene\" opacity=\"0.0\" prefHeight=\"55.0\" prefWidth=\"54.0\" text=\"Home Button\" />\r\n"
			+ "            <TextField fx:id=\"searchButton\" layoutX=\"1357.0\" layoutY=\"30.0\" onAction=\"#search\" onKeyPressed=\"#searchVisibility\" prefHeight=\"25.0\" prefWidth=\"135.0\">\r\n"
			+ "               <font>\r\n"
			+ "                  <Font size=\"14.0\" />\r\n"
			+ "               </font>\r\n"
			+ "            </TextField>\r\n"
			+ "            <ListView fx:id=\"searchBox\" layoutX=\"1325.0\" layoutY=\"67.0\" onMouseClicked=\"#changeScene\" prefHeight=\"135.0\" prefWidth=\"170.0\" visible=\"false\" />\r\n"
			+ "            <Button layoutX=\"1503.0\" layoutY=\"25.0\" mnemonicParsing=\"false\" onAction=\"#search\" opacity=\"0.0\" prefHeight=\"38.0\" prefWidth=\"86.0\" text=\"Search Button\" />\r\n"
			+ "            <Button layoutX=\"297.0\" layoutY=\"906.0\" mnemonicParsing=\"false\" opacity=\"0.0\" prefHeight=\"72.0\" prefWidth=\"316.0\" text=\"Exit Button\" />\r\n"
			+ "         </children>\r\n"
			+ "      </Pane>\r\n"
			+ "   </children>\r\n"
			+ "</AnchorPane>\r\n"
			+ "";
	}
	
	public String toString() {
		return dishFXML;
	}
	
}
