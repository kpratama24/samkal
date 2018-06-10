package org.kaltimprov.samkal.network;


import org.kaltimprov.samkal.model.InfoPKB;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPostDataService {

    @GET("cek_data1.php/")
    Call<List<InfoPKB>> getInfoPKB(@Query("no_polisi") String nomorPolisi);
}
