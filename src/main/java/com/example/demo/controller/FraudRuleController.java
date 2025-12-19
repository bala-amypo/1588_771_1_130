@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public FraudRule create(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public FraudRule update(@PathVariable Long id,
                            @RequestBody FraudRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<FraudRule> active() {
        return service.getActiveRules();
    }

    @GetMapping("/{id}")
    public FraudRule get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<FraudRule> all() {
        return service.getAll();
    }
}
