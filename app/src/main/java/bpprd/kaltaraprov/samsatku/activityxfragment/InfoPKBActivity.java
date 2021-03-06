package bpprd.kaltaraprov.samsatku.activityxfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import bpprd.kaltaraprov.samsatku.R;

import bpprd.kaltaraprov.samsatku.helper.ActivityHelper;

public class InfoPKBActivity extends AppCompatActivity {

    Toolbar myToolbar;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pkb);

        myToolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.info_pkb));

        ActivityHelper.addFragmentToActivity(getSupportFragmentManager(), new EnterPKBFragment(),
                R.id.info_pkb_placeholder);
    }
}
