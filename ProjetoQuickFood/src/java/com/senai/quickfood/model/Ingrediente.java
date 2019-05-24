package com.senai.quickfood.model;

import java.io.Serializable;

public class Ingrediente implements Serializable {
    
    private int dbID;    
    private String bdNome; 

    public Ingrediente() {
    }

    public Ingrediente(int dbID) {
        this.dbID = dbID;
    }

    public Ingrediente(int dbID, String bdNome) {
        this.dbID = dbID;
        this.bdNome = bdNome;
    }

    public int getDbID() {
        return dbID;
    }

    public void setDbID(int dbID) {
        this.dbID = dbID;
    }

    public String getBdNome() {
        return bdNome;
    }

    public void setBdNome(String bdNome) {
        this.bdNome = bdNome;
    }     

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingrediente[ dbID=" + dbID + " ]";
    }
    
}