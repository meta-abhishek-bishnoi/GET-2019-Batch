/*
 * This is main class for computing fcfs algorithm
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 12-July-2019
 */
package meta.mainApp;

import java.util.Scanner;

import meta.helper.StaticCheckingAndCodeReviewQn2_Message;
import meta.helper.StaticCheckingAndCodeReviewQn2_Service;

public class StaticCheckingAndCodeReviewQn2 {

	public static void main(String[] args) {
		Scanner scanNumber = new Scanner(System.in);
		StaticCheckingAndCodeReviewQn2_Service service = new StaticCheckingAndCodeReviewQn2_Service();
		// Object of class to access the services to calculate values
		System.out.println(StaticCheckingAndCodeReviewQn2_Message.ENTER_PROCESS_MESSAGE);
		int noOfProcesses = scanNumber.nextInt();
		int processCompilationTime[] = new int[noOfProcesses];// contains data of compilation time
		int processTrunAroundTime[] = new int[noOfProcesses]; // contains data of turn around time
		int processWaitingTime[] = new int[noOfProcesses]; // contains data of waiting time
		int processArrivalTime[][] = new int[noOfProcesses][2]; 
		// this is list of processes contains arrival time and brust time
		int processMaximumWaitingTime=0;
		double processAverageTime=0;
		System.out.println(StaticCheckingAndCodeReviewQn2_Message.USER_INPUT_MESSAGE);
		/*
		 * this loop is taking input values from user into processArrivalTime[][] Array
		 */
		for(int i=0; i<noOfProcesses; i++){
			System.out.println(StaticCheckingAndCodeReviewQn2_Message.EACH_PROCESS_MESSAGE+": "+i+1);
			for(int j=0; j<2; j++){
				processArrivalTime[i][j]=scanNumber.nextInt();
			}
		}
		/*
		 * here we are calculating
		 * Complition Time For Each Process, Turn Around Time For Each Process, 
		 * Waiting Time For Each Process, Maximum Waiting Time & Average Waiting Time
		 */
		processCompilationTime = service.computeCompletionTime(processArrivalTime, noOfProcesses);
		// Computing compilation time and storing it to an array
		processTrunAroundTime = service.computeTurnAroundTime(processCompilationTime, processArrivalTime, noOfProcesses);
		// computing process Turn Around Time and storing it to an array
		processWaitingTime = service.computeWaitingTime(processTrunAroundTime, processArrivalTime, noOfProcesses);
		// computing waiting time for each process
		processMaximumWaitingTime = service.computeMaximumWaitingTime(processWaitingTime, noOfProcesses);
		// computing max waiting time
		processAverageTime = service.computeAverageWaitingTime(processWaitingTime, noOfProcesses);
		/*
		 * results
		 */
		System.out.println(StaticCheckingAndCodeReviewQn2_Message.RESULT_MESSAGE);
		for(int i=0; i<noOfProcesses; i++)
		{
			System.out.println(i+1+".\t"+""+processCompilationTime[i]+"\t\t"+processTrunAroundTime[i]+"\t\t"+processWaitingTime[i]);
		}
		System.out.println(StaticCheckingAndCodeReviewQn2_Message.AVG_WAITING_TIME+": "+processAverageTime);
		System.out.println(StaticCheckingAndCodeReviewQn2_Message.MAXIMUM_WAITING_TIME+": "+processMaximumWaitingTime);
	}

}
