package engine.pp.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class HospitalActivity extends AppCompatActivity {

    private Button register, call, upload;
    private EditText name, surname, pesel;
    private static final int FILE_PICKER_REQUEST_CODE = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        init();
    }

    private void init() {
        call = (Button) findViewById(R.id.call);
        upload = (Button) findViewById(R.id.upload);
        register = (Button) findViewById(R.id.register);
        name = (EditText) findViewById(R.id.name);
        surname = (EditText) findViewById(R.id.surname);
        pesel = (EditText) findViewById(R.id.pesel);

        call.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String url = "https://api.whatsapp.com/send?phone="+112;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                launchFilePicker();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                PackageManager pm=getPackageManager();
                try {
                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = name.getText().toString()+","+ surname.getText().toString();
                    PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    //Check if package exists or not. If not then code
                    //in catch block will be called
                    waIntent.setPackage("com.whatsapp");
                    waIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(Intent.createChooser(waIntent, "Share with"));
                } catch (NameNotFoundException e) {
                    System.out.println( "WhatsApp not Installed");
                }
            }
        });
    }


    private void launchFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("text/csv"); // Set the desired file type here
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, FILE_PICKER_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            String path = uri.getPath(); // Get the path of the selected file
            // Do something with the file path
        }
    }

}