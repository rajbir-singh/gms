package com.gms.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository  extends CrudRepository<Dummy, String> {

}
