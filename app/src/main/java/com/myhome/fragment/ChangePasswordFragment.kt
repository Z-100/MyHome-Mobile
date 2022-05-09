package com.myhome.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.myhome.R
import com.myhome.databinding.FragmentChangePasswordBinding
import com.myhome.other.Strings

/**
 * @author z-100
 */
class ChangePasswordFragment : Fragment() {

    private var _binding: FragmentChangePasswordBinding? = null
    private val binding get() = _binding!!

    private val args: ChangePasswordFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateBindings()
    }

    private fun generateBindings() {
        binding.navigationBar.setOnItemSelectedListener {
                item -> when (item.itemId) {
            R.id.footer_home_btn -> findNavController().navigate(ChangePasswordFragmentDirections.changePwToDashboard().setBackButton(
                R.id.home_to_change_password))
            R.id.footer_kitchen_btn -> findNavController().navigate(ChangePasswordFragmentDirections.changePwToKitchen().setBackButton(
                R.id.kitchen_to_change_password))
            R.id.footer_rooms_btn -> findNavController().navigate(ChangePasswordFragmentDirections.changePwToRooms().setBackButton(
                R.id.rooms_to_change_password))
        }
            true
        }

        binding.topNavbar.backButton.setOnClickListener {
            if (args.backButton != -1)
                findNavController().navigate(args.backButton)
        }

        binding.topNavbar.accountSettingsButton.setOnClickListener {
            findNavController().navigate(ChangePasswordFragmentDirections.changePwToSettings().setBackButton(
                R.id.settings_to_change_password))
        }

        binding.cancelButton.setOnClickListener() {
            findNavController().navigate(ChangePasswordFragmentDirections.changePwToSettings().setBackButton(
                R.id.settings_to_change_password))
        }
        binding.confirmButton.setOnClickListener() {
            findNavController().navigate(ChangePasswordFragmentDirections.changePwToSettings().setBackButton(
                R.id.settings_to_change_password))

            Snackbar.make(view!!, Strings.CONFIRM_PASSWORD_CHANGE, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
