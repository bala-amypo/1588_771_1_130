public interface FraudAlertRecordRepository extends JpaRepository<FraudAlertRecord, Long> {
    List<FraudAlertRecord> findBySerialNumber(String serialNumber);
    List<FraudAlertRecord> findByClaimId(Long claimId);
}
