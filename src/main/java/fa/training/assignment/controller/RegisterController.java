package fa.training.assignment.controller;

import fa.training.assignment.entity.Customer;
import fa.training.assignment.entity.Device;
import fa.training.assignment.entity.DeviceUsage;
import fa.training.assignment.entity.Service;
import fa.training.assignment.entity.ServiceUsage;
import fa.training.assignment.service.CustomerService;
import fa.training.assignment.service.DeviceService;
import fa.training.assignment.service.RegisterDeviceService;
import fa.training.assignment.service.RegisterServiceService;
import fa.training.assignment.service.ServiceService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegisterServiceService registerServiceService;
    private final RegisterDeviceService registerDeviceService;
    private final DeviceService deviceService;
    private final CustomerService customerService;
    private final ServiceService serviceService;

    @Autowired
    public RegisterController(RegisterServiceService registerServiceService,
                              RegisterDeviceService registerDeviceService,
                              DeviceService deviceService, CustomerService customerService,
                              ServiceService serviceService) {
        this.registerServiceService = registerServiceService;
        this.registerDeviceService = registerDeviceService;
        this.deviceService = deviceService;
        this.customerService = customerService;
        this.serviceService = serviceService;
    }

    @GetMapping("/device")
    public String displayRegisterDevice(Model model) {
        model.addAttribute("devices", deviceService.getInactiveList());
        model.addAttribute("customers", customerService.getList());
        model.addAttribute("deviceUsage", new DeviceUsage());
        return "register/device-register";
    }

    @PostMapping("/device")
    public String registerDevice(@Valid @ModelAttribute DeviceUsage deviceUsage, BindingResult bindingResult) {
        Customer customer = customerService.getCustomerById(deviceUsage.getCustomer().getCustomerId());
        Device device = deviceService.getDeviceById(deviceUsage.getDevice().getDeviceId());
        device.setStatus("active");
        deviceService.save(device);
        deviceUsage.setDevice(device);
        deviceUsage.setCustomer(customer);
        registerDeviceService.save(deviceUsage);
        return "redirect:/device/list";
    }

    @GetMapping("/service")
    public String displayRegisterService(Model model) {
        model.addAttribute("services", serviceService.getList());
        model.addAttribute("customers", customerService.getList());
        model.addAttribute("serviceUsage", new ServiceUsage());
        return "register/service-register";
    }

    @PostMapping("/service")
    public String registerService(@ModelAttribute ServiceUsage serviceUsage) {
        Customer customer = customerService.getCustomerById(serviceUsage.getCustomer().getCustomerId());
        Service service = serviceService.getServiceById(serviceUsage.getService().getServiceId());
        serviceUsage.setCustomer(customer);
        serviceUsage.setService(service);
        registerServiceService.save(serviceUsage);
        return "redirect:/device/list";
    }
}
