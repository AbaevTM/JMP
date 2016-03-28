package com.epam.jmp.tabayeu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * User group entity. User belongs only to single group.
 * @author Tsimur_Abayeu
 *
 */
@Table(schema="banking", name="user_group")
public class UserGroup {

    @Id
    @Column(name = "group_id")
    @SequenceGenerator(name = "bank.group_seq", sequenceName = "bank.group_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bank.group_seq")
    private long id;

    @OneToMany(mappedBy="owner")
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
