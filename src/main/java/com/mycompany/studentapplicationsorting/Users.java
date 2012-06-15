/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentapplicationsorting;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author intesar mohammed
 */
public class Users implements Comparable<Users> {

    private String name;
    private String dob;
    private String phoneNo;
    private String email;
    private Integer age;

    /**
     * simple age calculator
     * @param email
     * @return 
     */
    private int calculateAge(String email) {
        int age_ = 0;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date dateOfBirth = dateFormat.parse(email);
            
            Calendar dob_ = Calendar.getInstance();
            dob_.setTime(dateOfBirth);
            
            Calendar today = Calendar.getInstance();
            
            age_ = today.get(Calendar.YEAR) - dob_.get(Calendar.YEAR);
            if (today.get(Calendar.DAY_OF_YEAR) < dob_.get(Calendar.DAY_OF_YEAR)) {
                age_--;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return age_;
    }
    
    public Users(String name, String dob, String phoneNo, String email) {
        this.name = name;
        this.dob = dob;
        this.phoneNo = phoneNo;
        this.email = email;
        this.age = calculateAge(dob);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" + "name=" + name + ", age=" + age + ", phoneNo=" + phoneNo + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    public int compareTo(Users o) {
        return this.getAge().compareTo(o.getAge());
    }
}
