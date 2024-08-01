package Question1;

import java.util.Map;
import java.util.Scanner;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scanner = new Scanner(System.in);
		
		TaskManager taskManager = new TaskManager();
		
		System.out.println("Enter the number of tasks in the project: ");
		int numTasks = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter each task nd its duration (format: taskId duration): ");
		for(int i =0;i<numTasks;i++) {
			String taskId = scanner.next();
			int taskDuration = scanner.nextInt();
			taskManager.addTask(taskId, taskDuration);
		}
		
		System.out.println("Enter the number of relationship:");
		int numRelations = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Specify the task relationships (format: taskID prerequisiteTaskID):");
	    for (int i = 0; i < numRelations; i++) {
	    	String taskId = scanner.next();
	        String prerequisiteId = scanner.next();
	        taskManager.addPrerequisite(taskId, prerequisiteId);
	    }
	    
	    taskManager.computeEarliestCompletionTimes();
        taskManager.computeLatestCompletionTimes();

        for (Map.Entry<String, Task> entry : taskManager.getTaskMap().entrySet()) {
            Task task = entry.getValue();
            System.out.println("Task " + task.id + ": Earliest Completion = " + task.earliestCompletion + ", Latest Completion = " + task.latestCompletion);
        }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
