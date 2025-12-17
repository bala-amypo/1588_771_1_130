public interface FraudRuleRepository extends JpaRepository<FraudRule, Long> {
    Optional<FraudRule> findByRuleCode(String ruleCode);
    List<FraudRule> findByActiveTrue();
}
