package priority_ques;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Create an instance of the priority queue
        priorityQueue queue = new priorityQueue();

        try (
            // Open and read the file (change path if necessary)
            BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\user\\eclipse-workspace\\priority_ques\\src\\tasks.txt")
            )
        ) {
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Split line into parts: task_id, description, priority, duration
                String[] parts = line.split(",", 4);

                // Skip any invalid lines
                if (parts.length < 4) {
                    System.err.println("Invalid line: " + line);
                    continue;
                }

                // Parse task information from string to appropriate types
                int taskId = Integer.parseInt(parts[0].trim());
                String description = parts[1].trim();
                int priority = Integer.parseInt(parts[2].trim());
                int duration = Integer.parseInt(parts[3].trim());

                // create a Node object from parsed data
                Node task = new Node(taskId, description, priority, duration);

                // insert the task into the priority queue
                queue.insert(task);
            }

            // print the formatted table header
            System.out.printf("%-10s %-10s %-25s %-10s %-15s%n",
                    "[Order]", "[Task ID]", "[Task Description]", "[Priority]", "[Duration(min)]");

         // loop to print and delete tasks in sorted priority order
            int order = 1;
            while (!queue.isEmpty()) {
                Node n = queue.delete(); // remove task with highest priority (lowest number)
                System.out.printf("%-10d %-10d %-25s %-10d %-15d%n",
                        order++, n.getTask_Id(), n.getTask_Description(),
                        n.getPriority(), n.getDuration());
            }


        } catch (IOException e) {
            // print error if the file cannot be read
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}



