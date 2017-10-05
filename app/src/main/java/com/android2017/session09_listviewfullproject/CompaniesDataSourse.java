package com.android2017.session09_listviewfullproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 26/09/2017.
 */

public class CompaniesDataSourse {
    private static List<Company> companyList = new ArrayList<>();

    public static List<Company> getCompanyList() {
        Company c1 = new Company("Google", "USA", 1998);
        Company c2 = new Company("Apple", "USA", 1976);
        Company c3 = new Company("Samsung", "South Korea", 1938);

        companyList.add(c1);
        companyList.add(c2);
        companyList.add(c3);

        return companyList;
    }
}
