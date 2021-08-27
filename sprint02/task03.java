import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Person {
    private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
class Student extends Person {
	private String studyPlace;
    private int studyYears;
    
    public Student(String name, String studyPlace, int studyYears) {
		super(name);
		this.studyPlace = studyPlace;
		this.studyYears = studyYears;
	}
    
	public String getStudyPlace() {
		return studyPlace;
	}
	public void setStudyPlace(String studyPlace) {
		this.studyPlace = studyPlace;
	}
	public int getStudyYears() {
		return studyYears;
	}
	public void setStudyYears(int studyYears) {
		this.studyYears = studyYears;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((studyPlace == null) ? 0 : studyPlace.hashCode());
		result = prime * result + studyYears;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studyPlace == null) {
			if (other.studyPlace != null)
				return false;
		} else if (!studyPlace.equals(other.studyPlace))
			return false;
		if (studyYears != other.studyYears)
			return false;
		return true;
	}
}
class Worker extends Person {
    private String workPosition;
    private int experienceYears;
    
	public Worker(String name, String workPosition, int experienceYears) {
		super(name);
		this.workPosition = workPosition;
		this.experienceYears = experienceYears;
	}
	public String getWorkPosition() {
		return workPosition;
	}
	public void setWorkPosition(String workPosition) {
		this.workPosition = workPosition;
	}
	public int getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + experienceYears;
		result = prime * result + ((workPosition == null) ? 0 : workPosition.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (experienceYears != other.experienceYears)
			return false;
		if (workPosition == null) {
			if (other.workPosition != null)
				return false;
		} else if (!workPosition.equals(other.workPosition))
			return false;
		return true;
	}
	
}

class MyUtils {
    public List<Person> maxDuration(List<Person> persons) {
    	if (persons.isEmpty()) {
    		return persons;
    	}
    	List<Person> new_persons = new ArrayList<Person>();
    	List<Worker> workers = new ArrayList<Worker>();
    	List<Student> students = new ArrayList<Student>();
    	Set<Person> set = new HashSet<Person>();
    	for(int i=0; i<persons.size(); i++) {
    		set.add(persons.get(i));
    	}
    	if(set.size() == 1) {
    		new_persons.add(set.iterator().next());
    		return new_persons;
    	}
    	for(Person p: set) {
    		if (p instanceof Worker) {
    			workers.add((Worker)p);
    		}
    		else if (p instanceof Student) {
    			students.add((Student)p);
    		}
    		else {
    			continue;
    		}
    	}
    	if(students.isEmpty() && workers.isEmpty()) {
    		return new_persons;
    	}
    	Collections.sort(workers, new Comparator<Worker>() {
        	public int compare(Worker o1, Worker o2) {
        		return Integer.compare(o2.getExperienceYears(), o1.getExperienceYears());
            }
        });
    	Collections.sort(students, new Comparator<Student>() {
        	public int compare(Student o1, Student o2) {
        		return Integer.compare(o2.getStudyYears(), o1.getStudyYears());
            }
        });
    	int size = 0;
    	if (workers.size() == 1) {
    		new_persons.add(workers.get(0));
    	}
    	else {
    		new_persons.add((Person) workers.get(size));
        	while((size+1) < workers.size()) {
        		if(workers.get(size).getExperienceYears() == workers.get(size +1).getExperienceYears()) {
        			size +=1;
        			new_persons.add((Person) workers.get(size));
        		}
        		else {
        			break;
        		}
        	}
    	}
    	size = 0;
    	if (students.size() == 1) {
    		new_persons.add(students.get(0));
    	}
    	else {
    		new_persons.add((Person) students.get(size));
        	while((size+1) < students.size()) {
        		if(students.get(size).getStudyYears() == students.get(size +1).getStudyYears()) {
        			size +=1;
        			new_persons.add((Person) students.get(size));
        		}
        		else {
        			break;
        		}
        	}
    	}
    	return new_persons;
    	
    }
}
