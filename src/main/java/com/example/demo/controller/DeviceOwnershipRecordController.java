@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipRecordController {

    @Autowired
    private DeviceOwnershipRecordService service;

    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord d) {
        return service.registerDevice(d);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> all() {
        return service.getAllDevices();
    }
}
