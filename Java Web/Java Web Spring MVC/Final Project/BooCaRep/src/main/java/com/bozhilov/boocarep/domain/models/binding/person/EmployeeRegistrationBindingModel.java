package com.bozhilov.boocarep.domain.models.binding.person;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

import static com.bozhilov.boocarep.utils.Constants.*;

public class EmployeeRegistrationBindingModel extends BasePersonBindingModel{

    private String department;
    private String jobTitle;
    private BigDecimal hourlyPay;



    @NotNull
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @NotNull(message = JOB_TITLE_CANNOT_BE_EMPTY_MESSAGE)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @DecimalMin(value = EMPLOYEE_MIN_HOURLY_PAY, message = "Invalid number.")
    public BigDecimal getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(BigDecimal hourlyPay) {
        this.hourlyPay = hourlyPay;
    }
}
