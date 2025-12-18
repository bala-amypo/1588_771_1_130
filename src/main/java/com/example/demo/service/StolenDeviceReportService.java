// @Service
// public class StolenDeviceService {

//     private final StolenDeviceReportRepository repo;

//     public StolenDeviceService(StolenDeviceReportRepository repo) {
//         this.repo = repo;
//     }

//     public StolenDeviceReport report(StolenDeviceReport report) {
//         return repo.save(report);
//     }

//     public StolenDeviceReport getById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Report not found"));
//     }

//     public List<StolenDeviceReport> getBySerial(String serial) {
//         return repo.findBySerialNumber(serial);
//     }

//     public List<StolenDeviceReport> getAll() {
//         return repo.findAll();
//     }
// }
