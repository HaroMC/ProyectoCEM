/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.intecambios.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "CENTRO_ESTUDIOS_LOCAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroEstudiosLocal.findAll", query = "SELECT c FROM CentroEstudiosLocal c")
    , @NamedQuery(name = "CentroEstudiosLocal.findByRutPersona", query = "SELECT c FROM CentroEstudiosLocal c WHERE c.rutPersona = :rutPersona")
    , @NamedQuery(name = "CentroEstudiosLocal.findByEstaAcreditada", query = "SELECT c FROM CentroEstudiosLocal c WHERE c.estaAcreditada = :estaAcreditada")})
public class CentroEstudiosLocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT_PERSONA")
    private Integer rutPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTA_ACREDITADA")
    private short estaAcreditada;
    @JoinColumn(name = "RUT_PERSONA", referencedColumnName = "RUT", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutCel")
    private List<PostulacionesCel> postulacionesCelList;

    public CentroEstudiosLocal() {
    }

    public CentroEstudiosLocal(Integer rutPersona) {
        this.rutPersona = rutPersona;
    }

    public CentroEstudiosLocal(Integer rutPersona, short estaAcreditada) {
        this.rutPersona = rutPersona;
        this.estaAcreditada = estaAcreditada;
    }

    public Integer getRutPersona() {
        return rutPersona;
    }

    public void setRutPersona(Integer rutPersona) {
        this.rutPersona = rutPersona;
    }

    public short getEstaAcreditada() {
        return estaAcreditada;
    }

    public void setEstaAcreditada(short estaAcreditada) {
        this.estaAcreditada = estaAcreditada;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<PostulacionesCel> getPostulacionesCelList() {
        return postulacionesCelList;
    }

    public void setPostulacionesCelList(List<PostulacionesCel> postulacionesCelList) {
        this.postulacionesCelList = postulacionesCelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutPersona != null ? rutPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroEstudiosLocal)) {
            return false;
        }
        CentroEstudiosLocal other = (CentroEstudiosLocal) object;
        if ((this.rutPersona == null && other.rutPersona != null) || (this.rutPersona != null && !this.rutPersona.equals(other.rutPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.CentroEstudiosLocal[ rutPersona=" + rutPersona + " ]";
    }
    
}
