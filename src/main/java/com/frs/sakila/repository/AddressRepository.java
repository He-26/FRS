package com.frs.sakila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frs.sakila.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
