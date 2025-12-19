@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord submit(WarrantyClaimRecord claim) {
        claim.setStatus("SUBMITTED");
        return repository.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<WarrantyClaimRecord> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<WarrantyClaimRecord> getBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public WarrantyClaimRecord updateStatus(Long id, String status) {
        WarrantyClaimRecord claim = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
        claim.setStatus(status);
        return repository.save(claim);
    }
}
