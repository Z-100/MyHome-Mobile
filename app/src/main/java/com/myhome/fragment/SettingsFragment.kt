package com.myhome.fragment

import android.content.Context
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
import com.myhome.other.SpStrings
import com.myhome.service.data.DataHandlingService
import android.widget.AdapterView.OnItemClickListener
import com.myhome.other.GridAdapter

/**
 * @author z-100
 */
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val args: SettingsFragmentArgs by navArgs()
    private val dataHandler = DataHandlingService()

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
                R.id.footer_home_btn -> findNavController().navigate(R.id.settings_to_dashboard)
                R.id.footer_kitchen_btn -> findNavController().navigate(R.id.settings_to_kitchen)
                R.id.footer_rooms_btn -> findNavController().navigate(R.id.settings_to_rooms)
            }
            true
        }

        binding.topNavbar.backButton.setOnClickListener {
            if (args.backButton != -1)
                findNavController().navigate(args.backButton)
        }

        binding.topNavbar.accountSettingsButton.setOnClickListener{
            findNavController().navigate(R.id.settings_to_settings)
        }

        val gridAdapter = GridAdapter(context, Session.getMembers(), R.layout.settings_grid_item)
        binding.gridView.adapter = gridAdapter

        binding.gridView.onItemClickListener = OnItemClickListener {
                _, _, position, _ -> Session.getMembers()
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
            dataHandler.saveData(
                context!!.getSharedPreferences(
                    SpStrings.SP_NAME_ACC,
                    Context.MODE_PRIVATE
                ), null
            )
            Session.destroy()
            findNavController().navigate(R.id.settings_to_sign_off)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
