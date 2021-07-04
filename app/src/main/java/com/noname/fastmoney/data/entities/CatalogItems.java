package com.noname.fastmoney.data.entities;

import com.noname.fastmoney.R;

import java.util.ArrayList;
import java.util.List;

public class CatalogItems {

    public String description;
    public int image;
    public String url;

    public CatalogItems(String description, int image, String url) {
        this.description = description;
        this.image = image;
        this.url = url;
    }

    public static List<CatalogItems> getCatalogItems(){
        List<CatalogItems> mCatalogItems = new ArrayList<>();
        mCatalogItems.add(new CatalogItems("Заполните заявку и получайте одобрение через несколько минут", R.drawable.grivni, "https://pxl.leads.su/click/46b78843fe284ea33997448f77dc3611"));
        mCatalogItems.add(new CatalogItems("Займ до 20000 гривен мгновенно", R.drawable.dinero, "https://pxl.leads.su/click/de657f5d1a0146f54f7bbf2d36c6514a"));
        mCatalogItems.add(new CatalogItems("Деньги внутри, считайте и забирайте до 17000 грн", R.drawable.mycredit, "https://pxl.leads.su/click/e2f42e2c6cb64c711d0110da84939416"));
        mCatalogItems.add(new CatalogItems("Займ мгновенно и быстро", R.drawable.kviku, "https://go.leadgid.ru/aff_c?offer_id=5014&aff_id=62468"));
        mCatalogItems.add(new CatalogItems("До 10000 грн под 0,01% в день", R.drawable.creditplus, "https://go.leadgid.ru/aff_c?offer_id=2837&aff_id=62468"));
        mCatalogItems.add(new CatalogItems("0,01% в день до 10000 гривен", R.drawable.creditkasa, "https://order.zaim-srochno24.ru/click/d01e7162bb26f690cff0ce06dec49def"));
        mCatalogItems.add(new CatalogItems("Кредит-онлайн на карту 0,01%", R.drawable.shvidco, "https://pxl.leads.su/click/7a80d9b37c2aeca3da2ea99937f664ec"));
        mCatalogItems.add(new CatalogItems("Получите деньги за 7 минут от 600 до 10000 гривен", R.drawable.creditseven, "https://go.leadgid.ru/aff_c?offer_id=4458&aff_id=62468"));
        mCatalogItems.add(new CatalogItems("До 20000 гривен без процентов", R.drawable.miloan, "https://pxl.leads.su/click/8930c9c2bffea9ec60ea7a344063479b"));
        mCatalogItems.add(new CatalogItems("Дадим первый заем! Займ 0% до 15000 грн да 5 минут", R.drawable.ccloan, "https://go.leadgid.eu/aff_c?offer_id=4265&aff_id=62468"));
        mCatalogItems.add(new CatalogItems("Займ от 0% до 12000 гривен за 5 минут", R.drawable.alexcredit, "https://pxl.leads.su/click/c9661d12dc51bbd488b589fabf0f7145"));
        mCatalogItems.add(new CatalogItems("Займ до 15000 гривен за 5 минут", R.drawable.groshivsem, "https://pxl.leads.su/click/5e6ed2c87f904c28b3c92117cc45ed3c"));
        mCatalogItems.add(new CatalogItems("Займ от 2000 доо 10000 гривен", R.drawable.gofingo, "https://pxl.leads.su/click/c89fbc68dc7517eca730deded8a5c6fd"));
        mCatalogItems.add(new CatalogItems("Заполните заявку и получайте одобрение через несколько минут", R.drawable.creditkassa, "https://pxl.leads.su/click/732ea3c79b4c6fdb1b2ef0392ef499cb"));
        mCatalogItems.add(new CatalogItems("Не переживай, мы позабоотимся о твоих финансах", R.drawable.gcredit, "https://pxl.leads.su/click/af17a18823cbe743c636f2e00d37ebc5"));

        return mCatalogItems;
    }
}
