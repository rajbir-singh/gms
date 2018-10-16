package com.gms.mysql;

import com.gms.domain.Account;
import lombok.AllArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
class AccountWithEmail implements Specification<Account> {

    private String email;

    public Predicate toPredicate(Root<Account> root, CriteriaQuery query, CriteriaBuilder cb) {
        if (email == null) {
            return cb.isTrue(cb.literal(true)); // always true = no filtering
        }
        return cb.equal(root.get("email"), this.email);
    }
}



