package com.myhome.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.myhome.R
import com.myhome.databinding.FragmentHelpBinding

/**
 * @author z-100
 */
class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateBindings()
    }

    private fun generateBindings() {

        binding.navigationBar.setOnItemSelectedListener {
                item -> when (item.itemId) {
            R.id.footer_home_btn -> findNavController().navigate(R.id.help_to_dashboard)
            R.id.footer_kitchen_btn -> findNavController().navigate(R.id.help_to_kitchen)
            R.id.footer_rooms_btn -> findNavController().navigate(R.id.help_to_rooms)
        }
            true
        }

        binding.topNavbar.backButton.setOnClickListener {
            findNavController().navigate(R.id.help_to_settings)
        }

        binding.topNavbar.accountSettingsButton.setOnClickListener{
            findNavController().navigate(R.id.help_to_settings)
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
