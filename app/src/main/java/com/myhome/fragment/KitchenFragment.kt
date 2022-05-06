package com.myhome.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.myhome.R
import com.myhome.api.impl.KitchenApiService
import com.myhome.databinding.FragmentKitchenBinding
import com.myhome.other.ApiConstants
import com.myhome.other.Session
import com.myhome.other.SharedPreferencesStrings
import org.json.JSONException

/**
 * @author z-100
 */
class KitchenFragment : Fragment() {

    private var _binding: FragmentKitchenBinding? = null
    private val binding get() = _binding!!

    private val args: DashboardFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentKitchenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateBindings()
    }
    private fun generateBindings() {
        binding.navigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.footer_home_btn -> findNavController().navigate(KitchenFragmentDirections.kitchenToDashboard().setBackButton(R.id.kitchen_to_dashboard))
                R.id.footer_kitchen_btn -> findNavController().navigate(KitchenFragmentDirections.kitchenToKitchen().setBackButton(R.id.kitchen_to_kitchen))
                R.id.footer_rooms_btn -> findNavController().navigate(KitchenFragmentDirections.kitchenToRooms().setBackButton(R.id.rooms_to_kitchen))
            }
            true
        }

        binding.topNavbar.backButton.setOnClickListener {
            if (args.backButton != -1)
                findNavController().navigate(args.backButton)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
