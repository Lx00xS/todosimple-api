/*
* Repositórios são camadas de persisteência de dados.
* Interfaces que definem quais métodos, relacionados à persistência de dados, são disponíveis.
* Interfaces that defines query methods.
*
* "In a typical Java application, you might expect to write a class that implements the repository.
* However, that is what makes Spring Data JPA so powerful: You need not write an implementation of the repository interface.
* Spring Data JPA creates an implementation when you run the application." (https://spring.io/guides/gs/accessing-data-jpa)
*/
package com.carlosemanuel.todosimple.repositories;

import com.carlosemanuel.todosimple.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
