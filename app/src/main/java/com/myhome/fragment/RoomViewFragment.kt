package com.myhome.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.myhome.R
import com.myhome.databinding.FragmentRoomViewBinding

/**
 * @author z-100
 */
class RoomViewFragment : Fragment() {

    private var _binding: FragmentRoomViewBinding? = null
    private val binding get() = _binding!!

    private val args: DashboardFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentRoomViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateBindings()

    }
    private fun generateBindings() {
        binding.navigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.footer_home_btn -> findNavController().navigate(RoomViewFragmentDirections.roomsToDashboard().setBackButton(R.id.dashboard_to_rooms))
                R.id.footer_kitchen_btn -> findNavController().navigate(RoomViewFragmentDirections.roomsToKitchen().setBackButton(R.id.kitchen_to_rooms))
                R.id.footer_rooms_btn -> findNavController().navigate(RoomViewFragmentDirections.roomsToRooms().setBackButton(R.id.rooms_to_rooms))
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
