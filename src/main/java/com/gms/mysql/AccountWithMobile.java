package com.gms.mysql;

import com.gms.domain.Account;
import lombok.AllArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
class AccountWithMobile implements Specification<Account> {

    private String mobile;

    public Predicate toPredicate(Root<Account> root, CriteriaQuery query, CriteriaBuilder cb) {
        if (mobile == null) {
            return cb.isTrue(cb.literal(true)); // always true = no filtering
        }
        return cb.equal(root.get("mobile"), this.mobile);
    }
}


