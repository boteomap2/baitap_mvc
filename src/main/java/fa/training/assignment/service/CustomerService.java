package fa.training.assignment.service;

import fa.training.assignment.entity.Customer;
import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    Customer getCustomerById(String id);
    List<Customer> getList();
    void deleteById(String id);
    List<Object[]> getAllCustomerInformation();
}
