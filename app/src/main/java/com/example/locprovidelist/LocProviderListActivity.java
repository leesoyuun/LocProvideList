package com.example.locprovidelist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager lm;
    List<String> locProvList;
    Button mbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        mbutton = findViewById(R.id.button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i =0;
                String s = "";

                lm = (LocationManager) getSystemService(LOCATION_SERVICE);
                locProvList = lm.getAllProviders();

                for(String str : locProvList){
                    s +=  "Loc.Provider: " + locProvList.get(i) + "\n"
                            + "Status: " + lm.isProviderEnabled(locProvList.get(i)) + "\n\n";

                    i++;

                }
                mTextView.setText(s);
            }
        });


    }
}