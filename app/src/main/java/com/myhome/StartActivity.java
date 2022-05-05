package com.myhome;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.myhome.blueprint.Account;
import com.myhome.databinding.ActivityStartBinding;
import com.myhome.other.Session;
import com.myhome.other.SharedPreferencesStrings;
import com.myhome.service.data.DataHandlingService;

/**
 * @author z-100
 * This is the apps entry point
 */
public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Session.Factory.get() != null)
            if (loadDataOnLogin()){}


        binding = ActivityStartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    /**
     * Retrieve data from handler
     * @return true if account has been found
     */
    private boolean loadDataOnLogin() {
        final DataHandlingService dataHandler = new DataHandlingService();

        final Account accountFromSp = dataHandler.loadData(getSharedPreferences(
                SharedPreferencesStrings.SHARED_PREF_NAME, Context.MODE_PRIVATE));

        if (accountFromSp == null)
            return false;

        Session.Factory.create(accountFromSp);
        return true;
    }
}
