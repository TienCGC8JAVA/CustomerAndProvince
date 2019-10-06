package com.chauchau.service.customer;

import com.chauchau.model.Customer;
import com.chauchau.model.Province;
import com.chauchau.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService extends GeneralService<Customer> {

  Iterable<Customer> findAllByProvince(Province province);

  Page<Customer> findAll(Pageable pageable);

  Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
