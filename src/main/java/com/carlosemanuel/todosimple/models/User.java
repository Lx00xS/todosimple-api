/*
* @Entity: indica que a classe é uma entidade JPA.
* JPA Entity: POJOs que representam dados e podem ser persistidos em bancos de dados.
* POJOs: objeto java trivial
* */
package com.carlosemanuel.todosimple.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public interface createUser{}
    public interface updateUser{}

    public static final String TABLE_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(groups = createUser.class)
    @NotEmpty(groups = createUser.class)
    @Size(groups = createUser.class, min = 2, max = 100)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name="password", length = 60, nullable = false)
    @NotNull(groups = {createUser.class, updateUser.class})
    @NotEmpty(groups = {createUser.class, updateUser.class})
    @Size(groups = {createUser.class, updateUser.class} , min = 8, max = 60)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tarefas = new ArrayList<Task>();

    public User(){}

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Task> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(o == null)
            return false;
        if(!(o instanceof User))
            return false;
        User other = (User) o;
        if(this.id == null)
            if(other.id != null)
                return false;
            else if(!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) && Objects.equals(this.password, other.password);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
}
