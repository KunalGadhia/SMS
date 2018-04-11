/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.student;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Student {

    private Integer id;
    private String name;
    private String studentIdcardNumber;
    private Gender gender;
    private Integer stdCode;
    private Integer landlineNumber;
    private String mobileNumber;
    private String email;
    private Date dateOfBirth;
    private Integer classId;
    private String permanentAddress;
    private String currentAddress;
    private LivingWith livingWith;
    private Integer casteId;
    private MotherTongue motherTongue;
    private Religion religion;
    private String photoPath;
    private String attachments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentIdcardNumber() {
        return studentIdcardNumber;
    }

    public void setStudentIdcardNumber(String studentIdcardNumber) {
        this.studentIdcardNumber = studentIdcardNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getStdCode() {
        return stdCode;
    }

    public void setStdCode(Integer stdCode) {
        this.stdCode = stdCode;
    }

    public Integer getLandlineNumber() {
        return landlineNumber;
    }

    public void setLandlineNumber(Integer landlineNumber) {
        this.landlineNumber = landlineNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public LivingWith getLivingWith() {
        return livingWith;
    }

    public void setLivingWith(LivingWith livingWith) {
        this.livingWith = livingWith;
    }

    public Integer getCasteId() {
        return casteId;
    }

    public void setCasteId(Integer casteId) {
        this.casteId = casteId;
    }

    public MotherTongue getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(MotherTongue motherTongue) {
        this.motherTongue = motherTongue;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", studentIdcardNumber=" + studentIdcardNumber + ", gender=" + gender + ", stdCode=" + stdCode + ", landlineNumber=" + landlineNumber + ", mobileNumber=" + mobileNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", classId=" + classId + ", permanentAddress=" + permanentAddress + ", currentAddress=" + currentAddress + ", livingWith=" + livingWith + ", casteId=" + casteId + ", motherTongue=" + motherTongue + ", religion=" + religion + ", photoPath=" + photoPath + ", attachments=" + attachments + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.studentIdcardNumber);
        hash = 29 * hash + Objects.hashCode(this.gender);
        hash = 29 * hash + Objects.hashCode(this.stdCode);
        hash = 29 * hash + Objects.hashCode(this.landlineNumber);
        hash = 29 * hash + Objects.hashCode(this.mobileNumber);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 29 * hash + Objects.hashCode(this.classId);
        hash = 29 * hash + Objects.hashCode(this.permanentAddress);
        hash = 29 * hash + Objects.hashCode(this.currentAddress);
        hash = 29 * hash + Objects.hashCode(this.livingWith);
        hash = 29 * hash + Objects.hashCode(this.casteId);
        hash = 29 * hash + Objects.hashCode(this.motherTongue);
        hash = 29 * hash + Objects.hashCode(this.religion);
        hash = 29 * hash + Objects.hashCode(this.photoPath);
        hash = 29 * hash + Objects.hashCode(this.attachments);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.studentIdcardNumber, other.studentIdcardNumber)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.permanentAddress, other.permanentAddress)) {
            return false;
        }
        if (!Objects.equals(this.currentAddress, other.currentAddress)) {
            return false;
        }
        if (!Objects.equals(this.photoPath, other.photoPath)) {
            return false;
        }
        if (!Objects.equals(this.attachments, other.attachments)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.stdCode, other.stdCode)) {
            return false;
        }
        if (!Objects.equals(this.landlineNumber, other.landlineNumber)) {
            return false;
        }
        if (!Objects.equals(this.mobileNumber, other.mobileNumber)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.classId, other.classId)) {
            return false;
        }
        if (this.livingWith != other.livingWith) {
            return false;
        }
        if (!Objects.equals(this.casteId, other.casteId)) {
            return false;
        }
        if (this.motherTongue != other.motherTongue) {
            return false;
        }
        if (this.religion != other.religion) {
            return false;
        }
        return true;
    }

}
