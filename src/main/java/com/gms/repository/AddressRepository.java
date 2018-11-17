package com.gms.repository;

import com.gms.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long>, AddressRepositoryCustom {
//    List<Article> findByTitle(String title);
//    List<Article> findDistinctByCategory(String category);
//    List<Article> findByTitleAndCategory(String title, String category);
      public Address findByAddressId(Long addressId);
}


