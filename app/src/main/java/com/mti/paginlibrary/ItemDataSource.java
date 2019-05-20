/*
 * Created by Tareq Islam on 5/19/19 10:53 AM
 *
 *  Last modified 5/19/19 10:53 AM
 */

package com.mti.paginlibrary;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.mti.paginlibrary.api.RetrofitClient;
import com.mti.paginlibrary.model.Outlet;
import com.mti.paginlibrary.model.OutletResponse;
import com.mti.paginlibrary.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/***
 * Created by mtita on 19,May,2019.
 */
public class ItemDataSource extends PageKeyedDataSource<Integer, Outlet> {

    private static final int FIRST_PAGE = 1;
    private MutableLiveData networkState;


    public ItemDataSource() {
        this.networkState = new MutableLiveData();
       }



    public MutableLiveData getNewtworkState() {
        return networkState;
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Outlet> callback) {

        networkState.postValue(Constants.NETWORK_STATE.LOADING);

        RetrofitClient.getInstance().getApiService()
                .getOutlet(FIRST_PAGE)
                .enqueue(new Callback<OutletResponse>() {
                    @Override
                    public void onResponse(Call<OutletResponse> call, Response<OutletResponse> response) {

                        if (response.isSuccessful()) {

                            callback.onResult(response.body().getResult().getOutlet(), null, FIRST_PAGE + 1);

                            networkState.postValue(Constants.NETWORK_STATE.LOADED);

                        }else{

                            networkState.postValue(Constants.NETWORK_STATE.ERROR);
                        }
                    }

                    @Override
                    public void onFailure(Call<OutletResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Outlet> callback) {
        networkState.postValue(Constants.NETWORK_STATE.LOADING);

        RetrofitClient.getInstance().getApiService()
                .getOutlet(params.key)
                .enqueue(new Callback<OutletResponse>() {
                    @Override
                    public void onResponse(Call<OutletResponse> call, Response<OutletResponse> response) {
                        if (response.isSuccessful()) {

                            Integer key = (params.key > 1) ? params.key - 1 : null;
                            callback.onResult(response.body().getResult().getOutlet(), key);
                            networkState.postValue(Constants.NETWORK_STATE.LOADED);
                        }else{
                            networkState.postValue(Constants.NETWORK_STATE.ERROR);
                        }
                    }

                    @Override
                    public void onFailure(Call<OutletResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Outlet> callback) {

        networkState.postValue(Constants.NETWORK_STATE.LOADING);


        RetrofitClient.getInstance().getApiService().getOutlet(params.key)

                .enqueue(new Callback<OutletResponse>() {
                    @Override
                    public void onResponse(Call<OutletResponse> call, Response<OutletResponse> response) {
                        if (response.isSuccessful()) {

                            Integer key = response.body().getNextPage() > -1 ? params.key + 1 : null;
                            callback.onResult(response.body().getResult().getOutlet(), key);
                            networkState.postValue(Constants.NETWORK_STATE.LOADED);
                        }else{
                            networkState.postValue(Constants.NETWORK_STATE.ERROR);
                        }

                    }

                    @Override
                    public void onFailure(Call<OutletResponse> call, Throwable t) {

                    }
                });
    }



}
