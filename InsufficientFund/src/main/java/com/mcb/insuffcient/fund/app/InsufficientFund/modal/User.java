package com.mcb.insuffcient.fund.app.InsufficientFund.modal;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @NotBlank
    @Size(max = 20)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String buisnessUnit;

    @NotBlank
    @Size(max = 120)
    private String password;

    public User() {
    }

    public User(String username, String password, String name, String buisnessUnit) {
        this.username = username;
        this.password = password;
        this.buisnessUnit = buisnessUnit;
        this.name = name;
    }


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuisnessUnit() {
        return buisnessUnit;
    }

    public void setBuisnessUnit(String buisnessUnit) {
        this.buisnessUnit = buisnessUnit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
