package com.noname.fastmoney.presentation.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noname.fastmoney.R;
import com.noname.fastmoney.data.entities.CatalogItems;
import com.noname.fastmoney.presentation.activities.WebViewActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerCatalogItemsAdapter extends RecyclerView.Adapter<RecyclerCatalogItemsAdapter.ViewHolder> {

    private List<CatalogItems> mCatalogItems = new ArrayList<>();
    private Context mContext;

    public RecyclerCatalogItemsAdapter(List<CatalogItems> catalogItems, Context context) {
        mCatalogItems = catalogItems;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CatalogItems catalogItems = mCatalogItems.get(position);

        Picasso.get()
                .load(catalogItems.image)
                .into(holder.mImageView);

        holder.mDescription.setText(catalogItems.description);
        holder.mBtnGetMoney.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, WebViewActivity.class);
            intent.putExtra("url", catalogItems.url);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mCatalogItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mDescription;
        Button mBtnGetMoney;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_catalog_item);
            mDescription = itemView.findViewById(R.id.description_item);
            mBtnGetMoney = itemView.findViewById(R.id.btn_get_money);
        }


    }
}
