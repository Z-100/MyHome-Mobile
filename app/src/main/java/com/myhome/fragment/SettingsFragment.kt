package com.myhome.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.myhome.R
import com.myhome.databinding.FragmentSettingsBinding

/**
 * @author z-100
 */
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun generateBindings() {
        binding.navbarButtons.backButton.setOnClickListener {
            findNavController().navigate(R.id.dashboard_to_members) // TODO Implement thingy
        }

        binding.navigationButtons.homeButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_home)
        }

        binding.navigationButtons.roomsButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_rooms)
        }

        binding.navigationButtons.kitchenButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_kitchen)
        }


        binding.manageMembersButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_members) //TODO Change or smth
        }

        binding.manageSmartDevicesButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_members) //TODO SmartDevice thingy
        }

        binding.changePasswordButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_members) //TODO Password change
        }

        binding.manageMembersButton.setOnClickListener {

        }

        binding.manageMembersButton.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
