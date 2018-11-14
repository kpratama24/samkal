package bpprd.kaltaraprov.samsatku.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import bpprd.kaltaraprov.samsatku.model.InfoPKB;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTHelper {

    private static Retrofit retrofit;
    private static final String API_BASE_URL = "http://android.bpprdku.net/"; //TODO change

    /**
     * Method to get the required retrofit instance
     * @return retrofit instance
     */
    private static Retrofit getRetrofitInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    /**
     * Method to get info pkb
     * @param na plat awal
     * @param nb plat tengah
     * @param nc plat akhir
     * @param callback invokable callback
     */
    public void getInfoPKB(String na,String nb, String nc, Callback<List<InfoPKB>> callback){
        GetPostDataService service = getRetrofitInstance().create(GetPostDataService.class);
        Call<List<InfoPKB>> call = service.getInfoPKB(na, nb, nc);
        call.enqueue(callback);
    }
}
