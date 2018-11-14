package bpprd.kaltaraprov.samsatku.activityxfragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import bpprd.kaltaraprov.samsatku.R;
import bpprd.kaltaraprov.samsatku.helper.ActivityHelper;
import bpprd.kaltaraprov.samsatku.model.InfoPKB;
import bpprd.kaltaraprov.samsatku.network.RESTHelper;
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
    @BindView(R.id.text_pkb_pok)
    TextView textPkbPok;
    @BindView(R.id.text_pkb_den)
    TextView textPkbDen;
    @BindView(R.id.text_swdkllj_pok)
    TextView textSwdklljPok;
    @BindView(R.id.text_swdkllj_den)
    TextView textSwdklljDen;
    @BindView(R.id.text_pnbp_stnk)
    TextView textPnbpStnk;
    @BindView(R.id.text_pnbp_tnkb)
    TextView textPnbpTnkb;
    @BindView(R.id.text_total)
    TextView textTotal;
    @BindView(R.id.text_tgl_pajak)
    TextView textTglPajak;
    @BindView(R.id.text_tgl_stnk)
    TextView textTglStnk;
    @BindView(R.id.text_milik_ke)
    TextView textMilikKe;
    @BindView(R.id.text_keterangan)
    TextView textKeterangan;
    private RESTHelper rRest;
    private String nomorPolisi1;
    private String nomorPolisi2;
    private String nomorPolisi3;
    private String nullErrorString;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rRest = new RESTHelper();
        try {
            nomorPolisi1 = getArguments().getString("no_polisi_1");
            nomorPolisi2 = getArguments().getString("no_polisi_2");
            nomorPolisi3 = getArguments().getString("no_polisi_3");

            nullErrorString = getArguments().getString("null_no_polisi");
            tryGetInfo(nomorPolisi1,nomorPolisi2,nomorPolisi3);
//            getInfoPKB(nomorPolisi1,nomorPolisi2,nomorPolisi3);
        } catch (NullPointerException e) {
            ActivityHelper.makeToast(getContext(), getString(R.string.unknown_error),
                    Toast.LENGTH_SHORT);
            ActivityHelper.addFragmentToActivity(getActivity().getSupportFragmentManager(),
                    new EnterPKBFragment(), R.id.info_pkb_placeholder);
        }
    }

    /**
     * Method to check whether the web service already have the pkb data.
     * @param nomorPolisi1 prefix number.
     * @param nomorPolisi2 infix number.
     * @param nomorPolisi3 suffix number.
     */
    private void tryGetInfo(final String nomorPolisi1, final String nomorPolisi2, final String nomorPolisi3) {
        showProgressBar();
        rRest.getInfoPKB(nomorPolisi1, nomorPolisi2, nomorPolisi3, new Callback<List<InfoPKB>>() {
            @Override
            public void onResponse(Call<List<InfoPKB>> call, Response<List<InfoPKB>> response) {
                try{
                    String test = response.body().get(0).getBEAADMSTNK().toString(); // only for trigggering the NullPointerException
                    if(!test.isEmpty()){
                        getInfoPKB(nomorPolisi1, nomorPolisi2, nomorPolisi3);
                    }
                }
                catch (NullPointerException e){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getInfoPKB(nomorPolisi1, nomorPolisi2, nomorPolisi3);
                        }
                    },4000);
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

    private void getInfoPKB(final String nomorPolisi1, final String nomorPolisi2, final String nomorPolisi3) {
        rRest.getInfoPKB(nomorPolisi1, nomorPolisi2, nomorPolisi3, new Callback<List<InfoPKB>>() {
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
                            response.body().get(0).getTHBUATAN()));
                    textWarna.setText(String.format(getString(R.string.warna),
                            response.body().get(0).getWARNAKB().toString()));
                    textPkbPok.setText(
                            ActivityHelper.changeCommaToFullStop(NumberFormat.getInstance(Locale.ENGLISH).format(Integer.valueOf(response.body().get(0).getPKBPOK().toString()))));
                    textPkbDen.setText(
                            ActivityHelper.changeCommaToFullStop(NumberFormat.getInstance(Locale.ENGLISH).format(Integer.valueOf(response.body().get(0).getPKBDEN().toString()))));
                    textPnbpStnk.setText(
                            ActivityHelper.changeCommaToFullStop(NumberFormat.getInstance(Locale.ENGLISH).format(Integer.valueOf(response.body().get(0).getBEAADMSTNK().toString()))));
                    textPnbpTnkb.setText(
                            ActivityHelper.changeCommaToFullStop(NumberFormat.getInstance(Locale.ENGLISH).format(Integer.valueOf(response.body().get(0).getBEAADMTNKB().toString()))));
                    textSwdklljPok.setText(
                            ActivityHelper.changeCommaToFullStop(NumberFormat.getInstance(Locale.ENGLISH).format(Integer.valueOf(response.body().get(0).getSWDPOK().toString()))));
                    textSwdklljDen.setText(
                            ActivityHelper.changeCommaToFullStop(NumberFormat.getInstance(Locale.ENGLISH).format(Integer.valueOf(response.body().get(0).getSWDDEN().toString()))));
                    textTotal.setText(
                            ActivityHelper.changeCommaToFullStop(NumberFormat.getInstance(Locale.ENGLISH).format(Integer.valueOf( response.body().get(0).getTOTALBAYAR().toString()))));
                    textTglPajak.setText(
                            ActivityHelper.convertDatabaseDateToLocalDate(response.body().get(0).getTGAKHIRPAJAK().toString()));
                    textTglStnk.setText(
                            ActivityHelper.convertDatabaseDateToLocalDate(response.body().get(0).getTGAKHIRSTNKB().toString()));
                    textMilikKe.setText(
                            response.body().get(0).getMILIKKE().toString());
                    textKeterangan.setText(
                            response.body().get(0).getDESKRIPSI());
                } catch (NullPointerException e) {
                    ActivityHelper.makeToast(getContext(),
                            getString(R.string.error_server), Toast.LENGTH_LONG);
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
        super.onDestroyView() ;
        unbinder.unbind();
    }

    ProgressDialog progress;

    private void showProgressBar() {

        progress = new ProgressDialog(getContext());
        progress.setTitle(getString(R.string.processing));
        progress.setMessage(getString(R.string.please_wait_few_moment));
        progress.setCancelable(true);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void hideProgressBar() {
        progress.hide();
    }
}
