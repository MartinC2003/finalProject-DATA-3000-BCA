package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.JOptionPane;

import algorithm.FCFSAlgorithm;

public class Main {
    final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(
            null,
            "The FCFS (First-Come-First-Serve) Scheduling Simulation!\nPress OK to Start",
            "Welcome to",
            JOptionPane.INFORMATION_MESSAGE
        );

        // TEMPORARY QUEUE VARIABLE
        Queue<FCFSAlgorithm.Process> queue = new LinkedList<>();

        System.out.print("Enter the number of processes - ");
        int n = SCANNER.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter arrival time for process " + i + " - ");
            int arrivalTime = SCANNER.nextInt();
            System.out.print("Enter burst time for process " + i + " - ");
            int burstTime = SCANNER.nextInt();

            queue.add(new FCFSAlgorithm.Process(String.valueOf(i), arrivalTime, burstTime)); // change this to enqueue
        }

        SCANNER.close();

        FCFSAlgorithm.Results output = FCFSAlgorithm.run(queue, n);

        JOptionPane.showMessageDialog(
            null,
            output.resultsText,
            "Results",
            JOptionPane.INFORMATION_MESSAGE
        );

        JOptionPane.showMessageDialog(
            null,
            "Average Waiting Time = " + output.averageWaitingTime + "\nAverage Turnaround Time = " + output.averageTurnaroundTime
        );
    }
}