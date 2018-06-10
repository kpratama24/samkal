package org.kaltimprov.samkal.activityxfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.kaltimprov.samkal.R;
import org.kaltimprov.samkal.helper.ActivityHelper;
import org.kaltimprov.samkal.network.RESTHelper;

public class EnterPKBFragment extends Fragment {

    EditText editPlatNomor;
    Button buttonLihatInfoPKB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter_pkb, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        editPlatNomor = view.findViewById(R.id.edit_plat_nomor);
        buttonLihatInfoPKB = view.findViewById(R.id.button_lihat_info);
        editPlatNomor.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        editPlatNomor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0)
                    if(s.charAt(0)!='K') {
                        editPlatNomor.setError(s.charAt(0)+ " bukan plat nomor kalimantan");
                        buttonLihatInfoPKB.setEnabled(false);
                    }
                    else buttonLihatInfoPKB.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttonLihatInfoPKB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editPlatNomor.getText().toString().trim().equals("")){
                    editPlatNomor.setError("Harus diisi.");
                    return;
                }
                Bundle args = new Bundle();
                args.putString("no_polisi", editPlatNomor.getText().toString());
                ResultPKBFragment resultPKBFragment = new ResultPKBFragment();
                resultPKBFragment.setArguments(args);

                ActivityHelper.addFragmentToActivity(getActivity().getSupportFragmentManager(),
                        resultPKBFragment, R.id.info_pkb_placeholder);
            }
        });
    }
}
