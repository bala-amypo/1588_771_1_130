import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    @PostMapping
    public StolenDeviceReport report(@RequestBody StolenDeviceReport report) {
        return service.report(report);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> bySerial(@PathVariable String serialNumber) {
        return service.getBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public StolenDeviceReport byId(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<StolenDeviceReport> all() {
        return service.getAll();
    }
}
