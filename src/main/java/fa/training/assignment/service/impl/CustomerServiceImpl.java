package fa.training.assignment.service.impl;

import fa.training.assignment.entity.Customer;
import fa.training.assignment.repository.CustomerRepository;
import fa.training.assignment.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getList() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getAllCustomerInformation() {
        return customerRepository.getAllCustomerInformation();
    }
}
