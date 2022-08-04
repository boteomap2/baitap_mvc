package fa.training.assignment.controller;

import fa.training.assignment.entity.Customer;
import fa.training.assignment.service.CustomerService;
import fa.training.assignment.service.RegisterDeviceService;
import fa.training.assignment.service.RegisterServiceService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final RegisterDeviceService registerDeviceService;
    private final RegisterServiceService registerServiceService;
    
    @Autowired
    public CustomerController(CustomerService customerService,
                              RegisterDeviceService registerDeviceService,
                              RegisterServiceService registerServiceService) {
        this.customerService = customerService;
        this.registerDeviceService = registerDeviceService;
        this.registerServiceService = registerServiceService;
    }

    @GetMapping("/list")
    public String listDevice(Model model) {
        List<Customer> customers = customerService.getList();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/add")
    public String displayAdd(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/add";
        }
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/update")
    public String displayUpdate(@RequestParam(name = "id") String id, Model model) {
        model.addAttribute("updateCustomer", customerService.getCustomerById(id));
        return "customer/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute(name = "updateCustomer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/update";
        }
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam String id) {
        registerDeviceService.updateDeviceStatusBeforeDelete(id);
        registerDeviceService.deleteAllByCustomerId(id);
        registerServiceService.deleteAllByCustomerId(id);
        customerService.deleteById(id);
        return "redirect:/customer/list";
    }
}
