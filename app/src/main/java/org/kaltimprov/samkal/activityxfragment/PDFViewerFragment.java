package org.kaltimprov.samkal.activityxfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.kaltimprov.samkal.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PDFViewerFragment extends Fragment {


    @BindView(R.id.webview_pdf)
    WebView webviewPdf;
    Unbinder unbinder;
    @BindView(R.id.progress_wait)
    ProgressBar progressWait;
    @BindView(R.id.text_please_wait)
    TextView textPleaseWait;

    private String pdf_url;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pdf_viewer, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setPDFUrl();
        Log.d("PDF_url", pdf_url);
        webviewPdf.getSettings().setJavaScriptEnabled(true);
        webviewPdf.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressWait.setVisibility(View.GONE);
                textPleaseWait.setVisibility(View.GONE);
            }
        });
        webviewPdf.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf_url);
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * Method to set pdf url according to pdf_type obtained from Intent
     */
    private void setPDFUrl() {
        String pdf_url_prefix = "http://bpprdku.net/docpdf/"; //subject to change accordingly
        try {
            int pdf_type = ((PDFViewerActivity) getActivity()).getPdf_type();
            Log.d("PDF_TYPE",String.valueOf(pdf_type));
            switch (pdf_type){
                case 1:
                    pdf_url = pdf_url_prefix+"MekanismeEsamsat.pdf";
                    break;
                case 2:
                    pdf_url = pdf_url_prefix+"LokasiPelayananSamsat.pdf";
                    break;
                case 3:
                    pdf_url = pdf_url_prefix+"PersyaratanPendaftaranSamsat.pdf";
                    break;
                case 4:
                    pdf_url = pdf_url_prefix+"JadwalSamling.pdf";
                    break;
                case 5:
                    pdf_url = pdf_url_prefix+"Panduan.pdf";
                    break;
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        webviewPdf.destroy();
        unbinder.unbind();
    }
}
