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
import com.myhome.databinding.FragmentDeleteAccountBinding
import com.myhome.other.Strings

/**
 * @author z-100
 */
class DeleteAccountFragment : Fragment() {

    private var _binding: FragmentDeleteAccountBinding? = null
    private val binding get() = _binding!!


    private val args: DeleteAccountFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentDeleteAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateBindings()
    }

    private fun generateBindings() {
        binding.navigationBar.setOnItemSelectedListener {
                item -> when (item.itemId) {
            R.id.footer_home_btn -> findNavController().navigate(DeleteAccountFragmentDirections.deleteAccToHome().setBackButton(
                R.id.home_to_delete_acc))
            R.id.footer_kitchen_btn -> findNavController().navigate(DeleteAccountFragmentDirections.deleteAccToKitchen().setBackButton(
                R.id.kitchen_to_delete_acc))
            R.id.footer_rooms_btn -> findNavController().navigate(DeleteAccountFragmentDirections.deleteAccToRooms().setBackButton(
                R.id.rooms_to_delete_acc))
        }
            true
        }

        binding.topNavbar.backButton.setOnClickListener {
            if (args.backButton != -1)
                findNavController().navigate(args.backButton)
        }

        binding.topNavbar.accountSettingsButton.setOnClickListener {
            findNavController().navigate(DeleteAccountFragmentDirections.deleteAccToSettings().setBackButton(
                R.id.settings_to_delete_account))
        }

        binding.cancelButton.setOnClickListener() {
            findNavController().navigate(DeleteAccountFragmentDirections.deleteAccToSettings().setBackButton(
                R.id.settings_to_delete_account))
        }
        binding.confirmButton.setOnClickListener() {
            findNavController().navigate(DeleteAccountFragmentDirections.deleteAccToLogin())

            Snackbar.make(view!!, "Your account has been successfully deleted", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
    }

}
