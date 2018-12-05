package com.example.tsvetomirtonchev.userwiki.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tsvetomirtonchev.userwiki.R;
import com.example.tsvetomirtonchev.userwiki.data.model.response.user.User;
import com.example.tsvetomirtonchev.userwiki.ui.base.BaseFragment;
import com.example.tsvetomirtonchev.userwiki.ui.custom.CustomKeyValueView;
import com.example.tsvetomirtonchev.userwiki.util.AddressUtils;
import com.example.tsvetomirtonchev.userwiki.util.SharedPreferenceManager;

/**
 * Created by tsvetomir.tonchev on 19,Ноември,2018 1.2. Информация за всеки потребител
 */
public class MyProfileFragment extends BaseFragment {
    //Views
    private CustomKeyValueView mUsernameKV;
    private CustomKeyValueView mEmailKV;
    private CustomKeyValueView mAddress;

    public MyProfileFragment() {
        // Required empty public constructor
    }

    public static MyProfileFragment newInstance() {
        MyProfileFragment fragment = new MyProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initializedViews(view);
        setUpViews();

        return view;
    }

    private void setUpViews() {
        User user = SharedPreferenceManager.getInstance(getActivity()).getCurrentUser();
        mUsernameKV.setTitle("Name");
        mUsernameKV.setValue(user.getName());
        mEmailKV.setTitle("Email");
        mEmailKV.setValue(user.getEmail());
        mAddress.setTitle("Address");
        mAddress.setValue(AddressUtils.getFullAddress(user.getAddress()));
    }

    private void initializedViews(View view) {
        mUsernameKV = view.findViewById(R.id.my_profile_username_key_value);
        mEmailKV = view.findViewById(R.id.my_profile_email_key_value);
        mAddress = view.findViewById(R.id.my_profile_address_key_value);
    }
}
