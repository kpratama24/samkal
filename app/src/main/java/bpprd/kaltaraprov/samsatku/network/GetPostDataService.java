package bpprd.kaltaraprov.samsatku.network;



import java.util.List;

import bpprd.kaltaraprov.samsatku.model.InfoPKB;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPostDataService {

    @GET("infopkb.php/")
    Call<List<InfoPKB>> getInfoPKB(@Query("na") String nomorPolisiAwal, @Query("nb") String nomorPolisiTengah,
                                   @Query("nc") String nomorPolisiAkhir);
}
