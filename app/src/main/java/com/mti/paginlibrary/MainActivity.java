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

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.mti.paginlibrary.api.RetrofitClient;
import com.mti.paginlibrary.util.Constants;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private static ProgressBar mProgressBar;
    ItemViewModel itemViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mProgressBar = findViewById(R.id.progress_bar);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    itemViewModel  = ViewModelProviders.of(this).get(ItemViewModel.class);
        final ItemAdapter adapter = new ItemAdapter(this);
        itemViewModel.itemPagedList.observe(this, items->{

            adapter.submitList(items);
        });

        itemViewModel.getNetworkState().observe(this, new Observer<Constants.NETWORK_STATE>() {
            @Override
            public void onChanged(Constants.NETWORK_STATE networkState) {
                if(networkState.equals(Constants.NETWORK_STATE.LOADING))
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);



        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.
                getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchOutlet(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    private void searchOutlet(String query) {
        query=query.trim();
        if(!query.isEmpty()){
       //     RetrofitClient.getInstance().getApiService().
        }

            }
}
