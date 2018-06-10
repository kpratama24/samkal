package org.kaltimprov.samkal.activityxfragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.kaltimprov.samkal.R;
import org.kaltimprov.samkal.helper.ActivityHelper;
import org.kaltimprov.samkal.model.InfoPKB;
import org.kaltimprov.samkal.network.RESTHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultPKBFragment extends Fragment {

    @BindView(R.id.text_merk)
    TextView textMerk;
    @BindView(R.id.text_model)
    TextView textModel;
    @BindView(R.id.text_tahun)
    TextView textTahun;
    @BindView(R.id.text_warna)
    TextView textWarna;
    @BindView(R.id.text_no_rangka)
    TextView textNoRangka;
    @BindView(R.id.text_no_mesin)
    TextView textNoMesin;
    Unbinder unbinder;
    private RESTHelper rRest;
    private String nomorPolisi;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rRest = new RESTHelper();
        try {
            nomorPolisi = getArguments().getString("no_polisi");
            getInfoPKB(nomorPolisi);
        } catch (NullPointerException e) {
            ActivityHelper.makeToast(getContext(), getString(R.string.unknown_error),
                    Toast.LENGTH_SHORT);
            ActivityHelper.addFragmentToActivity(getActivity().getSupportFragmentManager(),
                    new EnterPKBFragment(), R.id.info_pkb_placeholder);
        }
    }

    private void getInfoPKB(final String nomorPolisi) {
        showProgressBar();
            rRest.getInfoPKB(nomorPolisi, new Callback<List<InfoPKB>>() {
                @Override
                public void onResponse(Call<List<InfoPKB>> call, Response<List<InfoPKB>> response) {
                    hideProgressBar();
                    try {
                        textModel.setText(String.format(getString(R.string.model),
                                response.body().get(0).getNMMODELKB()));
                        textMerk.setText(String.format(getString(R.string.merk),
                                response.body().get(0).getNMMEREKKB()));
                        textNoMesin.setText(String.format(getString(R.string.no_mesin),
                                response.body().get(0).getNOMESIN()));
                        textNoRangka.setText(String.format(getString(R.string.no_rangka),
                                response.body().get(0).getNORANGKA()));
                        textTahun.setText(String.format(getString(R.string.tahun),
                                response.body().get(0).getTHRAKITAN()));
                        // TODO implement textWarna
                        textWarna.setText(String.format(getString(R.string.warna),
                                String.valueOf(0)));
                    }
                    catch (IndexOutOfBoundsException e){
                        //Out of bounds because data not available
                        ActivityHelper.makeToast(getContext(),
                                String.format(getString(R.string.error_not_registered),
                                        nomorPolisi), Toast.LENGTH_LONG);
                        getActivity().finish();
                    }
                }

                @Override
                public void onFailure(Call<List<InfoPKB>> call, Throwable t) {
                    hideProgressBar();
                    ActivityHelper.makeToast(getContext(),
                            t.getMessage(),
                            Toast.LENGTH_SHORT);
                }
            });
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_pkb, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    ProgressDialog progress;

    private void showProgressBar(){

        progress = new ProgressDialog(getContext());
        progress.setTitle(getString(R.string.processing));
        progress.setMessage(getString(R.string.please_wait));
        progress.setCancelable(true);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void hideProgressBar(){
        progress.hide();
    }
}
