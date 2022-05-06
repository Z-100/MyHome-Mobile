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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateBindings()
    }



    private fun generateBindings() {

        binding.navigationBar.setOnItemSelectedListener {
                item -> when (item.itemId) {
            R.id.footer_home_btn -> findNavController().navigate(R.id.dashboard_to_dashboard)
            R.id.footer_kitchen_btn -> findNavController().navigate(R.id.dashboard_to_kitchen)
            R.id.footer_rooms_btn -> findNavController().navigate(R.id.dashboard_to_rooms)
        }
            true
        }

        binding.topNavbar.backButton.setOnClickListener {
        }

        binding.topNavbar.accountSettingsButton.setOnClickListener{
            findNavController().navigate(R.id.dashboard_to_settings)
        }


        binding.helpButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_help)
        }


        binding.deleteAccountButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_delete_account)
        }


        binding.manageMembersButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_members)
        }

        binding.manageSmartDevicesButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_smart_devices)
        }

        binding.changePasswordButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_change_password)
        }

        binding.signoffButton.setOnClickListener {
            findNavController().navigate(R.id.settings_to_sign_off)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
