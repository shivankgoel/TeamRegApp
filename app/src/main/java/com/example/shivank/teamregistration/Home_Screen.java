package com.example.shivank.teamregistration;

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.shivank.teamregistration.R.string.courseDescriptionTittle;

public class Home_Screen extends AppCompatActivity {
    private FloatingActionButton fab1;
    //Go to next Screen on Click
   public void switchscreen(View view){
       Intent intent = new Intent(this, MainActivity.class);
       startActivity(intent);
   }



    //Overriding onCreate function to enable Floating Action Button, Dialog Fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Course Description", Snackbar.LENGTH_LONG)
                        .setAction("View", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentManager fm = getFragmentManager();
                                CourseDialogFragment dialogFragment = new CourseDialogFragment();
                                dialogFragment.show(fm, "Sample Fragment");


                            }
                        }).show();
            }
        });



    }
    //Dialog Fragment goes here
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class CourseDialogFragment extends DialogFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.course_fragment, container, false);
            getDialog().setTitle(courseDescriptionTittle);
            return rootView;
        }
    }



}
