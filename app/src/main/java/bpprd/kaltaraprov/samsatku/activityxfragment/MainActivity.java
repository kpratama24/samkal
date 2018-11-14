package bpprd.kaltaraprov.samsatku.activityxfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import bpprd.kaltaraprov.samsatku.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    LinearLayout infoPKBLinear;
    @BindView(R.id.linear_mekanisme_e_samsat)
    LinearLayout linearMekanismeESamsat;
    @BindView(R.id.linear_lokasi_pelayanan_samsat)
    LinearLayout linearLokasiPelayananSamsat;
    @BindView(R.id.linear_persyaratan_e_samsat)
    LinearLayout linearPersyaratanESamsat;
    @BindView(R.id.linear_jadwal_samling)
    LinearLayout linearJadwalSamling;
    @BindView(R.id.linear_panduan)
    LinearLayout linearPanduan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        infoPKBLinear = findViewById(R.id.linear_info_pkb);

        infoPKBLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InfoPKBActivity.class);
                startActivity(i);
            }
        });

        linearMekanismeESamsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PDFViewerActivity.class);
                i.putExtra("pdf", 1);
                startActivity(i);
            }
        });
        linearLokasiPelayananSamsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PDFViewerActivity.class);
                i.putExtra("pdf", 2);
                startActivity(i);
            }
        });
        linearPersyaratanESamsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PDFViewerActivity.class);
                i.putExtra("pdf", 3);
                startActivity(i);
            }
        });
        linearJadwalSamling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PDFViewerActivity.class);
                i.putExtra("pdf", 4);
                startActivity(i);
            }
        });
        linearPanduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PDFViewerActivity.class);
                i.putExtra("pdf", 5);
                startActivity(i);
            }
        });
    }
}
