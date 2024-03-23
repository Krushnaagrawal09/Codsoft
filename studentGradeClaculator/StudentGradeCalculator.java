package studentGradeClaculator;
import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Student Name : ");
        String name = scanner.next();
        System.out.print("Enter the total number of subject : ");
        int totalNumSub = scanner.nextInt();
        
        int [] marks = new int [totalNumSub];
        for(int i = 0 ; i < totalNumSub ; i++) {
        	System.out.print("Enter marks obtained in subject "+(i+1) +" : ");
        	marks[i]=scanner.nextInt();
        }
        
        int totalMarksObtained=0;
        for(int mark : marks) {
        	totalMarksObtained+=mark;
        }
        
        double averagePercentage = totalMarksObtained/totalNumSub;
        System.out.println(averagePercentage);
        
        char grade ;
        
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("--"+(name)+"'s Result--");
        System.out.println("Total Marks : "+totalMarksObtained);
        System.out.println("Average Percentage : "+averagePercentage);
        System.out.println("Grade : "+grade);
	}

}
