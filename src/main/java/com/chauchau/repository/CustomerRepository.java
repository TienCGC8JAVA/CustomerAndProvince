package com.chauchau.repository;

import com.chauchau.model.Customer;
import com.chauchau.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  Iterable<Customer> findAllByProvince(Province province);

}
