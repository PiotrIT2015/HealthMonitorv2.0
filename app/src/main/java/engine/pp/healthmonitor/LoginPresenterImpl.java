package engine.pp.healthmonitor;

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void onLoginClicked() {
        String email = loginView.getEmail();
        String password = loginView.getPassword();

        // Validate email and password (optional)

        // Perform login using the loginModel
        loginModel.login(email, password, new LoginModel.OnLoginFinishedListener() {
            @Override
            public void onLoginSuccess() {
                loginView.showSuccessMessage("Login successful");
            }

            @Override
            public void onLoginError(String errorMessage) {
                loginView.showErrorMessage(errorMessage);
            }
        });
    }

    @Override
    public void onDestroy() {
        // Clean up resources if necessary
    }
}

