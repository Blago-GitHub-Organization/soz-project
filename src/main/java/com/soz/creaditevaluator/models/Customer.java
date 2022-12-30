package com.soz.creaditevaluator.models;

import com.soz.creaditevaluator.models.customerenums.EducationLevel;
import com.soz.creaditevaluator.models.customerenums.EmploymentType;
import com.soz.creaditevaluator.models.customerenums.MaritalStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Customer
{
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String egn;
    private MaritalStatus maritalStatus;
    private EmploymentType employmentStatus;
    private EducationLevel educationLevel;
    private BigDecimal salary;
    private String address;
    private Integer fullWorkExperience;
    private Integer workExperienceWithCurrentEmployer;

    public Integer getFullWorkExperience()
    {
        return fullWorkExperience;
    }

    public void setFullWorkExperience(Integer fullWorkExperience)
    {
        this.fullWorkExperience = fullWorkExperience;
    }

    public Integer getWorkExperienceWithCurrentEmployer()
    {
        return workExperienceWithCurrentEmployer;
    }

    public void setWorkExperienceWithCurrentEmployer(Integer workExperienceWithCurrentEmployer)
    {
        this.workExperienceWithCurrentEmployer = workExperienceWithCurrentEmployer;
    }

    private String phoneNumber;

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getEgn()
    {
        return egn;
    }

    public void setEgn(String egn)
    {
        this.egn = egn;
    }

    public MaritalStatus getMaritalStatus()
    {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }

    public EmploymentType getEmploymentStatus()
    {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentType employmentStatus)
    {
        this.employmentStatus = employmentStatus;
    }

    public EducationLevel getEducationLevel()
    {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel)
    {
        this.educationLevel = educationLevel;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
