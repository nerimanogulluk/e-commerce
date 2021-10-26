package com.eticaret.eticaret4.adminEntities;


import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String full_name;
    private String email;
    private String password;
    private boolean enabled;
    private int status;

    @OneToMany( mappedBy = "userRole", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}