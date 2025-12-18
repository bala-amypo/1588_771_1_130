@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    @Autowired
    private DeviceOwnershipService service;

    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord d) {
        return service.registerDevice(d);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> all() {
        return service.getAllDevices();
    }
}
