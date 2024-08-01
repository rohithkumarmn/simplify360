package Question1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TaskManager {
	
	private Map<String , Task> taskMap;

	public TaskManager() {
		this.taskMap = new HashMap<>();
	
	}
	
	public void addTask(String id,int duration) {
		taskMap.put(id, new Task(id,duration));
	}
	
	public void addPrerequisite(String taskId,String prerequisiteId) {
		Task task = taskMap.get(taskId);
		Task prerequisite = taskMap.get(prerequisiteId);
		if (task != null && prerequisite != null) {
			task.addPrerequisites(prerequisite);
			
		}
	}
	
	public void computeEarliestCompletionTimes() {
		Queue<Task> queue = new LinkedList<>();
		for(Task task : taskMap.values()) {
			if (task.prerequisites.isEmpty()) {
				task.earliestCompletion = task.duration;
				queue.add(task);
			}
		}
		
		while (!queue.isEmpty()) {
			Task current = queue.poll();
			for(Task nextTask : taskMap.values()) {
				if (nextTask.prerequisites.contains(current)) {
					nextTask.earliestCompletion = Math.max(nextTask.earliestCompletion, current.earliestCompletion + nextTask.duration);
					queue.add(nextTask);
				}
			}
		}
	}
	
	public void computeLatestCompletionTimes() {
        int projectCompletionTime = 0;
        for (Task task : taskMap.values()) {
            projectCompletionTime = Math.max(projectCompletionTime, task.earliestCompletion);
        }

        Queue<Task> queue = new LinkedList<>(taskMap.values());
        while (!queue.isEmpty()) {
            Task current = queue.poll();
            if (current.latestCompletion == 0) {
                current.latestCompletion = projectCompletionTime;
            }
            for (Task prerequisite : current.prerequisites) {
                prerequisite.latestCompletion = Math.min(prerequisite.latestCompletion, current.latestCompletion - prerequisite.duration);
                queue.add(prerequisite);
            }
        }
    }

    public Map<String, Task> getTaskMap() {
        return taskMap;
    }
	
	
}
