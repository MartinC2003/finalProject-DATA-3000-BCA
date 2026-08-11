package model;

/**
 * Represents an individual process for the FCFS scheduling algorithm.
 * Stores the Process ID, Arrival Time, Burst Time,
 * Waiting Time, and Turnaround Time.
 */
public class Process {

    // Attributes
    private String processId;
    private int arrivalTime;
    private int burstTime;
    private int waitingTime;
    private int turnaroundTime;

    /**
     * Constructs a Process object.
     *
     * @param processId   The unique identifier for the process (e.g., "P1").
     * @param arrivalTime The time at which the process arrives.
     * @param burstTime   The CPU time required by the process.
     */
    public Process(String processId, int arrivalTime, int burstTime) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

    /**
     * Gets the process ID.
     *
     * @return The process ID.
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * Sets the process ID.
     *
     * @param processId The process ID.
     */
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    /**
     * Gets the arrival time.
     *
     * @return The arrival time.
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the arrival time.
     *
     * @param arrivalTime The arrival time.
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets the burst time.
     *
     * @return The burst time.
     */
    public int getBurstTime() {
        return burstTime;
    }

    /**
     * Sets the burst time.
     *
     * @param burstTime The burst time.
     */
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    /**
     * Gets the waiting time.
     *
     * @return The waiting time.
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * Sets the waiting time.
     *
     * @param waitingTime The waiting time.
     */
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    /**
     * Gets the turnaround time.
     *
     * @return The turnaround time.
     */
    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    /**
     * Sets the turnaround time.
     *
     * @param turnaroundTime The turnaround time.
     */
    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    /**
     * Returns a string representation of the Process.
     *
     * @return A string containing the process information.
     */
    @Override
    public String toString() {
        return "Process{" +
                "ID='" + processId + '\'' +
                ", Arrival=" + arrivalTime +
                ", Burst=" + burstTime +
                ", Waiting=" + waitingTime +
                ", Turnaround=" + turnaroundTime +
                '}';
    }
}