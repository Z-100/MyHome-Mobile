package com.myhome;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.myhome.databinding.ActivityMainBinding;

/**
 * This is the apps entry point
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
