package org.kaltimprov.samkal.activityxfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.kaltimprov.samkal.R;

public class MainActivity extends AppCompatActivity {

    LinearLayout infoPKBLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoPKBLinear = findViewById(R.id.linear_info_pkb);

        infoPKBLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InfoPKBActivity.class);
                startActivity(i);
            }
        });
    }
}
