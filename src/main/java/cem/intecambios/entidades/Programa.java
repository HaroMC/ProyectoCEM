/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.intecambios.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "PROGRAMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p")
    , @NamedQuery(name = "Programa.findByCodigo", query = "SELECT p FROM Programa p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Programa.findByNombre", query = "SELECT p FROM Programa p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Programa.findByFechaInicio", query = "SELECT p FROM Programa p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Programa.findByFechaTermino", query = "SELECT p FROM Programa p WHERE p.fechaTermino = :fechaTermino")
    , @NamedQuery(name = "Programa.findByValor", query = "SELECT p FROM Programa p WHERE p.valor = :valor")
    , @NamedQuery(name = "Programa.findByEstado", query = "SELECT p FROM Programa p WHERE p.estado = :estado")})
public class Programa implements Serializable {

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
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_TERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPrograma")
    private List<PostulacionesAlumnos> postulacionesAlumnosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPrograma")
    private List<PostulacionesCel> postulacionesCelList;
    @JoinColumn(name = "COD_ASIGNATURA", referencedColumnName = "CODIGO")
    @ManyToOne
    private Asignatura codAsignatura;

    public Programa() {
    }

    public Programa(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Programa(BigDecimal codigo, String nombre, int valor, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
        this.estado = estado;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<PostulacionesAlumnos> getPostulacionesAlumnosList() {
        return postulacionesAlumnosList;
    }

    public void setPostulacionesAlumnosList(List<PostulacionesAlumnos> postulacionesAlumnosList) {
        this.postulacionesAlumnosList = postulacionesAlumnosList;
    }

    @XmlTransient
    public List<PostulacionesCel> getPostulacionesCelList() {
        return postulacionesCelList;
    }

    public void setPostulacionesCelList(List<PostulacionesCel> postulacionesCelList) {
        this.postulacionesCelList = postulacionesCelList;
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
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.Programa[ codigo=" + codigo + " ]";
    }
    
}
