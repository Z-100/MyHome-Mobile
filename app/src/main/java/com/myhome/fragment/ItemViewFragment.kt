package com.myhome.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.myhome.databinding.FragmentItemViewBinding

/**
 * @author z-100
 */
class ItemViewFragment : Fragment() {

    private var _binding: FragmentItemViewBinding? = null
    private val binding get() = _binding!!

    private val args: DashboardFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentItemViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun generateBindings() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
