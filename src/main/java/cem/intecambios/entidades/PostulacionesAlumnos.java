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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "POSTULACIONES_ALUMNOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostulacionesAlumnos.findAll", query = "SELECT p FROM PostulacionesAlumnos p")
    , @NamedQuery(name = "PostulacionesAlumnos.findByCodigo", query = "SELECT p FROM PostulacionesAlumnos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "PostulacionesAlumnos.findByFechaInscripcion", query = "SELECT p FROM PostulacionesAlumnos p WHERE p.fechaInscripcion = :fechaInscripcion")
    , @NamedQuery(name = "PostulacionesAlumnos.findByEstado", query = "SELECT p FROM PostulacionesAlumnos p WHERE p.estado = :estado")})
public class PostulacionesAlumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private BigDecimal codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INSCRIPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInscripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "RUT_ALUMNO", referencedColumnName = "RUT_PERSONA")
    @ManyToOne(optional = false)
    private Alumno rutAlumno;
    @JoinColumn(name = "COD_PROGRAMA", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Programa codPrograma;

    public PostulacionesAlumnos() {
    }

    public PostulacionesAlumnos(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public PostulacionesAlumnos(BigDecimal codigo, Date fechaInscripcion, String estado) {
        this.codigo = codigo;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Alumno getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(Alumno rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public Programa getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(Programa codPrograma) {
        this.codPrograma = codPrograma;
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
        if (!(object instanceof PostulacionesAlumnos)) {
            return false;
        }
        PostulacionesAlumnos other = (PostulacionesAlumnos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.PostulacionesAlumnos[ codigo=" + codigo + " ]";
    }
    
}
