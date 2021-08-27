import java.util.Arrays;
import java.util.Comparator;

class PersonComparator implements Comparator<Person>{
	@Override
	public int compare(Person o1, Person o2) {
		int res = o1.getName().compareTo(o2.getName());
		if (res != 0)
            return res;
        return o1.getAge()- o2.getAge();
	}
	
}
class EmployeeComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		int res = o1.getName().compareTo(o2.getName());
		if (res != 0)
            return res;
        int res2 = o1.getAge() - o2.getAge();
        if (res2 != 0)
            return res2;
        return Double.compare(o1.getSalary(), o2.getSalary());
	}
	
}
class DeveloperComparator implements Comparator<Developer>{
	@Override
	public int compare(Developer o1, Developer o2) {
		int res = o1.getName().compareTo(o2.getName());
		if (res != 0)
            return res;
        int res2 = o1.getAge()- o2.getAge();
        if (res2 != 0)
            return res2;
        int res3 = Double.compare(o1.getSalary(), o2.getSalary());
        if (res3 != 0)
            return res3;
        return o1.getLevel().compareTo(o2.getLevel());
	}
	
}

class Utility {
	 public static <T extends Person> void sortPeople(T[] arr,  Comparator<T> comp) {
		 Arrays.sort(arr, comp);
	 }
	 public static <T>  void sortPeople(T[] arr,  Comparator<? super T> comp) {
		 Arrays.sort(arr, comp);
	 }
 
}
