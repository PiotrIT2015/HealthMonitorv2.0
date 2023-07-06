package engine.pp.healthmonitor;

public interface PatientView {
    String getFirstName();
    String getLastName();

    int getPesel();
    void setFirstName(String firstName);
    void setLastName(String lastName);
}
