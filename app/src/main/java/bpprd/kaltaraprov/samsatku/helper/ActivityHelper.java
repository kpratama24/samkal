package bpprd.kaltaraprov.samsatku.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActivityHelper {

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.commit();
    }

    public static void makeToast(Context ctx, String message, int duration){
        Toast.makeText(ctx,message,duration).show();
    }

    public static String convertDatabaseDateToLocalDate(String databaseDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
            return sdf2.format(sdf.parse(databaseDate));
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d("errorParsing",e.getMessage());
        }
        return "";
    }

    public static String changeCommaToFullStop(String str){
        return str.replaceAll(",",".");
    }


}
