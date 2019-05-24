package com.senai.wsquickfood.model;

import java.io.Serializable;

public class Tbingrediente implements Serializable {
    
    private int dbID;    
    private String bdNome; 
    private int quantidade; 

    public Tbingrediente() {
    }

    public Tbingrediente(int dbID) {
        this.dbID = dbID;
    }

    public Tbingrediente(int dbID, String bdNome) {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
        
    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbingrediente[ dbID=" + dbID + " ]";
    }
    
}