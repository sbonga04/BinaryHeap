package priority_ques;

public class Node {

	private int task_id;
	private String task_description;
	private int priority;
	private int durationInMinutes;
	
	//Default constructor..|| here i'm coming back to edit this constructor
	Node(){						//or maybe instead of all these -1's just put 1
		this.task_id = -1;
		this.task_description = null;
		this.priority = -1;
		this.durationInMinutes = -1;
	}
	//Loaded constructor
	Node(int task_id,String task_description,int priority,int duration){
		this.task_id = task_id;
		this.task_description = task_description;
		this.priority = priority;
		this.durationInMinutes = duration;
		
	} //Getter methods
	
	public int getTask_Id() {
		return task_id;
	}
	
	public String getTask_Description() {
		return task_description;
	}
	
	public int getPriority() {
		return priority;
	}
	public int getDuration() {
		return durationInMinutes;
	}
	//Setter methods;
	
	public void setTask_Id(int task) {
		if (task < 0) {
			throw new IllegalArgumentException("Error: task_id should not be negative");
		}
		this.task_id = task;
	}
	
	public void setTask_Description(String task_description) {
		if (task_description == null) {
			System.err.println("Error: task description can not be empty");
			
		}
		this.task_description = task_description;
	}
	public void setPriority(int priority) {
		if (priority < 0) {
			System.err.println("Error: priority can not be negative");
		}
		this.priority = priority;
	}
	
	public void setDuration(int minutes) {
		if(minutes <= 0) {
			System.err.println("error!!! minutes can not be negative");
		}
		this.durationInMinutes = minutes;
	}	
	
}