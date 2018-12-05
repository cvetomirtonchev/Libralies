package com.example.tsvetomirtonchev.userwiki.util;

import com.example.tsvetomirtonchev.userwiki.data.model.response.user.UserAddress;

/**
 * Created by tsvetomir.tonchev on 20,Ноември,2018
 */
public class AddressUtils {

    public static String getFullAddress(UserAddress address){
        String fullAddress = "";
        if (address != null) {
            fullAddress = address.getCity() + ", " + address.getStreet() + ", " + address.getSuite() + " ";
        }
        return fullAddress;
    }
}
