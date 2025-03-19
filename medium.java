import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Employee{
 private String name;
 private String id ;
 private int age;
 private double salary;
 public Employee(String name, String id, int age, double salary){
 this.name = name;
 this.id = id;
 this.age = age;
 this.salary = salary;
 }
 public String getName(){
 return name;
 }
 public String getId(){
 return id;
 }
 public int getAge(){
 return age;
 }
 public double getSalary(){
 return salary;
 }
 @Override
 public String toString() {
 return String.format("[ID: %s] %-10s | Age: %d | Salary: ₹%.2f", id, name, age,
salary);
 }
}
public class EmployeeSort {
 public static void main(String[] args) {
 List<Employee> emp = Arrays.asList(
 new Employee("Ansh Panwar", "11111", 26, 10000.0),
 new Employee("Naitik Raj", "2222", 21, 11000.0),
 new Employee("Sachin Singh Rathore", "33333", 22, 11000.0),
 new Employee("Shubham Pandey", "4444", 19, 12000.0)
 );
 emp.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
 System.out.println("Employees sorted by Salary:");
 emp.forEach(System.out::println);
 emp.sort((e1, e2) -> e1.getId().compareTo(e2.getId()));
 System.out.println("\nEmployees sorted by ID:");
 emp.forEach(System.out::println);
 emp.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
 System.out.println("\nEmployees sorted by Age:");
 emp.forEach(System.out::println);
 }
}
