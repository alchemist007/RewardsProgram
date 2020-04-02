import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RewardsProgram {

	public static void main(String[] args) {
		
		Scanner scanner;
		
		try {
			scanner = new Scanner(new File("InputFile.txt"));
			
			while (scanner.hasNextLine()) {
		
				String customerName = scanner.nextLine();
				
				System.out.println(customerName);
				
				
				double totalPoints = 0;
				
				int months = 0;
				while(months < 3) {
					
					String month = scanner.nextLine();
					
					ArrayList<Double> transactions = new ArrayList();
					
					for(String s: scanner.nextLine().split(" ")) {
						transactions.add(Double.parseDouble(s));
					}
					//count reward for month customer
					double monthlyPoints = calculateMonthlyPoints(transactions);
					
					//Print reward for that month
					System.out.print("Reward point for " + month + ": ");
					System.out.printf("%.2f", monthlyPoints);
					System.out.println();
					
					totalPoints += monthlyPoints;
					
					months++;
				}
				
				//print total reward point for customer for 3 month period
				System.out.print("Total Reward Points: ");
				System.out.printf("%.2f", totalPoints);
				System.out.println();
				System.out.println("---------------");
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static double calculateMonthlyPoints(ArrayList<Double> transactions) {
		double points = 0;
		
		for(Double d : transactions) {
			if(d >= 50 && d <= 100) {
				points += d - 50;
			}
			else if(d > 100) {
				points = points + (2*(d - 100)) + 50;
			}		
		}
		
		return points;
	}
	

}
