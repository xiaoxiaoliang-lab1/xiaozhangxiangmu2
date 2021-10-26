package test;

import entity.TaxOrgan;
import entity.TaxPayer;
import entity.TaxSource;
import entity.Taxer;
import untity.conntion;
import untity.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {

        dao da=new dao();
//        TaxSource taxSource = da.selectSourceById(5);
//        System.out.println(taxSource.getTaskName());
        List<Map<String, String>> searchResult = da.getSearchResult(1, 2, null);
        for (Map<String, String> mp: searchResult) {
            System.out.println(mp);
        }



    }
}
