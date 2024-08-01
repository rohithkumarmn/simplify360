package Question1;

import java.util.ArrayList;
import java.util.List;

public class Task {
	
	String id;
	int duration;
	List<Task> prerequisites;
	int earliestCompletion;
	int latestCompletion;
	
	public Task(String id,int duration) {
		this.id = id;
		this.duration = duration;
		this.prerequisites = new ArrayList<>();
	}
	
	public void addPrerequisites(Task prerequisite) {
		this.prerequisites.add(prerequisite);
	}

}
