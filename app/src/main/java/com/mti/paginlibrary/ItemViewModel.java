/*
 * Created by Tareq Islam on 5/19/19 10:44 AM
 *
 *  Last modified 5/19/19 10:44 AM
 */

package com.mti.paginlibrary;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.mti.paginlibrary.model.Outlet;
import com.mti.paginlibrary.util.Constants;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/***
 * Created by mtita on 19,May,2019.
 */
public class ItemViewModel extends ViewModel {
    LiveData<PagedList<Outlet>> itemPagedList;

    private Executor executor;
    private LiveData<Constants.NETWORK_STATE> networkState;

    public ItemViewModel() {
        executor = Executors.newFixedThreadPool(5);

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();

        //By using switchMap getting data of NetworkState from ItemDataSourceFactory
        networkState = Transformations.switchMap(itemDataSourceFactory.getItemLiveDataSource(), new Function<ItemDataSource, LiveData<Constants.NETWORK_STATE>>() {
            @Override
            public LiveData<Constants.NETWORK_STATE> apply(ItemDataSource input) {
                return input.getNewtworkState();
            }
        });


        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(Constants.PAGE_SIZE)
                .build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config))
                .setFetchExecutor(executor).build();
    }

    public LiveData<Constants.NETWORK_STATE> getNetworkState() {
        return networkState;
    }

    public LiveData<PagedList<Outlet>> getItemPagedList() {
        return itemPagedList;
    }


}
