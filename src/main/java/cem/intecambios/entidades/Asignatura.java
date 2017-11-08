/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.intecambios.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ASIGNATURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findByCodigo", query = "SELECT a FROM Asignatura a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Asignatura.findByNombreAsignatura", query = "SELECT a FROM Asignatura a WHERE a.nombreAsignatura = :nombreAsignatura")
    , @NamedQuery(name = "Asignatura.findByDescripcion", query = "SELECT a FROM Asignatura a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Asignatura.findByCupos", query = "SELECT a FROM Asignatura a WHERE a.cupos = :cupos")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private BigDecimal codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE_ASIGNATURA")
    private String nombreAsignatura;
    @Size(max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "CUPOS")
    private Long cupos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<Calificacion> calificacionList;
    @OneToMany(mappedBy = "codAsignatura")
    private List<Programa> programaList;
    @JoinColumn(name = "RUT_DOCENTE", referencedColumnName = "RUT_PERSONA")
    @ManyToOne(optional = false)
    private Docente rutDocente;

    public Asignatura() {
    }

    public Asignatura(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Asignatura(BigDecimal codigo, String nombreAsignatura) {
        this.codigo = codigo;
        this.nombreAsignatura = nombreAsignatura;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCupos() {
        return cupos;
    }

    public void setCupos(Long cupos) {
        this.cupos = cupos;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    public Docente getRutDocente() {
        return rutDocente;
    }

    public void setRutDocente(Docente rutDocente) {
        this.rutDocente = rutDocente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.Asignatura[ codigo=" + codigo + " ]";
    }
    
}
