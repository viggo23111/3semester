package dtos;

import entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDTO {
    long id;
    String name;
    String address;

    public EmployeeDTO(Employee employee) {
        this.id= employee.getId();
        this.name =employee.getName();
        this.address = employee.getAddress();
    }

    public static List<EmployeeDTO> getDTOs(List<Employee> employees){
        return employees.stream().map(employee -> new EmployeeDTO(employee)).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
