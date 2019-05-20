/*
 * Created by Tareq Islam on 5/19/19 10:47 AM
 *
 *  Last modified 5/19/19 10:47 AM
 */

package com.mti.paginlibrary;


import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.mti.paginlibrary.model.Outlet;

/***
 * Created by mtita on 19,May,2019.
 */
public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<ItemDataSource> itemLiveDataSource ;
    ItemDataSource itemDataSource;

    public ItemDataSourceFactory() {
        this.itemLiveDataSource = new MutableLiveData<ItemDataSource>();
    }

    @Override
    public DataSource create() {

     itemDataSource  = new ItemDataSource();

        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<ItemDataSource> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
