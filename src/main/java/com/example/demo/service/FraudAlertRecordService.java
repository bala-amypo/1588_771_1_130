@Service
public class FraudAlertService {

    private final FraudAlertRecordRepository repo;

    public FraudAlertService(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    public FraudAlertRecord create(FraudAlertRecord alert) {
        return repo.save(alert);
    }

    public FraudAlertRecord resolve(Long id) {
        FraudAlertRecord alert = repo.findById(id).orElseThrow();
        alert.setResolved(true);
        return repo.save(alert);
    }

    public List<FraudAlertRecord> bySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    public List<FraudAlertRecord> byClaim(Long claimId) {
        return repo.findByClaimId(claimId);
    }

    public List<FraudAlertRecord> all() {
        return repo.findAll();
    }
}
