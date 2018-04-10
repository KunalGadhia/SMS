/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.sms.profession;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Profession {

    private Integer id;
    private String professionName;
    private String belongTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    @Override
    public String toString() {
        return "Profession{" + "id=" + id + ", professionName=" + professionName + ", belongTo=" + belongTo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.professionName);
        hash = 89 * hash + Objects.hashCode(this.belongTo);
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
        final Profession other = (Profession) obj;
        if (!Objects.equals(this.professionName, other.professionName)) {
            return false;
        }
        if (!Objects.equals(this.belongTo, other.belongTo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
