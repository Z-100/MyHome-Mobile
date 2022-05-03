package com.myhome.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.myhome.R
import com.myhome.databinding.FragmentMembersBinding
import com.myhome.other.Session

class MembersFragment : Fragment() {

    private var _binding: FragmentMembersBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentMembersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateBindings()
    }

    private fun generateBindings() {
        binding.navigationButtons.backButton.setOnClickListener {
            Session.destroy()
            findNavController().navigate(R.id.members_to_login)
        }

        binding.navigationButtons.profileButton.setOnClickListener {
            findNavController().navigate(R.id.members_to_dashboard) // TODO Add profile thingy
        }

        binding.addMemberButton.setOnClickListener {
            findNavController().navigate(R.id.members_to_dashboard) // TODO Add members thingy
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
