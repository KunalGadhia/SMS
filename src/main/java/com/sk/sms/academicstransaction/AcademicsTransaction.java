/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.academicstransaction;

import java.util.Objects;

/**
 *
 * @author user
 */
public class AcademicsTransaction {

    private Integer id;
    private Integer studentId;
    private Integer subjectId;
    private Float unitTest1;
    private Float unitTest2;
    private Float midTerm;
    private Float unitTest3;
    private Float unitTest4;
    private Float finalTerm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public float getUnitTest1() {
        return unitTest1;
    }

    public void setUnitTest1(float unitTest1) {
        this.unitTest1 = unitTest1;
    }

    public float getUnitTest2() {
        return unitTest2;
    }

    public void setUnitTest2(Float unitTest2) {
        this.unitTest2 = unitTest2;
    }

    public float getMidTerm() {
        return midTerm;
    }

    public void setMidTerm(Float midTerm) {
        this.midTerm = midTerm;
    }

    public float getUnitTest3() {
        return unitTest3;
    }

    public void setUnitTest3(Float unitTest3) {
        this.unitTest3 = unitTest3;
    }

    public float getUnitTest4() {
        return unitTest4;
    }

    public void setUnitTest4(Float unitTest4) {
        this.unitTest4 = unitTest4;
    }

    public float getFinalTerm() {
        return finalTerm;
    }

    public void setFinalTerm(Float finalTerm) {
        this.finalTerm = finalTerm;
    }

    @Override
    public String toString() {
        return "AcademicsTransaction{" + "id=" + id + ", studentId=" + studentId + ", subjectId=" + subjectId + ", unitTest1=" + unitTest1 + ", unitTest2=" + unitTest2 + ", midTerm=" + midTerm + ", unitTest3=" + unitTest3 + ", unitTest4=" + unitTest4 + ", finalTerm=" + finalTerm + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.studentId);
        hash = 73 * hash + Objects.hashCode(this.subjectId);
        hash = 73 * hash + Float.floatToIntBits(this.unitTest1);
        hash = 73 * hash + Float.floatToIntBits(this.unitTest2);
        hash = 73 * hash + Float.floatToIntBits(this.midTerm);
        hash = 73 * hash + Float.floatToIntBits(this.unitTest3);
        hash = 73 * hash + Float.floatToIntBits(this.unitTest4);
        hash = 73 * hash + Float.floatToIntBits(this.finalTerm);
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
        final AcademicsTransaction other = (AcademicsTransaction) obj;
        if (Float.floatToIntBits(this.unitTest1) != Float.floatToIntBits(other.unitTest1)) {
            return false;
        }
        if (Float.floatToIntBits(this.unitTest2) != Float.floatToIntBits(other.unitTest2)) {
            return false;
        }
        if (Float.floatToIntBits(this.midTerm) != Float.floatToIntBits(other.midTerm)) {
            return false;
        }
        if (Float.floatToIntBits(this.unitTest3) != Float.floatToIntBits(other.unitTest3)) {
            return false;
        }
        if (Float.floatToIntBits(this.unitTest4) != Float.floatToIntBits(other.unitTest4)) {
            return false;
        }
        if (Float.floatToIntBits(this.finalTerm) != Float.floatToIntBits(other.finalTerm)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.subjectId, other.subjectId)) {
            return false;
        }
        return true;
    }

}
