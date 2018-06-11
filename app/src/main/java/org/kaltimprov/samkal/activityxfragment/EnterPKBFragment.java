package org.kaltimprov.samkal.activityxfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.kaltimprov.samkal.R;
import org.kaltimprov.samkal.helper.ActivityHelper;

public class EnterPKBFragment extends Fragment {

    EditText editPlatNomor1;
    EditText editPlatNomor2;
    EditText editPlatNomor3;
    Button buttonLihatInfoPKB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter_pkb, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        editPlatNomor1 = view.findViewById(R.id.edit_plat_nomor_1);
        editPlatNomor2 = view.findViewById(R.id.edit_plat_nomor_2);
        editPlatNomor3 = view.findViewById(R.id.edit_plat_nomor_3);

        buttonLihatInfoPKB = view.findViewById(R.id.button_lihat_info);
        buttonLihatInfoPKB.setEnabled(false);
        editPlatNomor1.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        editPlatNomor2.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        editPlatNomor3.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        editPlatNomor1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0)
                    if(s.charAt(0)!='K') {
                        editPlatNomor1.setError(s.charAt(0)+ " bukan plat nomor kalimantan");
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
                if(editPlatNomor1.getText().toString().trim().equals("")){
                    editPlatNomor1.setError("Harus diisi.");
                    return;
                }
                if(editPlatNomor2.getText().toString().trim().equals("")){
                    editPlatNomor2.setError("Harus diisi.");
                    return;
                }
                if(editPlatNomor3.getText().toString().trim().equals("")){
                    editPlatNomor3.setError("Harus diisi.");
                    return;
                }
                //Data sent to Web Service below
                String toWebService = editPlatNomor1.getText().toString().trim()
                        +editPlatNomor3.getText().toString().trim()
                        +" "
                        +editPlatNomor2.getText().toString().trim();

                Bundle args = new Bundle();
                args.putString("no_polisi", toWebService);
                args.putString("null_no_polisi",
                        editPlatNomor1.getText().toString()
                + " "
                + editPlatNomor2.getText().toString()
                + " "
                + editPlatNomor3.getText().toString());
                ResultPKBFragment resultPKBFragment = new ResultPKBFragment();
                resultPKBFragment.setArguments(args);

                ActivityHelper.addFragmentToActivity(getActivity().getSupportFragmentManager(),
                        resultPKBFragment, R.id.info_pkb_placeholder);
            }
        });
    }

}
