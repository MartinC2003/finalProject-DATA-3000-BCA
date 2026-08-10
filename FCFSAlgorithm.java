import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FCFSAlgorithm {
    final static Scanner SCANNER = new Scanner(System.in);

    // TEMPORARY PROCESS CLASS
    static class Process {
        String processID;
        int arrivalTime;
        int burstTime;

        Process(String processID, int arrivalTime, int burstTime) {
            this.processID = processID;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(
            null,
            "The FCFS (First-Come-First-Serve) Scheduling Simulation!\nPress OK to Start",
            "Welcome to",
            JOptionPane.INFORMATION_MESSAGE
        );

        // TEMPORARY QUEUE VARIABLE
        Queue<Process> queue = new LinkedList<>();

        System.out.print("Enter the number of processes - ");
        int n = SCANNER.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter arrival time for process " + i + " - ");
            int arrivalTime = SCANNER.nextInt();
            System.out.print("Enter burst time for process " + i + " - ");
            int burstTime = SCANNER.nextInt();

            queue.add(new Process(String.valueOf(i), arrivalTime, burstTime)); // change this to enqueue
        }

        SCANNER.close();

        // FCFS algo
        
        // timeframe of k step, some process_i may arrive before/after process_i-1 burst finishes, 
        // process_i has to yield before it can start it's burst time on k steps
        int currentTime = 0;
        double totalWaiting = 0;
        double totalTurnaround = 0;
        int waitingTime = 0;
        int turnaroundTime = 0;
        String results = "";

        for (Process p : queue) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            waitingTime = currentTime - p.arrivalTime;
            turnaroundTime = waitingTime + p.burstTime;
            currentTime += p.burstTime;
            totalWaiting += waitingTime;
            totalTurnaround += turnaroundTime;

            results += "Process P" + p.processID + " <...> Arrival Time = " + p.arrivalTime + " <...> Waiting Time = " + waitingTime + " <...> Turnaround Time = " + turnaroundTime + "\n";
        }

        JOptionPane.showMessageDialog(
            null,
            results,
            "Results",
            JOptionPane.INFORMATION_MESSAGE
        );

        JOptionPane.showMessageDialog(
            null,
            "Average Waiting Time = " + (totalWaiting / n)+ "\nAverage Turnaround Time = " + (totalTurnaround / n)
        );
    }
}
