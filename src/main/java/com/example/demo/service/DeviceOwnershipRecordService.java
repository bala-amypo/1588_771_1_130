@Service
public class DeviceOwnershipService {

    @Autowired
    private DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        if (repo.findBySerialNumber(device.getSerialNumber()).isPresent())
            throw new RuntimeException("Duplicate serial number");
        return repo.save(device);
    }

    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }
}
