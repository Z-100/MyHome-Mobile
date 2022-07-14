package com.myhome.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.myhome.R
import com.myhome.databinding.FragmentSettingsBinding
import com.myhome.other.Session
import com.myhome.service.data.DataHandlingService
import android.widget.AdapterView.OnItemClickListener
import com.myhome.blueprint.Member
import com.myhome.other.GridAdapter

/**
 * @author z-100
 */
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val args: SettingsFragmentArgs by navArgs()
    private val dataHandler = DataHandlingService()

    private var members = Session.getAllMembers()!!.members

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

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
                R.id.footer_home_btn ->  findNavController().navigate(SettingsFragmentDirections.settingsToDashboard().setBackButton(
                    R.id.dashboard_to_settings))

                R.id.footer_kitchen_btn -> findNavController().navigate(SettingsFragmentDirections.settingsToKitchen().setBackButton(
                    R.id.kitchen_to_settings))

                R.id.footer_rooms_btn -> findNavController().navigate(SettingsFragmentDirections.settingsToRooms().setBackButton(
                    R.id.rooms_to_settings))
            }
            true
        }

        binding.topNavbar.backButton.setOnClickListener {
            if (args.backButton != -1)
                findNavController().navigate(args.backButton)
        }

        binding.topNavbar.accountSettingsButton.setOnClickListener{
            findNavController().navigate(SettingsFragmentDirections.settingsToSettings().setBackButton(
                R.id.settings_to_settings))
        }

        val gridAdapter = GridAdapter(context, members, R.layout.settings_grid_item)
        binding.gridView.adapter = gridAdapter

        binding.gridView.onItemClickListener = OnItemClickListener {
                _, _, _, _ -> members
            }
        binding.helpButton.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.settingsToHelp().setBackButton(
                R.id.help_to_settings))
        }


        binding.deleteAccountButton.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.settingsToDeleteAccount().setBackButton(
                R.id.delete_acc_to_settings))
        }


        binding.manageMembersButton.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.settingsToChangePassword().setBackButton(
                R.id.change_pw_to_settings))
        }

        binding.manageSmartDevicesButton.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.settingsToEditMembers().setBackButton(
                R.id.edit_members_to_settings))
        }

        binding.changePasswordButton.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.settingsToChangePassword().setBackButton(
                R.id.change_pw_to_settings))
        }

        binding.signoffButton.setOnClickListener {
            dataHandler.saveData()
            Session.destroy()
            findNavController().navigate(R.id.settings_to_sign_off)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
