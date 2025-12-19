@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    @PostMapping
    public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
        return service.create(alert);
    }

    @GetMapping
    public List<FraudAlertRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FraudAlertRecord getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolve(@PathVariable Long id) {
        return service.resolve(id);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<FraudAlertRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getBySerialNumber(serialNumber);
    }
}
