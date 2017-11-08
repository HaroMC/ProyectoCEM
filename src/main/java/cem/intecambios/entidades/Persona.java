/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.intecambios.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByRut", query = "SELECT p FROM Persona p WHERE p.rut = :rut")
    , @NamedQuery(name = "Persona.findByNombreCompleto", query = "SELECT p FROM Persona p WHERE p.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByDomicilio", query = "SELECT p FROM Persona p WHERE p.domicilio = :domicilio")
    , @NamedQuery(name = "Persona.findByCiudad", query = "SELECT p FROM Persona p WHERE p.ciudad = :ciudad")
    , @NamedQuery(name = "Persona.findByPais", query = "SELECT p FROM Persona p WHERE p.pais = :pais")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")
    , @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Persona.findByTipo", query = "SELECT p FROM Persona p WHERE p.tipo = :tipo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT")
    private Integer rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PAIS")
    private String pais;
    @Size(max = 30)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 20)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPO")
    private String tipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private FamiliaAnfitriona familiaAnfitriona;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private CentroEstudiosLocal centroEstudiosLocal;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Alumno alumno;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rutPersona")
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
    private Docente docente;

    public Persona() {
    }

    public Persona(Integer rut) {
        this.rut = rut;
    }

    public Persona(Integer rut, String nombreCompleto, String domicilio, String ciudad, String pais, String tipo) {
        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tipo = tipo;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public FamiliaAnfitriona getFamiliaAnfitriona() {
        return familiaAnfitriona;
    }

    public void setFamiliaAnfitriona(FamiliaAnfitriona familiaAnfitriona) {
        this.familiaAnfitriona = familiaAnfitriona;
    }

    public CentroEstudiosLocal getCentroEstudiosLocal() {
        return centroEstudiosLocal;
    }

    public void setCentroEstudiosLocal(CentroEstudiosLocal centroEstudiosLocal) {
        this.centroEstudiosLocal = centroEstudiosLocal;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.Persona[ rut=" + rut + " ]";
    }
    
}
