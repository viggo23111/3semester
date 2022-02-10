package entites;

import javax.persistence.*;

@Entity
@Table(name = "employees", schema = "classicmodels", catalog = "")
public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;


    public Employee() {
    }

    public Employee(String lastName, String firstName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    @Id
//Add this below the @Id annotation in the Employee Entity class
    @GeneratedValue(strategy = GenerationType.TABLE,generator="s1")
    @TableGenerator(name="s1",table = "My_SEQ",
            initialValue = 2000,allocationSize = 25)
    @Column(name = "employeeNumber")



    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "officeCode")
    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @Basic
    @Column(name = "reportsTo")
    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Basic
    @Column(name = "jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employeeNumber != employee.employeeNumber) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (extension != null ? !extension.equals(employee.extension) : employee.extension != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (officeCode != null ? !officeCode.equals(employee.officeCode) : employee.officeCode != null) return false;
        if (reportsTo != null ? !reportsTo.equals(employee.reportsTo) : employee.reportsTo != null) return false;
        if (jobTitle != null ? !jobTitle.equals(employee.jobTitle) : employee.jobTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeNumber;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (officeCode != null ? officeCode.hashCode() : 0);
        result = 31 * result + (reportsTo != null ? reportsTo.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        return result;
    }
}
