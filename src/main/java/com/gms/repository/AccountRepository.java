package com.gms.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import com.gms.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}

