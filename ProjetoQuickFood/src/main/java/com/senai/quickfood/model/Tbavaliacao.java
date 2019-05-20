package com.senai.quickfood.model;

import java.io.Serializable;

public class Tbavaliacao implements Serializable {

    private Integer bdID;
    private Integer bdNota;
    private Tbreceita bdFKReceita;
    private Tbusuario bdFKUsuario;

    public Tbavaliacao() {
    }

    public Tbavaliacao(Integer bdID) {
        this.bdID = bdID;
    }

    public Integer getBdID() {
        return bdID;
    }

    public void setBdID(Integer bdID) {
        this.bdID = bdID;
    }

    public Integer getBdNota() {
        return bdNota;
    }

    public void setBdNota(Integer bdNota) {
        this.bdNota = bdNota;
    }

    public Tbreceita getBdFKReceita() {
        return bdFKReceita;
    }

    public void setBdFKReceita(Tbreceita bdFKReceita) {
        this.bdFKReceita = bdFKReceita;
    }

    public Tbusuario getBdFKUsuario() {
        return bdFKUsuario;
    }

    public void setBdFKUsuario(Tbusuario bdFKUsuario) {
        this.bdFKUsuario = bdFKUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bdID != null ? bdID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbavaliacao)) {
            return false;
        }
        Tbavaliacao other = (Tbavaliacao) object;
        if ((this.bdID == null && other.bdID != null) || (this.bdID != null && !this.bdID.equals(other.bdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.senai.quickfood.dao.Tbavaliacao[ bdID=" + bdID + " ]";
    }
    
}
