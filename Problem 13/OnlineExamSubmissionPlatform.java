import java.util.*;

public class OnlineExamSubmissionPlatform {

    // Submission class holds student name, estimated execution time, and submission timestamp
    static class Submission {
        String student;
        long est;
        long subTime;

        Submission(String s, long e, long t) {
            student = s;
            est = e;
            subTime = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long deadline = 0, currentTime = 0;
        final long THRESHOLD = 5; // 5 minutes for starvation

        // PriorityQueue for Shortest Job First
        PriorityQueue<Submission> heap = new PriorityQueue<>(Comparator.comparingLong(s -> s.est));
        // FIFO queue for starved submissions
        Queue<Submission> fifo = new LinkedList<>();

        System.out.println("Online Exam Submission Platform Ready. Type commands (SET_DEADLINE, SUBMIT, PROCESS, STATUS).");

        // Main interactive loop
        while (true) {
            System.out.print("> "); // Prompt for user input

            // Use hasNext() instead of hasNextLine() to prevent freezing in VS CODE terminals
            if (!sc.hasNext()) break; // Exit if no input (EOF)

            String line = sc.nextLine().trim(); // Read and trim whitespace
            if (line.isEmpty()) continue;      // Ignore empty lines

            String[] p = line.split("\\s+"); // Split command and arguments
            String cmd = p[0];

            switch (cmd) {
                case "SET_DEADLINE":
                    if (p.length < 2) {
                        System.out.println("Error: SET_DEADLINE requires a timestamp.");
                        break;
                    }
                    try {
                        deadline = Long.parseLong(p[1]);
                        System.out.println("Deadline set to " + deadline);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid timestamp.");
                    }
                    break;

                case "SUBMIT":
                    if (p.length < 4) {
                        System.out.println("Error: SUBMIT requires student, est_time, and timestamp.");
                        break;
                    }
                    try {
                        String student = p[1];
                        long est = Long.parseLong(p[2]);
                        long ts = Long.parseLong(p[3]);
                        currentTime = Math.max(currentTime, ts); // simulated time

                        if (ts > deadline) {
                            System.out.println("Error: Rejected. Past Deadline.");
                            break;
                        }
                        heap.add(new Submission(student, est, ts));
                        System.out.println("Submission accepted: " + student);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid numbers in SUBMIT.");
                    }
                    break;

                case "PROCESS":
                    // Move starved submissions to FIFO
                    List<Submission> temp = new ArrayList<>();
                    List<Submission> starved = new ArrayList<>();
                    while (!heap.isEmpty()) {
                        Submission s = heap.poll();
                        if (currentTime - s.subTime > THRESHOLD) starved.add(s);
                        else temp.add(s);
                    }
                    heap.addAll(temp);
                    starved.sort(Comparator.comparingLong(s -> s.subTime));
                    fifo.addAll(starved);

                    Submission grade = null;
                    String reason = "";
                    if (!fifo.isEmpty()) {
                        grade = fifo.poll();
                        reason = " (Priority)";
                    } else if (!heap.isEmpty()) {
                        grade = heap.poll();
                        reason = " (Shortest)";
                    }

                    if (grade != null) {
                        System.out.println("Grading " + grade.student + reason);
                        currentTime += grade.est; // advance simulated time
                    } else {
                        System.out.println("No submissions to process.");
                    }
                    break;

                case "STATUS":
                    System.out.print("FIFO: ");
                    fifo.forEach(s -> System.out.print(s.student + " "));
                    System.out.println();
                    System.out.print("Heap: ");
                    List<Submission> heapList = new ArrayList<>(heap);
                    heapList.sort(Comparator.comparingLong(s -> s.est));
                    heapList.forEach(s -> System.out.print(s.student + " "));
                    System.out.println();
                    break;

                default:
                    System.out.println("Unknown command: " + cmd);
            }
        }

        sc.close();
        System.out.println("Program terminated.");
    }
}
