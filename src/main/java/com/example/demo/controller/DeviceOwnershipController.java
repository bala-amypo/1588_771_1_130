@RestController
@RequestMapping("/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService s) {
        this.service = s;
    }

    @PostMapping
    public DeviceOwnershipRecord register(@RequestBody DeviceOwnershipRecord d) {
        return service.registerDevice(d);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> all() {
        return service.getAllDevices();
    }
}
