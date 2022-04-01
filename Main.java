//*****************************************************************
// Group: Monday Team 23
// Members: 
//	Abou Saleh, Laith
//	Carter, Emerson
//	Elliot, Aften
//	Rodriguez, Dominic
//  Mckinnon, Sean
// Class: CSE 360
// Time: 3:00pm Mon
// Instructor: Nicole Ang-Wanek 
// Description: This program is designed first to allow customers to place 
//	orders, and purchase food with convenience. It additionally provides
//	stores the tools to update their menu and provide benefits to their
//	loyal customers.
//*****************************************************************


package application;

import profiles.CommonU;
import profiles.TestProfiles;

import java.io.*;

public class Main {
	/**Takes the launch arguments on start and initializes the
	 * pipeline operation, managing data and starting Application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Pipeline main = new Pipeline(args);
		main.run();
	}
}
