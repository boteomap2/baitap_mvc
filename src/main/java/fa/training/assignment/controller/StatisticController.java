package fa.training.assignment.controller;

import fa.training.assignment.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticController {
    private final CustomerService customerService;

    @Autowired
    public StatisticController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/statistic")
    public String list(Model model) {
        List<Object[]> data = customerService.getAllCustomerInformation();
        model.addAttribute("data", data);
        return "statistic";
    }
}
