package com.noname.fastmoney.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.noname.fastmoney.data.entities.CatalogItems;
import com.noname.fastmoney.databinding.ActivityCatalogBinding;
import com.noname.fastmoney.presentation.adapters.RecyclerCatalogItemsAdapter;

import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    private ActivityCatalogBinding mBinding;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerCatalogItemsAdapter mAdapter;
    private List<CatalogItems> mItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCatalogBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        setTitle("Список предложений");

        if(Utils.country.equalsIgnoreCase("uk")){
            mItemsList = CatalogItems.getCatalogItemsUk();
        } else {
            mItemsList = CatalogItems.getCatalogItemsRu();
        }

        mLayoutManager = new GridLayoutManager(this, 2);
        mBinding.recyclerCatalog.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerCatalogItemsAdapter(mItemsList, this);
        mBinding.recyclerCatalog.setAdapter(mAdapter);

    }
}