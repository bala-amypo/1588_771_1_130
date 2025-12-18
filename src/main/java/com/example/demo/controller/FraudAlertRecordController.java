// @RestController
// @RequestMapping("/api/fraud-alerts")
// public class FraudAlertController {

//     private final FraudAlertService service;

//     public FraudAlertController(FraudAlertService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
//         return service.create(alert);
//     }

//     @PutMapping("/{id}/resolve")
//     public FraudAlertRecord resolve(@PathVariable Long id) {
//         return service.resolve(id);
//     }

//     @GetMapping("/serial/{serialNumber}")
//     public List<FraudAlertRecord> bySerial(@PathVariable String serialNumber) {
//         return service.bySerial(serialNumber);
//     }

//     @GetMapping("/claim/{claimId}")
//     public List<FraudAlertRecord> byClaim(@PathVariable Long claimId) {
//         return service.byClaim(claimId);
//     }

//     @GetMapping
//     public List<FraudAlertRecord> all() {
//         return service.all();
//     }
// }
