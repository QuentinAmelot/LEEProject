/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Fayize Kaimou
 */
@Entity
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findByIdCours", query = "SELECT c FROM Cours c WHERE c.idCours = :idCours"),
    @NamedQuery(name = "Cours.findByNom", query = "SELECT c FROM Cours c WHERE c.nom = :nom"),
    @NamedQuery(name = "Cours.findByHeureDebut", query = "SELECT c FROM Cours c WHERE c.heureDebut = :heureDebut"),
    @NamedQuery(name = "Cours.findByHeureFin", query = "SELECT c FROM Cours c WHERE c.heureFin = :heureFin")})
public class Cours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCours")
    private Long idCours;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heureFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;
    @OneToMany(mappedBy = "idCours")
    private Collection<Enseignement> enseignementCollection;
    @JoinColumn(name = "idEnseignement", referencedColumnName = "idEnseignement")
    @ManyToOne(optional = false)
    private Enseignement idEnseignement;

    public Cours() {
    }

    public Cours(Long idCours) {
        this.idCours = idCours;
    }

    public Cours(Long idCours, String nom, Date heureDebut, Date heureFin) {
        this.idCours = idCours;
        this.nom = nom;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public Long getIdCours() {
        return idCours;
    }

    public void setIdCours(Long idCours) {
        this.idCours = idCours;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    @XmlTransient
    public Collection<Enseignement> getEnseignementCollection() {
        return enseignementCollection;
    }

    public void setEnseignementCollection(Collection<Enseignement> enseignementCollection) {
        this.enseignementCollection = enseignementCollection;
    }

    public Enseignement getIdEnseignement() {
        return idEnseignement;
    }

    public void setIdEnseignement(Enseignement idEnseignement) {
        this.idEnseignement = idEnseignement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCours != null ? idCours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.idCours == null && other.idCours != null) || (this.idCours != null && !this.idCours.equals(other.idCours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cours[ idCours=" + idCours + " ]";
    }
    
}
