package com.andrepaiva.f1info.utils;

import com.andrepaiva.f1info.R;

/**
 * Created by andre on 17/05/2017.
 */

public class FlagUtils {

    public static int getFlagResource(String country) {
        int id = 0;
        switch (country){
            case "Australia":
                id = R.mipmap.australia;
                break;
            case "China":
                id = R.mipmap.china;
                break;
            case "Bahrain":
                id = R.mipmap.bahrain;
                break;
            case "Russia":
                id = R.mipmap.russia;
                break;
            case "Spain":
                id = R.mipmap.spain;
                break;
            case "Monaco":
                id = R.mipmap.monaco;
                break;
            case "Canada":
                id = R.mipmap.canada;
                break;
            case "Azerbaijan":
                id = R.mipmap.azerbaijan;
                break;
            case "Austria":
                id = R.mipmap.austria;
                break;
            case "UK":
                id = R.mipmap.uk;
                break;
            case "Hungary":
                id = R.mipmap.hungary;
                break;
            case "Belgium":
                id = R.mipmap.belgium;
                break;
            case "Italy":
                id = R.mipmap.italy;
                break;
            case "Singapore":
                id = R.mipmap.singapore;
                break;
            case "Malaysia":
                id = R.mipmap.malaysia;
                break;
            case "Japan":
                id = R.mipmap.japan;
                break;
            case "USA":
                id = R.mipmap.usa;
                break;
            case "Mexico":
                id = R.mipmap.mexico;
                break;
            case "Brazil":
                id = R.mipmap.brazil;
                break;
            case "UAE":
                id = R.mipmap.uae;
                break;

        }
        return id;
    }

    public static int getFlagByNationality(String nationality){
        int id = 0;
        switch (nationality){
            case "Australian":
                id = R.mipmap.australia;
                break;
            case "Russian":
                id = R.mipmap.russia;
                break;
            case "Spanish":
                id = R.mipmap.spain;
                break;
            case "Canadian":
                id = R.mipmap.canada;
                break;
            case "Austrian":
                id = R.mipmap.austria;
                break;
            case "British":
                id = R.mipmap.england;
                break;
            case "Belgian":
                id = R.mipmap.belgium;
                break;
            case "Italian":
                id = R.mipmap.italy;
                break;
            case "Japanese":
                id = R.mipmap.japan;
                break;
            case "American":
                id = R.mipmap.usa;
                break;
            case "Mexican":
                id = R.mipmap.mexico;
                break;
            case "Brazilian":
                id = R.mipmap.brazil;
                break;
            case "Swedish":
                id = R.mipmap.sweden;
                break;
            case "Danish":
                id = R.mipmap.denmark;
                break;
            case "German":
                id = R.mipmap.germany;
                break;
            case "French":
                id = R.mipmap.france;
                break;
            case "Dutch":
                id = R.mipmap.netherlands;
                break;
            case "Finnish":
                id = R.mipmap.finland;
                break;
            case "Indian":
                id = R.mipmap.india;
                break;
            case "Swiss":
                id = R.mipmap.switzerland;
                break;

        }
        return id;
    }
}
