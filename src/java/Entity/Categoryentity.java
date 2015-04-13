/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author admin
 */
@Entity
@Table(name = "categoryentity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoryentity.findAll", query = "SELECT c FROM Categoryentity c"),
    @NamedQuery(name = "Categoryentity.findById", query = "SELECT c FROM Categoryentity c WHERE c.id = :id"),
    @NamedQuery(name = "Categoryentity.findByIsdeleted", query = "SELECT c FROM Categoryentity c WHERE c.isdeleted = :isdeleted")})
public class Categoryentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "ISDELETED")
    private Boolean isdeleted;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "categoryentityId")
    private List<Productentity> productentityList;

    public Categoryentity() {
    }

    public Categoryentity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Productentity> getProductentityList() {
        return productentityList;
    }

    public void setProductentityList(List<Productentity> productentityList) {
        this.productentityList = productentityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoryentity)) {
            return false;
        }
        Categoryentity other = (Categoryentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Categoryentity[ id=" + id + " ]";
    }
    
}
