/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "lineitementity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineitementity.findAll", query = "SELECT l FROM Lineitementity l"),
    @NamedQuery(name = "Lineitementity.findById", query = "SELECT l FROM Lineitementity l WHERE l.id = :id"),
    @NamedQuery(name = "Lineitementity.findByQuantity", query = "SELECT l FROM Lineitementity l WHERE l.quantity = :quantity")})
public class Lineitementity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "PRODUCTENTITY_ID", referencedColumnName = "ID")
    @OneToOne
    private Productentity productentityId;

    public Lineitementity() {
    }

    public Lineitementity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Productentity getProductentityId() {
        return productentityId;
    }

    public void setProductentityId(Productentity productentityId) {
        this.productentityId = productentityId;
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
        if (!(object instanceof Lineitementity)) {
            return false;
        }
        Lineitementity other = (Lineitementity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Lineitementity[ id=" + id + " ]";
    }

}
