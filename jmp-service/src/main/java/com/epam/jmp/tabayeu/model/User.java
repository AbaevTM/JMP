package com.epam.jmp.tabayeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

/**
 * User entity.
 *
 *
 * USER --- many to many --- TRANSACTION
 *  |
 *  |
 *  --------- many to one --- USER GROUP
 *
 *
 * @author Tsimur_Abayeu
 *
 */
@Table(schema="banking", name="bank_users")
public class User {

    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "bank.users_seq", sequenceName = "bank.users_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bank.users_seq")
    private long id;

    @ManyToMany
    @JoinTable(
        name="user_transactions",
        joinColumns=@JoinColumn(name="u_id", referencedColumnName="user_id"),
        inverseJoinColumns=@JoinColumn(name="tr_id", referencedColumnName="transaction_id"))
    private List<UserTransaction> transactions;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OWNER_ID")
    private UserGroup group;

    @Lob
    @Column(name="user_image")
    private byte[] image;

    @Column(name="user_first_name")
    private String firstName;

    @Column(name="user_last_name")
    private String lastName;

    //will be picked by default
    private String login;

    // Should not be stored
    @Transient
    private String email;

    public List<UserTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<UserTransaction> transactions) {
        this.transactions = transactions;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
}
