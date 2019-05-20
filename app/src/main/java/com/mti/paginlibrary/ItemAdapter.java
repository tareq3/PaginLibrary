/*
 * Created by Tareq Islam on 5/19/19 2:31 PM
 *
 *  Last modified 5/19/19 2:31 PM
 */

package com.mti.paginlibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mti.paginlibrary.model.Outlet;

/***
 * Created by mtita on 19,May,2019.
 */
public class ItemAdapter extends PagedListAdapter<Outlet, ItemAdapter.ItemViewHolder> {

    private Context mContext;

    public ItemAdapter( Context context) {
        super(DIFF_CALLBACK);
        mContext = context;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
       Outlet item = getItem(position);

        if (item != null) {
/*
            Glide.with(mContext)
                    .load(item.owner.profile_image)
                    .into(holder.imageView);*/

            holder.textView.setText(item.getName());
        } else {
            Toast.makeText(mContext, "Item is null", Toast.LENGTH_LONG).show();
        }
    }

    private static DiffUtil.ItemCallback<Outlet> DIFF_CALLBACK=
            new DiffUtil.ItemCallback<Outlet>() {

                @Override
                public boolean areItemsTheSame(@NonNull Outlet oldItem, @NonNull Outlet newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Outlet oldItem, @NonNull Outlet newItem) {
                    return oldItem.equals(newItem);
                }
            };


    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textViewName);
        }
    }
}
