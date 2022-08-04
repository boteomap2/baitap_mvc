package fa.training.assignment.controller;

import fa.training.assignment.entity.Service;
import fa.training.assignment.service.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/list")
    public String listDevice(Model model) {
        List<Service> services = serviceService.getList();
        model.addAttribute("services", services);
        return "service/list";
    }

    @GetMapping("/add")
    public String displayAdd(Model model) {
        model.addAttribute("service", new Service());
        return "service/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Service service) {
        serviceService.save(service);
        return "redirect:/service/list";
    }

    @GetMapping("/update")
    public String displayUpdate(@RequestParam(name = "id") String id, Model model) {
        model.addAttribute("updateService", serviceService.getServiceById(id));
        return "service/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateService") Service service) {
        serviceService.save(service);
        return "redirect:/service/list";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam String id) {
        serviceService.deleteById(id);
        return "redirect:/service/list";
    }
}
