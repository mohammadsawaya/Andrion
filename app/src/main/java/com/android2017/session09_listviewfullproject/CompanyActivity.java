package com.android2017.session09_listviewfullproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class CompanyActivity extends AppCompatActivity {
    ImageView imageIcon;
    TextView textName;
    TextView textCountry;
    TextView textYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        imageIcon = (ImageView) findViewById(R.id.imageIcon);
        textName = (TextView) findViewById(R.id.textName);
        textCountry = (TextView) findViewById(R.id.textCountry);
        textYear = (TextView) findViewById(R.id.textYear);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Company company = (Company) extras.getSerializable("company");

            textName.setText(getString(R.string.company_name) + " " + company.getName());
            textCountry.setText(getString(R.string.company_country) + " " + company.getCountry());
            textYear.setText(getString(R.string.company_year) + " " + company.getYear());

            String iconName = company.getName().toLowerCase();
            int id = getResources().getIdentifier(iconName, "drawable", getPackageName());
            imageIcon.setImageResource(id);

            getSupportActionBar().setTitle(company.getName());

        }
    }
}
