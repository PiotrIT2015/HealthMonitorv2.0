package engine.pp.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

public class GalleryActivity extends AppCompatActivity{

    private TextView textViewMsg;
    private RecyclerView recyclerView;
    private memDatabase memDatabase;
    private List<memJoy> notes;

    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializeVies();
        displayList();
    }

    private void displayList(){
// initialize database instance
        memDatabase = memDatabase.getInstance(GalleryActivity.this);
// fetch list of notes in background thread
        new RetrieveTask(this).execute();
    }

    private static class RetrieveTask extends AsyncTask<Void,Void,List<memJoy>>{

        private WeakReference<GalleryActivity> activityReference;

        // only retain a weak reference to the activity
        RetrieveTask(GalleryActivity context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected List<memJoy> doInBackground(Void... voids) {
            if (activityReference.get()!=null)
                return null; //activityReference.get().memDatabase.getmemDao().getAllImages();
            else
                return null;
        }

        @Override
        protected void onPostExecute(List<memJoy> mems) {
            if (mems!=null && mems.size()>0 ){
                activityReference.get().notes=mems;

                // hides empty text view
                activityReference.get().textViewMsg.setVisibility(View.GONE);

                // create and set the adapter on RecyclerView instance to display list
                //activityReference.get().notesAdapter = new NotesAdapter(notes,activityReference.get());
                //activityReference.get().recyclerView.setAdapter(activityReference.get().notesAdapter);
            }
        }

    }

    /*
    private void initializeVies(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewMsg = (TextView) findViewById(R.id.tv\_\_empty);

        // Action button to add note
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(listener);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(GalleryActivity.this));

    }
    */
}