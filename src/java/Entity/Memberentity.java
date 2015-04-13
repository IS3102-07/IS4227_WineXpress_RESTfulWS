/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
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
 * @author admin
 */
@Entity
@Table(name = "memberentity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memberentity.findAll", query = "SELECT m FROM Memberentity m"),
    @NamedQuery(name = "Memberentity.findById", query = "SELECT m FROM Memberentity m WHERE m.id = :id"),
    @NamedQuery(name = "Memberentity.findByDob", query = "SELECT m FROM Memberentity m WHERE m.dob = :dob"),
    @NamedQuery(name = "Memberentity.findByEmail", query = "SELECT m FROM Memberentity m WHERE m.email = :email"),
    @NamedQuery(name = "Memberentity.findByIsdeleted", query = "SELECT m FROM Memberentity m WHERE m.isdeleted = :isdeleted"),
    @NamedQuery(name = "Memberentity.findByLastlogin", query = "SELECT m FROM Memberentity m WHERE m.lastlogin = :lastlogin"),
    @NamedQuery(name = "Memberentity.findByName", query = "SELECT m FROM Memberentity m WHERE m.name = :name")})
public class Memberentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ACTIVATIONCODE")
    private String activationcode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ISDELETED")
    private Boolean isdeleted;
    @Column(name = "LASTLOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "PASSWORDHASH")
    private String passwordhash;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "PASSWORDSALT")
    private String passwordsalt;
    @JoinColumn(name = "SHOPPINGCARTENTITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Shoppingcartentity shoppingcartentityId;

    public Memberentity() {
    }

    public Memberentity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getActivationcode() {
        return activationcode;
    }

    public void setActivationcode(String activationcode) {
        this.activationcode = activationcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public String getPasswordsalt() {
        return passwordsalt;
    }

    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt;
    }

    public Shoppingcartentity getShoppingcartentityId() {
        return shoppingcartentityId;
    }

    public void setShoppingcartentityId(Shoppingcartentity shoppingcartentityId) {
        this.shoppingcartentityId = shoppingcartentityId;
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
        if (!(object instanceof Memberentity)) {
            return false;
        }
        Memberentity other = (Memberentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Memberentity[ id=" + id + " ]";
    }
    
}
