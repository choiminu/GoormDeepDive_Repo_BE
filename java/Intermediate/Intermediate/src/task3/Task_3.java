package task3;

public class Task_3 {
    public static void main(String[] args) {
        Employee employee = new Employee("민우", 2000000, "일반");
        System.out.println(employee);

        Manager manager = new Manager("김관리", 20, "관리자", 30);
        System.out.println(manager);

        manager.salaryIncrease(employee);
        System.out.println(employee);
    }
}

class Employee {
    String name;
    int salary;
    String rank;

    public Employee(String name, int salary, String rank) {
        this.name = name;
        this.salary = salary;
        this.rank = rank;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", rank='" + rank + '\'' +
                '}';
    }
}

class Manager extends Employee{
    int headCount;

    public Manager(String name, int salary, String rank, int headCount) {
        super(name, salary, rank);
        this.headCount = headCount;
    }

    public void salaryIncrease(Employee employee) {
        employee.setSalary(employee.getSalary() * 2);
    }
}
