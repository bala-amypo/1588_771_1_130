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

    @GetMapping("/{id}")
    public StolenDeviceReport getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @GetMapping("/serial/{serial}")
    public List<StolenDeviceReport> getBySerial(@PathVariable String serial) {
        return service.getBySerialNumber(serial);
    }

    @GetMapping
    public List<StolenDeviceReport> getAll() {
        return service.getAll();
    }
}
