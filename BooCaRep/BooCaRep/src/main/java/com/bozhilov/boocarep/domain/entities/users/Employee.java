package com.bozhilov.boocarep.domain.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static com.bozhilov.boocarep.utils.Constants.EMPLOYEE_MIN_HOURLY_PAY;

@Entity
@Table(name="employees")
public class Employee extends BasePerson {
    private String department;
    private String jobTitle;
    private BigDecimal hourlyPay;

    @NotNull
    @Column(name="department", nullable=false)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @NotNull
    @Column(name="job_title", nullable = false)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @DecimalMin(EMPLOYEE_MIN_HOURLY_PAY)
    public BigDecimal getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(BigDecimal hourlyPay) {
        this.hourlyPay = hourlyPay;
    }
}
