package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Zelalem Belay on 1/4/2017.
 */

@Entity
@Table(name = "audit")
public class Audit
{
    private int id;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate date;
    private String oldValue;
    private String newValue;
    private LicenseType licenseType;
    private SoftwareLicense softwareLicense;
    private Assigned assigned;
    private Issue issue;
    private Software software;
    private Hardware hardware;
    private HardwareStatus hardwareStatus;
    private Vendor vendor;
    private Manufacturer manufacturer;
    private Location location;
    private EquipmentType equipmentType;
    private PositionHardware positionHardware;
    private PositionSoftware positionSoftware;
    private AuditEvent auditEvent;
    private UserPreference userPreference;
    private UserNotification userNotification;
    private WebsiteSkin websiteSkin;
    private NotificationType notificationType;
    private Notification notification;

    public Audit(LocalDate date, String oldValue, String newValue) {
        this.date = date;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "soft_license_id", foreignKey = @ForeignKey(name = "FkAudit_SoftLicenseID"), referencedColumnName = "id")
    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }

    public Audit() {
    }
    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "old_value", nullable = false)
    public String getOldValue() {
        return oldValue;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_NotificationID"))
    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_NotificationTypeID"))
    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    @Column(name = "new_value", nullable = false)
    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_notification_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_UserNotificationID"))
    public UserNotification getUserNotification() {
        return userNotification;
    }

    public void setUserNotification(UserNotification userNotification) {
        this.userNotification = userNotification;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_preference_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_UserPreferenceID"))
    public UserPreference getUserPreference() {
        return userPreference;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "website_skin_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_WebsiteSkinID"))
    public WebsiteSkin getWebsiteSkin() {
        return websiteSkin;
    }

    public void setWebsiteSkin(WebsiteSkin websiteSkin) {
        this.websiteSkin = websiteSkin;
    }

    public void setUserPreference(UserPreference userPreference) {
        this.userPreference = userPreference;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_AuditEventID"))
    public AuditEvent getAuditEvent() {
        return auditEvent;
    }

    public void setAuditEvent(AuditEvent auditEvent) {
        this.auditEvent = auditEvent;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_software_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_PosSoftwareID"))
    public PositionSoftware getPositionSoftware() {
        return positionSoftware;
    }

    public void setPositionSoftware(PositionSoftware positionSoftware) {
        this.positionSoftware = positionSoftware;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_hardware_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_PosHardwareID"))
    public PositionHardware getPositionHardware() {
        return positionHardware;
    }

    public void setPositionHardware(PositionHardware positionHardware) {
        this.positionHardware = positionHardware;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_EquipTypeID"))
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardware_status_id", foreignKey = @ForeignKey(name = "FkAudit_HardwareStatusID"), referencedColumnName = "id")
    public HardwareStatus getHardwareStatus() {
        return hardwareStatus;
    }

    public void setHardwareStatus(HardwareStatus hardwareStatus) {
        this.hardwareStatus = hardwareStatus;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_VendorID"))
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_ManufacturerID"))
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_LocationID"))
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "software_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_SoftwareID"))
    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardware_id", foreignKey = @ForeignKey(name = "FkAudit_HardwareID"), referencedColumnName = "id")
    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issue_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAudit_IssueID"))
    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "license_type_id", foreignKey = @ForeignKey(name = "FkAudit_LicenseTypeID"), referencedColumnName = "id")
    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_id", foreignKey = @ForeignKey(name = "FkAudit_AssignedID"), referencedColumnName = "id")
    public Assigned getAssigned() {
        return assigned;
    }

    public void setAssigned(Assigned assigned) {
        this.assigned = assigned;
    }
}
