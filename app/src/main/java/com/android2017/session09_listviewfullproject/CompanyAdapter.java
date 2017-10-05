package com.android2017.session09_listviewfullproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mac on 26/09/2017.
 */

public class CompanyAdapter extends ArrayAdapter<Company> {

    Context context;
    List<Company> companyList;

    public CompanyAdapter(@NonNull Context context, @NonNull List<Company> companyList) {
        super(context, R.layout.listitem_company, companyList);

        this.context = context;
        this.companyList = companyList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView = inflater.inflate(R.layout.listitem_company, parent, false);

        TextView textName = listItemView.findViewById(R.id.textName);
        TextView textCountry = listItemView.findViewById(R.id.textCountry);
        ImageView imageIcon = listItemView.findViewById(R.id.imageIcon);

        Company company = companyList.get(position);

        textName.setText(company.getName());
        textCountry.setText(company.getCountry());

        try {
            String iconName = company.getName().toLowerCase();
            int id = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());
            imageIcon.setImageResource(id);
        } catch (Exception ex) {
            // imageIcon.setImageResource(R.drawable.defaultcompany);
        }

        return listItemView;
    }
}
