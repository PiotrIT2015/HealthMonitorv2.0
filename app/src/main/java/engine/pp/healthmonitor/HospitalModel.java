package engine.pp.healthmonitor;

public interface HospitalModel {
    PatientPresenterImpl getPatient();
    void savePatient(PatientPresenterImpl patientPresenterImpl);
}
