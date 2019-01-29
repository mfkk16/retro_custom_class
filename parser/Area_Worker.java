package com.example.calsys.retro_custom_class.parser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.calsys.retro_custom_class.Retro.APIinterface;
import com.example.calsys.retro_custom_class.Retro.ApiClient;
import com.example.calsys.retro_custom_class.Retro.Response.Tutorsubjectlistresponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;


public class Area_Worker {

    APIinterface apiInterface;
    Context context;
    Area_worker_callback area_worker_callback;
    String id,cat;

    public Area_Worker(Context context, Area_worker_callback area_worker_callback, String id, String cat) {
        this.context = context;
        this.area_worker_callback = area_worker_callback;
        this.id=id;
        this.cat=cat;

        Tutor_List(id, cat);

    }

    private void Tutor_List(final String id, String cat) {

        apiInterface = ApiClient.getClient().create(APIinterface.class);
        Call<Tutorsubjectlistresponse> callregister = apiInterface.get_tutors(id, cat);

        callregister.enqueue(new Callback<Tutorsubjectlistresponse>() {
            @Override
            public void onResponse(@NonNull Call<Tutorsubjectlistresponse> call, @NonNull retrofit2.Response<Tutorsubjectlistresponse> response) {
                // progressDialog.cancel();
                Tutorsubjectlistresponse x = response.body();
                if (x == null) {
                    try {
                        String error = response.errorBody().string();
                        Toast.makeText(context, "body" + error, Toast.LENGTH_LONG).show();
                        Log.e("ERROR", error);

                        Toast.makeText(context, "NULL", Toast.LENGTH_SHORT).show();
                        Log.e("success", error);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(context, "IOException", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    String status = String.valueOf(x.getStatus());
                    if (status.equals("success")) {
                    area_worker_callback.area_succes(x);

                    } else {
                        Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<Tutorsubjectlistresponse> call, Throwable t) {
                //  progressDialog.cancel();
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
