package com.netmind.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Student extends NetmindObject {

    private String idStudent;
    private String name;
    private String surname;
    private Integer age;
    private LocalDate dateOfBirth;

    public Student(String idStudent, String name, String surname, Integer age, LocalDate dateOfBirth) {
        super();
        this.idStudent = idStudent;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        result = prime * result + ((idStudent == null) ? 0 : idStudent.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (dateOfBirth == null) {
            if (other.dateOfBirth != null)
                return false;
        } else if (!dateOfBirth.equals(other.dateOfBirth))
            return false;
        if (idStudent == null) {
            if (other.idStudent != null)
                return false;
        } else if (!idStudent.equals(other.idStudent))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("idStudent=");
        builder.append(idStudent);
        builder.append(", name=");
        builder.append(name);
        builder.append(", surname=");
        builder.append(surname);
        builder.append(", age=");
        builder.append(age);
        builder.append(", dateOfBirth=");
        builder.append(dateOfBirth);
        builder.append("]");
        return builder.toString();
    }

    public String toTxtFile() {
		StringBuilder builder = new StringBuilder();
		builder.append(idStudent);
		builder.append(",");
		builder.append(name);
		builder.append(",");
		builder.append(surname);
		builder.append(",");
		builder.append(age);
		builder.append(",");
		builder.append(dateOfBirth);
		return builder.toString();
	}

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        setAge(calculateAge(dateOfBirth));
    }

    private int calculateAge(LocalDate dateOfBirth) {

        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(dateOfBirth.atStartOfDay(defaultZoneId).toInstant());
        Period edad = Period.between(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        return edad.getYears();
    }


}
