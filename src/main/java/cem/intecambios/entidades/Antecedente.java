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
import javax.persistence.Lob;
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
@Table(name = "ANTECEDENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedente.findAll", query = "SELECT a FROM Antecedente a")
    , @NamedQuery(name = "Antecedente.findByCodigo", query = "SELECT a FROM Antecedente a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Antecedente.findByDescripcion", query = "SELECT a FROM Antecedente a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Antecedente.findByFechaCaducidad", query = "SELECT a FROM Antecedente a WHERE a.fechaCaducidad = :fechaCaducidad")})
public class Antecedente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private BigDecimal codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @Lob
    @Column(name = "DOCUMENTO")
    private Serializable documento;
    @JoinColumn(name = "RUT_FAMILIA", referencedColumnName = "RUT_PERSONA")
    @ManyToOne(optional = false)
    private FamiliaAnfitriona rutFamilia;

    public Antecedente() {
    }

    public Antecedente(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Antecedente(BigDecimal codigo, String descripcion, Date fechaCaducidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCaducidad = fechaCaducidad;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Serializable getDocumento() {
        return documento;
    }

    public void setDocumento(Serializable documento) {
        this.documento = documento;
    }

    public FamiliaAnfitriona getRutFamilia() {
        return rutFamilia;
    }

    public void setRutFamilia(FamiliaAnfitriona rutFamilia) {
        this.rutFamilia = rutFamilia;
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
        if (!(object instanceof Antecedente)) {
            return false;
        }
        Antecedente other = (Antecedente) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cem.intecambios.entidades.Antecedente[ codigo=" + codigo + " ]";
    }
    
}
