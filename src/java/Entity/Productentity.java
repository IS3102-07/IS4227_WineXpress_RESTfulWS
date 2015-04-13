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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "productentity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productentity.findAll", query = "SELECT p FROM Productentity p"),
    @NamedQuery(name = "Productentity.findById", query = "SELECT p FROM Productentity p WHERE p.id = :id"),
    @NamedQuery(name = "Productentity.findBySku", query = "SELECT p FROM Productentity p WHERE p.sku = :sku"),
    @NamedQuery(name = "Productentity.findByImageurl", query = "SELECT p FROM Productentity p WHERE p.imageurl = :imageurl"),
    @NamedQuery(name = "Productentity.findByIsdeleted", query = "SELECT p FROM Productentity p WHERE p.isdeleted = :isdeleted"),
    @NamedQuery(name = "Productentity.findByName", query = "SELECT p FROM Productentity p WHERE p.name = :name"),
    @NamedQuery(name = "Productentity.findByPrice", query = "SELECT p FROM Productentity p WHERE p.price = :price")})
public class Productentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "SKU")
    private String sku;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "IMAGEURL")
    private String imageurl;
    @Column(name = "ISDELETED")
    private Boolean isdeleted;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @JoinColumn(name = "CATEGORYENTITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Categoryentity categoryentityId;

    public Productentity() {
    }

    public Productentity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Categoryentity getCategoryentityId() {
        return categoryentityId;
    }

    public void setCategoryentityId(Categoryentity categoryentityId) {
        this.categoryentityId = categoryentityId;
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
        if (!(object instanceof Productentity)) {
            return false;
        }
        Productentity other = (Productentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Productentity[ id=" + id + " ]";
    }
    
}
