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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "FAMILIA_ANFITRIONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamiliaAnfitriona.findAll", query = "SELECT f FROM FamiliaAnfitriona f")
    , @NamedQuery(name = "FamiliaAnfitriona.findByRutPersona", query = "SELECT f FROM FamiliaAnfitriona f WHERE f.rutPersona = :rutPersona")
    , @NamedQuery(name = "FamiliaAnfitriona.findByCantidadIntegrantes", query = "SELECT f FROM FamiliaAnfitriona f WHERE f.cantidadIntegrantes = :cantidadIntegrantes")
    , @NamedQuery(name = "FamiliaAnfitriona.findByEstado", query = "SELECT f FROM FamiliaAnfitriona f WHERE f.estado = :estado")})
public class FamiliaAnfitriona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT_PERSONA")
    private Integer rutPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_INTEGRANTES")
    private short cantidadIntegrantes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "RUT_PERSONA", referencedColumnName = "RUT", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutFamilia")
    private List<Antecedente> antecedenteList;

    public FamiliaAnfitriona() {
    }

    public FamiliaAnfitriona(Integer rutPersona) {
        this.rutPersona = rutPersona;
    }

    public FamiliaAnfitriona(Integer rutPersona, short cantidadIntegrantes, String estado) {
        this.rutPersona = rutPersona;
        this.cantidadIntegrantes = cantidadIntegrantes;
        this.estado = estado;
    }

    public Integer getRutPersona() {
        return rutPersona;
    }

    public void setRutPersona(Integer rutPersona) {
        this.rutPersona = rutPersona;
    }

    public short getCantidadIntegrantes() {
        return cantidadIntegrantes;
    }

    public void setCantidadIntegrantes(short cantidadIntegrantes) {
        this.cantidadIntegrantes = cantidadIntegrantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Antecedente> getAntecedenteList() {
        return antecedenteList;
    }

    public void setAntecedenteList(List<Antecedente> antecedenteList) {
        this.antecedenteList = antecedenteList;
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
        if (!(object instanceof FamiliaAnfitriona)) {
            return false;
        }
        FamiliaAnfitriona other = (FamiliaAnfitriona) object;
        if ((this.rutPersona == null && other.rutPersona != null) || (this.rutPersona != null && !this.rutPersona.equals(other.rutPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.FamiliaAnfitriona[ rutPersona=" + rutPersona + " ]";
    }
    
}
