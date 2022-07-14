package com.myhome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.myhome.databinding.ActivityMainBinding;
import com.myhome.fragment.MembersFragment;
import com.myhome.other.Session;
import com.myhome.other.SharedPref;
import com.myhome.service.data.DataHandlingService;

/**
 * @author z-100
 * This is the apps entry point
 */
public class Application extends AppCompatActivity {

    private ActivityMainBinding binding;

    public static SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadDataOnLogin();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void loadDataOnLogin() {
        sp = this.getSharedPreferences(SharedPref.GENERAL, Context.MODE_PRIVATE);

        final DataHandlingService dataHandler = new DataHandlingService();
        dataHandler.loadData();
    }
}
