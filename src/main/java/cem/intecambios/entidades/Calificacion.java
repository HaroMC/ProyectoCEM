/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.intecambios.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "CALIFICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByCodigo", query = "SELECT c FROM Calificacion c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Calificacion.findByFechaCalificacion", query = "SELECT c FROM Calificacion c WHERE c.fechaCalificacion = :fechaCalificacion")
    , @NamedQuery(name = "Calificacion.findByNota", query = "SELECT c FROM Calificacion c WHERE c.nota = :nota")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private BigDecimal codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CALIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCalificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTA")
    private BigDecimal nota;
    @JoinColumn(name = "RUT_ALUMNO", referencedColumnName = "RUT_PERSONA")
    @ManyToOne(optional = false)
    private Alumno rutAlumno;
    @JoinColumn(name = "COD_ASIGNATURA", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Asignatura codAsignatura;

    public Calificacion() {
    }

    public Calificacion(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Calificacion(BigDecimal codigo, Date fechaCalificacion, BigDecimal nota) {
        this.codigo = codigo;
        this.fechaCalificacion = fechaCalificacion;
        this.nota = nota;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(Date fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Alumno getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(Alumno rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public Asignatura getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignatura codAsignatura) {
        this.codAsignatura = codAsignatura;
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
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.Calificacion[ codigo=" + codigo + " ]";
    }
    
}
