<<<<<<< HEAD
package food;

=======
>>>>>>> 7eea64c7eb8b1689ab660f68e0d19f7b30c3291a
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import food.*;

public class FoodTester{
	public static void main(String[] args){

		Menu Menu = new Menu();
		boolean testing = true;
		int sw, ttm;
		Double p;
		String t, dN;
		String[] tA, ing, tags;
		LinkedList<Dish> testList = new LinkedList<Dish>();
		Scanner scan = new Scanner(System.in);

		while(testing){
			System.out.printf("Enter the number for what you would like to test:\n1)buildMenu\n2)Add a menu item\n3)searchByTag\n4)searchByTerm\n5)searchByIngredients\n6)Get a dish's info\n7)Exit\n");
			sw = scan.nextInt();

			switch (sw) {

				case 1:
					Menu.buildMenu();
					break;

				case 2:
					System.out.printf("--Enter the following information as prompted--\nDish Name: ");
					dN = scan.next();
					System.out.printf("\nIngredient(s), separated by commas and without spaces: ");
					t = scan.next();
					ing = t.split(",",10);
					System.out.printf("\nTag(s), separated by commas and without spaces: ");
					t = scan.next();
					tags = t.split(",", 5);
					System.out.printf("\nPrice, with a decimal: ");
					p = scan.nextDouble();
					System.out.printf("\nTime to make, as a whole number in minutes: ");
					ttm = scan.nextInt();
					System.out.printf("Adding item...     ");
					Menu.addMenuItem(dN, p, ttm, ing, tags);
					System.out.printf("It's been added!");
					break;

				case 3:
					System.out.printf("Enter the tags(s) you wish to search by, separated by commas and without spaces:\n");
					t = scan.next();
					tA = t.split(",", 5);
					testList = Menu.searchByTag(tA);
					for(int x=0; x<testList.size();x++){System.out.printf("%s \n",testList.pop().getDishName());}
					System.out.printf("\n");
					break;

				case 4:
					System.out.printf("Enter the term you wish to search by:\n");
					t = scan.next(); System.out.printf("You entered: %s/n", t);
					testList = Menu.searchByTerm(t);
					for(int y=0; y<testList.size();y++){System.out.printf("%s \n",testList.pop().getDishName());}
					System.out.printf("\n");
					break;

				case 5:
					System.out.printf("Enter the ingredient(s) you wish to search by, separated by commas and without spaces:\n");
					t = scan.next();
					tA = t.split(",", 10);
					testList = Menu.searchByIngredients(tA);
					for(int z=0; z<testList.size();z++){System.out.printf("%s \n",testList.pop().getDishName());}
					System.out.printf("\n");
					break;

				case 6:
					System.out.println("Which dish would you like the info for?");
					for(int w=0; w<Menu.menu.size();w++){System.out.printf("%d) %s\n", w, Menu.menu.get(w).getDishName());}
					int myDi = scan.nextInt();
					System.out.printf("---%s---\n%s\n%s\n\nPrice: $%f\nTTM: %d\n",Menu.menu.get(myDi).getDishName(), Arrays.toString(Menu.menu.get(myDi).getIngredients()), Arrays.toString(Menu.menu.get(myDi).getTags()), Menu.menu.get(myDi).getPrice(), Menu.menu.get(myDi).getTimeToMake());
					break;
				case 7:
					testing = false;
					break;

				default:
					System.out.printf("The option you entered is not valid.");
					break;
			}
		}
	}
}
