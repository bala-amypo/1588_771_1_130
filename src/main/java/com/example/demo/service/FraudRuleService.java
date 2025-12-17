@Service
public class FraudRuleService {

    private final FraudRuleRepository repo;

    public FraudRuleService(FraudRuleRepository repo) {
        this.repo = repo;
    }

    public FraudRule createRule(FraudRule rule) {
        return repo.save(rule);
    }

    public FraudRule updateRule(Long id, FraudRule updated) {
        FraudRule rule = repo.findById(id).orElseThrow();
        rule.setDescription(updated.getDescription());
        rule.setRuleType(updated.getRuleType());
        rule.setActive(updated.getActive());
        return repo.save(rule);
    }

    public List<FraudRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public FraudRule getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<FraudRule> getAll() {
        return repo.findAll();
    }
}
