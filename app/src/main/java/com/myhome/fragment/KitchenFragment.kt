package com.myhome.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.myhome.R
import com.myhome.databinding.FragmentKitchenBinding

/**
 * @author z-100
 */
class KitchenFragment : Fragment() {

    private var _binding: FragmentKitchenBinding? = null
    private val binding get() = _binding!!

    private val args: KitchenFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentKitchenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateBindings()
    }
    private fun generateBindings() {
        binding.navigationBar.setOnItemSelectedListener {
            item -> when (item.itemId) {
                R.id.footer_home_btn -> findNavController().navigate(KitchenFragmentDirections.kitchenToDashboard().setBackButton(R.id.dashboard_to_kitchen))
                R.id.footer_kitchen_btn -> findNavController().navigate(KitchenFragmentDirections.kitchenToKitchen().setBackButton(R.id.kitchen_to_kitchen))
                R.id.footer_rooms_btn -> findNavController().navigate(KitchenFragmentDirections.kitchenToRooms().setBackButton(R.id.rooms_to_kitchen))
            }
            true
        }

        binding.topNavbar.backButton.setOnClickListener {
            if (args.backButton != -1)
                findNavController().navigate(args.backButton)
        }

        binding.topNavbar.accountSettingsButton.setOnClickListener {
            findNavController().navigate(KitchenFragmentDirections.kitchenToSettings().setBackButton(R.id.settings_to_kitchen))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
