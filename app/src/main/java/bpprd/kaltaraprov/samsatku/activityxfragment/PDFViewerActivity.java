package bpprd.kaltaraprov.samsatku.activityxfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import bpprd.kaltaraprov.samsatku.R;

import bpprd.kaltaraprov.samsatku.helper.ActivityHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PDFViewerActivity extends AppCompatActivity {

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;

    /**
     * Attribute data :
     * 1 : Mekanisme E-Samsat
     * 2 : Lokasi Pelayanan E-Samsat
     * 3 : Persyaratan E-Samsat
     * 4 : Jadwal SAMLING
     * 5 : Panduan
     */
    private int pdf_type = 0; //PDF to be viewed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if(getIntent().getIntExtra("pdf",0) != 0){
            pdf_type = getIntent().getIntExtra("pdf",0);
        }

        ActivityHelper.addFragmentToActivity(getSupportFragmentManager(), new PDFViewerFragment(),
                R.id.pdf_viewer_placeholder);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Method to get pdf type
     * @return pdf type
     */
    public int getPdf_type(){
        return this.pdf_type;
    }
}
