package com.epam.jmp.tabayeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(schema="banking", name="user_transaction")
public class UserTransaction {

    @Id
    @Column(name = "transaction_id")
    @SequenceGenerator(name = "bank.tr_seq", sequenceName = "bank.tr_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bank.tr_seq")
    private long id;

    @ManyToMany(mappedBy="group")
    private List<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
