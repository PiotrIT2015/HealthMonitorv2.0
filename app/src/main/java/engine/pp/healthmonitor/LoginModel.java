package engine.pp.healthmonitor;

public interface LoginModel {
    void login(String email, String password, OnLoginFinishedListener listener);

    interface OnLoginFinishedListener {
        void onLoginSuccess();
        void onLoginError(String errorMessage);
    }
}

