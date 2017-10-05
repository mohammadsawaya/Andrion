package com.android2017.session09_listviewfullproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;



public class ListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "par_Name";;

    ListView listViewob;
    List<Company> companyList;

    // TODO: Rename and change types of parameters
    private String name;

    public ListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String name) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View fragmentView=inflater.inflate(R.layout.fragment_list, container, false);

        companyList = CompaniesDataSourse.getCompanyList();
        listViewob= (ListView) fragmentView.findViewById(R.id.listView1);
//         ArrayAdapter<Company> adapter = new ArrayAdapter<Company>(this, android.R.layout.simple_list_item_1, companyList);
        CompanyAdapter adapter = new CompanyAdapter(getActivity().getApplication(), companyList);

        listViewob.setAdapter(adapter);

        listViewob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Company company = companyList.get(i);

                Intent intent = new Intent(getActivity().getApplication(), CompanyActivity.class);
                intent.putExtra("company", company);

//                intent.putExtra("companyName", company.getName());
//                intent.putExtra("companyCountry", company.getCountry());
//                intent.putExtra("companyYear", company.getYear());

                startActivity(intent);
            }
        });


        return fragmentView;
    }

}
