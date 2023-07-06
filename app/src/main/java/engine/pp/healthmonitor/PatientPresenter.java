package engine.pp.healthmonitor;

import java.io.File;

public interface PatientPresenter {
    void RegisterButtonClicked();
    File writeCsvFile(String name, String lastName, String history);
    void Print(File file);
}
