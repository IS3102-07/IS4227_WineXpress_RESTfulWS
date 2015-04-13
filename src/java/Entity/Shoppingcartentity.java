/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "shoppingcartentity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcartentity.findAll", query = "SELECT s FROM Shoppingcartentity s"),
    @NamedQuery(name = "Shoppingcartentity.findById", query = "SELECT s FROM Shoppingcartentity s WHERE s.id = :id")})
public class Shoppingcartentity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Lineitementity> lineitementityList;
    @OneToOne(mappedBy = "shoppingcartentityId")
    private Memberentity memberEntity;

    public Shoppingcartentity() {
        memberEntity = null;
        lineitementityList = new ArrayList<>();
    }

    public Shoppingcartentity(Long id) {
        this.id = id;
    }

    @XmlTransient
    public Memberentity getMemberEntity() {
        return memberEntity;
    }

    public void setMemberEntity(Memberentity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient
    public List<Lineitementity> getLineitementityList() {
        return lineitementityList;
    }

    public void setLineitementityList(List<Lineitementity> lineitementityList) {
        this.lineitementityList = lineitementityList;
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
        if (!(object instanceof Shoppingcartentity)) {
            return false;
        }
        Shoppingcartentity other = (Shoppingcartentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        } 
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Shoppingcartentity[ id=" + id + " ]";
    }

}
