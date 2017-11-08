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
@Table(name = "DOCENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByRutPersona", query = "SELECT d FROM Docente d WHERE d.rutPersona = :rutPersona")
    , @NamedQuery(name = "Docente.findByEstado", query = "SELECT d FROM Docente d WHERE d.estado = :estado")
    , @NamedQuery(name = "Docente.findByObservaciones", query = "SELECT d FROM Docente d WHERE d.observaciones = :observaciones")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT_PERSONA")
    private Integer rutPersona;
    @Size(max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 250)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutDocente")
    private List<Asignatura> asignaturaList;
    @JoinColumn(name = "RUT_PERSONA", referencedColumnName = "RUT", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public Docente() {
    }

    public Docente(Integer rutPersona) {
        this.rutPersona = rutPersona;
    }

    public Integer getRutPersona() {
        return rutPersona;
    }

    public void setRutPersona(Integer rutPersona) {
        this.rutPersona = rutPersona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Asignatura> getAsignaturaList() {
        return asignaturaList;
    }

    public void setAsignaturaList(List<Asignatura> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.rutPersona == null && other.rutPersona != null) || (this.rutPersona != null && !this.rutPersona.equals(other.rutPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.Docente[ rutPersona=" + rutPersona + " ]";
    }
    
}
