package main;

import java.util.Scanner;

import javax.swing.JOptionPane;

import algorithm.FCFSAlgorithm;
import model.Process;
import structure.QueueImplementation;

public class Main {
    final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(
            null,
            "The FCFS (First-Come-First-Serve) Scheduling Simulation!\nPress OK to Start",
            "Welcome to",
            JOptionPane.INFORMATION_MESSAGE
        );

        QueueImplementation<Process> queue = new QueueImplementation<>();

        System.out.print("Enter the number of processes - ");
        int n = SCANNER.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter arrival time for process " + i + " - ");
            int arrivalTime = SCANNER.nextInt();
            System.out.print("Enter burst time for process " + i + " - ");
            int burstTime = SCANNER.nextInt();

            queue.enqueue(new Process(String.valueOf(i), arrivalTime, burstTime));
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

/*
Run these from the project root (the folder containing "src", not inside it):

Compile:
    javac -d out -sourcepath src src/main/Main.java

Run:
    java -cp out main.Main
    if error occurs, try:
    "C:\Program Files\Eclipse Adoptium\jdk-25.0.2.10-hotspot\bin\java.exe" -cp out main.Main

*/

