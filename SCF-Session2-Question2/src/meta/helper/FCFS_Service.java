/*
 * This is Supportive class for computing fcfs algorithm
 * which returns values to main class
 * @author ABHISHEK BISHNOI
 * @version 1.0
 * @since 12-July-2019
 */
package meta.helper;

public class FCFS_Service {
	/*
	 *  @param timeArray[] this array is the time table of process (arrival time & brust time)
	 *  @param numberOfProcess is the number of total process 
	 *  @return an array of computation time
	 */
	public int[] computeCompletionTime( int timeArray[][], int numberOfProcess ) {
		int completionArray[] = new int[numberOfProcess];
		completionArray[0] = timeArray[0][0] + timeArray[0][1];
		for (int i = 1; i < numberOfProcess; i++) {
			if (timeArray[i][0] < timeArray[i - 1][1]) {
				completionArray[i] = completionArray[i - 1] + timeArray[i][1];
			} else
			{
				completionArray[i] = timeArray[i][0] + timeArray[i][1];
			}
		}
		return completionArray;
	}
	
	/*
	 *  @param completionTimeArray[] this is pre computed table or array of computation time
	 *  @param timeArray[] this array is the time table of process (arrival time & brust time)
	 *  @param numberOfProcess is the number of total process 
	 *  @return an array of trun around time
	 */
	public int[] computeTurnAroundTime( int completionTimeArray[], int timeArray[][], int numberOfProcess ) {

		int turnaroundArray[] = new int[numberOfProcess];
		for (int j = 0; j < numberOfProcess; j++) {
			turnaroundArray[j] = completionTimeArray[j] - timeArray[j][0];
		}
		return turnaroundArray;
	}
	/*
	 *  @param turnAroundTimeArray[] this is pre computed table or array of trun around time
	 *  @param timeArray[] this array is the time table of process (arrival time & brust time)
	 *  @param numberOfProcess is the number of total process 
	 *  @return an array of waiting time of processes
	 */
	public int[] computeWaitingTime( int turnAroundTimeArray[], int timeArray[][], int numberOfProcess) {

		int waitingArray[] = new int[numberOfProcess];
		for (int j = 0; j < numberOfProcess; j++) {
			waitingArray[j] = turnAroundTimeArray[j] - timeArray[j][1];
		}
		return waitingArray;
	}
	/*
	 *  @param waitingArray[] this is precomputed table or array of waiting time
	 *  @param numberOfProcess is the number of total process 
	 *  @return an array of average waiting time of processes
	 */
	public double computeAverageWaitingTime(int waitingArray[], int numberOfProcess) {
		double average = 0.0;
		for (int k = 0; k < numberOfProcess; k++) {
			average = waitingArray[k] + average;
		}
		return average;

	}
	
	/*
	 *  @param waitingArray[] this is pre computed table or array of waiting time
	 *  @param numberOfProcess is the number of total process 
	 *  @return an array of meximum waiting time of processes
	 */
	public int computeMaximumWaitingTime(int waitingArray[], int numberOfProcess) {
		int maximum = 0;
		for (int i = 0; i < numberOfProcess; i++) {
			if (waitingArray[i] > maximum) {
				maximum = waitingArray[i];
			}
		}
		return maximum;
	}
}
