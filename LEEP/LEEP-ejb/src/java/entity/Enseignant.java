/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fayize Kaimou
 */
@Entity
@Table(name = "enseignant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    @NamedQuery(name = "Enseignant.findByIdEnseignant", query = "SELECT e FROM Enseignant e WHERE e.idEnseignant = :idEnseignant")})
public class Enseignant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEnseignant")
    private Long idEnseignant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEnseignant")
    private Collection<Enseignement> enseignementCollection;
    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne")
    @OneToOne(optional = false)
    private Personne idPersonne;

    public Enseignant() {
    }

    public Enseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    @XmlTransient
    public Collection<Enseignement> getEnseignementCollection() {
        return enseignementCollection;
    }

    public void setEnseignementCollection(Collection<Enseignement> enseignementCollection) {
        this.enseignementCollection = enseignementCollection;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnseignant != null ? idEnseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.idEnseignant == null && other.idEnseignant != null) || (this.idEnseignant != null && !this.idEnseignant.equals(other.idEnseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Enseignant[ idEnseignant=" + idEnseignant + " ]";
    }
    
}
