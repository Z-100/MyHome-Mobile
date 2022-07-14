package com.myhome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.myhome.databinding.ActivityMainBinding;
import com.myhome.fragment.MembersFragment;
import com.myhome.other.Session;
import com.myhome.other.SharedPref;
import com.myhome.service.data.DataHandlingService;

public class Application extends AppCompatActivity {

    private ActivityMainBinding binding;

    public static SharedPreferences sp;
    public static RequestQueue queue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = this.getSharedPreferences(SharedPref.GENERAL, Context.MODE_PRIVATE);
        queue = Volley.newRequestQueue(this.getApplicationContext());

        loadDataOnLogin();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void loadDataOnLogin() {

        final DataHandlingService dataHandler = new DataHandlingService();
        dataHandler.loadData();
    }
}
