/*
 * Created by Tareq Islam on 5/19/19 10:29 AM
 *
 *  Last modified 5/19/19 10:28 AM
 */

package com.mti.paginlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.mti.paginlibrary.model.OutletResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private static ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mProgressBar = findViewById(R.id.progress_bar);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        final ItemAdapter adapter = new ItemAdapter(this);
        itemViewModel.itemPagedList.observe(this, items->{

            adapter.submitList(items);
        });

        itemViewModel.getNetworkState().observe(this, new Observer<ItemDataSource.NETWORK_STATE>() {
            @Override
            public void onChanged(ItemDataSource.NETWORK_STATE networkState) {
                if(networkState.equals(ItemDataSource.NETWORK_STATE.LOADING))
                    showProgress();
                else
                    hideProgress();
            }
        });

        recyclerView.setAdapter(adapter);


    }

  public static   void showProgress(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

  public static   void hideProgress(){
        mProgressBar.setVisibility(View.GONE);
    }
}
