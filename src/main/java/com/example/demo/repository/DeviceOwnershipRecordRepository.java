public interface DeviceOwnershipRecordRepository extends JpaRepository<DeviceOwnershipRecord, Long> {
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serialNumber);
}
