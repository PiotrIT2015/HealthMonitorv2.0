package engine.pp.healthmonitor;

public interface PatientModel {
    void createPatient(String name, String lastName);
    User getPatient();
}
