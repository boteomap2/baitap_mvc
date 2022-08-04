package fa.training.assignment.formatter;

import fa.training.assignment.entity.DeviceUsage;
import fa.training.assignment.service.CustomerService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class DeviceUsageFormatter implements Formatter<DeviceUsage> {

    private final CustomerService customerService;

    @Autowired
    public DeviceUsageFormatter(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public DeviceUsage parse(String text, Locale locale) throws ParseException {
        return new DeviceUsage();
    }

    @Override
    public String print(DeviceUsage object, Locale locale) {
        return object.toString();
    }
}
