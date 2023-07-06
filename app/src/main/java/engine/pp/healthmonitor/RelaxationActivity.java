package engine.pp.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class RelaxationActivity extends AppCompatActivity {

    Button music, gallery, health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation);
        init();
    }

    private void init(){
        music=(Button)findViewById(R.id.music);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setPackage("com.google.android.youtube");
                intent.setData(Uri.parse("https://www.youtube.com"));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // YouTube app is not installed, fallback to opening in a web browser
                    intent.setPackage(null);
                    startActivity(intent);
                }
            }
        });

        gallery=(Button)findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RelaxationActivity.this,  GalleryActivity.class);
                RelaxationActivity.this.startActivity(myIntent);
            }
        });

        health=(Button)findViewById(R.id.rescue);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RelaxationActivity.this,  HospitalActivity.class);
                RelaxationActivity.this.startActivity(myIntent);
            }
        });
    }
}