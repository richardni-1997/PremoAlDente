package Premo.PremoAlDente.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "startDate")
	private Date startDate;
	
	@Column(name = "endDate")
	private Date endDate;
	
	@Column(name = "active")
	private boolean active;

	public Employee(long employeeId, String name, String address, Date startDate, Date endDate, boolean active) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = active;
	}

	public Employee(String name, String address, Date startDate, Date endDate, boolean active) {
		this.name = name;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = active;
	}
	

	public Employee() {}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", address=" + address + ", startDate="
				+ startDate + ", endDate=" + endDate + ", active=" + active + "]";
	}
	
}
	
	