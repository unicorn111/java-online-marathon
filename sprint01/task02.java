Employee emp1 = new Employee();
emp1.fullName = "Bob";
emp1.salary = 200.1f;
Employee emp2 = new Employee();
emp2.fullName = "Kate";
emp2.salary = 300.1f;
Employee[] employees = {emp1, emp2};
String employeesInfo = "";
for(int i=0; i<2; i++){
    String info = "{fullName: \"" + employees[i].fullName + "\", salary: " + 
    employees[i].salary + "}";
    if(i==0){
        employeesInfo += "[";
        employeesInfo += info;
         employeesInfo += ", ";
    }
    else{
        employeesInfo += info;
         employeesInfo += "]";
    }
}
