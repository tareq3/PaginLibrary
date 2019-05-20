/*
 * Created by Tareq Islam on 5/19/19 10:39 AM
 *
 *  Last modified 5/19/19 10:39 AM
 */

package com.mti.paginlibrary;

import com.mti.paginlibrary.model.OutletResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/***
 * Created by mtita on 19,May,2019.
 */
public interface ApiService {
    @GET("outlet")
    Call<OutletResponse> getOutlet(
            @Query("page") int page

    );

}
