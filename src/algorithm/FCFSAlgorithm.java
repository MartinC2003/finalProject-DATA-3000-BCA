package algorithm;

import java.util.Queue;

public class FCFSAlgorithm {

    // TEMPORARY PROCESS CLASS
    public static class Process {
        String processID;
        int arrivalTime;
        int burstTime;

        Process(String processID, int arrivalTime, int burstTime) {
            this.processID = processID;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }
    }

    // Holds the output of the simulation so Main can display it
    static class Results {
        String resultsText;
        double averageWaitingTime;
        double averageTurnaroundTime;
    }

    // FCFS algo
    // timeframe of k step, some process_i may arrive before/after process_i-1 burst finishes,
    // process_i has to yield before it can start it's burst time on k steps
    public static Results run(Queue<Process> queue, int n) {
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

        Results output = new Results();
        output.resultsText = results;
        output.averageWaitingTime = totalWaiting / n;
        output.averageTurnaroundTime = totalTurnaround / n;
        return output;
    }
}