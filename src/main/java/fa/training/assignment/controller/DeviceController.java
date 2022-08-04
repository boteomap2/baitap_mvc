package fa.training.assignment.controller;

import fa.training.assignment.entity.Device;
import fa.training.assignment.service.DeviceService;
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
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/list")
    public String listDevice(Model model) {
        List<Device> devices = deviceService.getList();
        model.addAttribute("devices", devices);
        return "device/list";
    }

    @GetMapping("/add")
    public String displayAdd(Model model) {
        model.addAttribute("device", new Device());
        return "device/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Device device) {
        deviceService.save(device);
        return "redirect:/device/list";
    }

    @GetMapping("/update")
    public String displayUpdate(@RequestParam(name = "id") String id, Model model) {
        Integer deviceId = Integer.parseInt(id);
        model.addAttribute("updateDevice", deviceService.getDeviceById(deviceId));
        return "device/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "updateDevice") Device device) {
        deviceService.save(device);
        return "redirect:/device/list";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam String id) {
        Integer deviceId = Integer.parseInt(id);
        deviceService.deleteById(deviceId);
        return "redirect:/device/list";
    }
}
