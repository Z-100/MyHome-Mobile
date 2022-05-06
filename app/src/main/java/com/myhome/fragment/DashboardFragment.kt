package com.myhome.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.myhome.R
import com.myhome.databinding.FragmentDashboardBinding

/**
 * @author z-100
 */
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
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



//        binding.navbarButtons.backButton.setOnClickListener {
//            findNavController().navigate(R.id.dashboard_to_members) // TODO Implement thingy
//        }
//
//        binding.navbarButtons.profileButton.setOnClickListener {
//            findNavController().navigate(R.id.action_members_to_dashboard) // TODO Add profile thingy
//        }
//
//        binding.navigationButtons.homeButton.setOnClickListener {
//            // Empty as were already in "home"
//        }
//
//        binding.navigationButtons.roomsButton.setOnClickListener {
//            findNavController().navigate(R.id.dashboard_to_rooms)
//        }
//
//        binding.navigationButtons.kitchenButton.setOnClickListener {
//            findNavController().navigate(R.id.dashboard_to_kitchen)
//        }
//
//
//        binding.rateMeal.setOnClickListener {
//            findNavController().navigate(R.id.dashboard_to_kitchen) //TODO Implement with link to meal. Just scroll to position where meals are
//        }
//
//        binding.shoppinglistButton.setOnClickListener {
//            findNavController().navigate(R.id.dashboard_to_kitchen) //TODO Implement with link to shopping list. Just scroll to position where shopping list is
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
