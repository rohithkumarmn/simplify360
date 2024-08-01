package Question2;

import java.util.Scanner;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		Community community = new Community();
		
		System.out.println("Enter the number of people:");
		int numPeople = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the names of the people:");
		for(int i =0;i<numPeople;i++) {
			String personName = scanner.nextLine();
			community.addMember(personName);
		}
		
		System.out.println("Enter the number of connections:");
		int numConnections = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the connections(format: name1 name2):");
		for(int i =0;i<numConnections;i++) {
			String name1 = scanner.next();
			String name2 = scanner.next();
			
			community.createConnection(name1, name2);
			
		}
		
		System.out.println("Enter the names to find the connectionLevel:");
		String name1 = scanner.next();
		String name2 = scanner.next();
		
		int connectionLevel = community.findConnectionLevel(name1, name2);
		System.out.println("Connecttion level between "+ name1 + "and" + name2 + " : "+connectionLevel);
		
		
		
		
		
		
		
		
	}

}
