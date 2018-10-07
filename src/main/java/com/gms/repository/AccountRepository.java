package com.gms.repository;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.gms.domain.Account;
import com.gms.dto.AccountNameDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
//    List<Account> findAll();

    Account findByAccountId(String accountId);


    @Query(name="AccountNameQuery", nativeQuery = true)
    List<AccountNameDto> findName();

//    @Query(name="AccountComplexQuery", nativeQuery = true)
//    AccountNameDto findDetail();


//    CrudRepository Interface
//    CrudRepository is an interface and extends Spring data Repository interface. CrudRepository provides generic CRUD operation on a repository for a specific type. It has generic methods for CRUD operation. To use CrudRepository we have to create our interface and extend CrudRepository. We need not to implement our interface, its implementation will be created automatically at runtime. Find some of CrudRepository methods.

//    <S extends T> S save(S entity): Saves and updates the current entity and returns that entity.
//    Optional<T> findById(ID primaryKey): Returns the entity for the given id.
//            Iterable<T> findAll(): Returns all entities.
//    long count(): Returns the count.
//    void delete(T entity): Deletes the given entity.
//    boolean existsById(ID primaryKey): Checks if the entity for the given id exists or not.
//
//    CrudRepository has subinterface as PagingAndSortingRepository that provide additional methods to retrieve entities using the pagination and sorting abstraction.
//
//    Custom Repository Methods
//    CrudRepository provides methods for generic CRUD operation and if we want to add custom methods in our interface that has extended CrudRepository, we can add in following ways.
//
//    a. We can start our query method names with find...By, read...By, query...By, count...By, and get...By. Before By we can add expression such as Distinct . After By we need to add property names of our entity.
//    b. To get data on the basis of more than one property we can concatenate property names using And and Or while creating method names.
//    c. If we want to use completely custom name for our method, we can use @Query annotation to write query.
//
//    Find the code snippet that is using the sample method name for the above scenarios.
//
//    List<Article> findByTitle(String title);
//    List<Article> findDistinctByCategory(String category);
//    List<Article> findByTitleAndCategory(String title, String category);
//
//    @Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
//    List<Article> fetchArticles(@Param("title") String title, @Param("category") String category);
//}
}

