/*
 * Created by Tareq Islam on 5/20/19 1:02 PM
 *
 *  Last modified 5/19/19 4:27 PM
 */

/*
 * Created by Tareq Islam on 5/19/19 10:34 AM
 *
 *  Last modified 5/19/19 10:34 AM
 */

package com.mti.paginlibrary.api;

import com.mti.paginlibrary.util.HttpAuthInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/***
 * Created by mtita on 19,May,2019.
 */
public class RetrofitClient {
    private static final String BASE_URL = "http://myone.selliscope.com/api/v1/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpAuthInterceptor("arefin@myonebd.com", "123"))
                .connectTimeout(100000, TimeUnit.SECONDS)
                .readTimeout(100000, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static synchronized RetrofitClient getInstance() {

        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

public ApiService getApiService(){
    return retrofit.create(ApiService.class);}
}
