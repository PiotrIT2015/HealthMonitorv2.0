package engine.pp.healthmonitor;

public interface LoginView {
    String getEmail();
    String getPassword();
    void showErrorMessage(String message);
    void showSuccessMessage(String message);
}

