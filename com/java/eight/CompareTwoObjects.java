package com.java.eight;

import java.util.*;
import java.util.stream.Stream;

public class CompareTwoObjects {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "RAM", "BLR");
        Employee e2 = new Employee(1, "SYAM", "PAT");
        Employee e3 = new Employee(1, "RADHE", "JBP");

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        System.out.println(list);
        // Sorting by name
        Comparator<Employee> nameComparator = Comparator.comparing(emp -> emp.getName());
        Collections.sort(list,nameComparator);
        System.out.println(list);

        //Find an Element in a List
        Employee e4 = new Employee(1, "RADHE", "JBP");
        boolean e4Exists = Stream.of(e4).anyMatch(e -> list.contains(e));
        if(e4Exists){
            System.out.println("Stream checking : Employee e4 exists in list");
        } else{
            System.out.println("Stream checking : Emp e4 does not exist in the emp list");
        }

    }
}

class Employee {
    int id;
    String name;
    String city;

    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
