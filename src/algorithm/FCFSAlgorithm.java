package algorithm;

import model.Process;
import structure.QueueImplementation;

public class FCFSAlgorithm {

    // Holds the output of the simulation so Main can display it
    public static class Results {
        public String resultsText;
        public double averageWaitingTime;
        public double averageTurnaroundTime;
    }

    // FCFS algo
    // timeframe of k step, some process_i may arrive before/after process_i-1 burst finishes,
    // process_i has to yield before it can start it's burst time on k steps
    public static Results run(QueueImplementation<Process> queue, int n) {
        int currentTime = 0;
        double totalWaiting = 0;
        double totalTurnaround = 0;
        int waitingTime = 0;
        int turnaroundTime = 0;
        String results = "";

        while (!queue.isEmpty()) {
            Process p = queue.dequeue();

            if (currentTime < p.getArrivalTime()) {
                currentTime = p.getArrivalTime();
            }
            waitingTime = currentTime - p.getArrivalTime();
            turnaroundTime = waitingTime + p.getBurstTime();
            currentTime += p.getBurstTime();
            totalWaiting += waitingTime;
            totalTurnaround += turnaroundTime;

            p.setWaitingTime(waitingTime);
            p.setTurnaroundTime(turnaroundTime);

            results += "Process P" + p.getProcessId() + " <...> Arrival Time = " + p.getArrivalTime() + " <...> Waiting Time = " + waitingTime + " <...> Turnaround Time = " + turnaroundTime + "\n";
        }

        Results output = new Results();
        output.resultsText = results;
        output.averageWaitingTime = totalWaiting / n;
        output.averageTurnaroundTime = totalTurnaround / n;
        return output;
    }
}