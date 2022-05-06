package com.myhome.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.myhome.R
import com.myhome.databinding.FragmentRegisterBinding
import com.myhome.other.Strings

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateBindings()
    }

    private fun generateBindings() {
        binding.submitButton.isEnabled = false
        binding.submitButton.setOnClickListener {
            if (noFieldEmpty()) {
                findNavController().navigate(R.id.register_to_members)
            } else
            //TODO Check if email taken
            Snackbar.make(view!!, Strings.FILL_IN_ALL_FIELDS, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        binding.loginInsteadButton.setOnClickListener {
            findNavController().navigate(R.id.register_to_login)
        }

        binding.inputEmail.doOnTextChanged {
                _,_,_,_ -> binding.submitButton.isEnabled = noFieldEmpty()
        }

        binding.inputPassword.doOnTextChanged {
                _,_,_,_ -> binding.submitButton.isEnabled = noFieldEmpty()
        }

        binding.inputRepeatPassword.doOnTextChanged {
                _,_,_,_ -> binding.submitButton.isEnabled = noFieldEmpty()
        }
    }

    private fun noFieldEmpty(): Boolean {
        return binding.inputEmail.text.toString().trim().isNotEmpty()
                && binding.inputPassword.text.toString().trim().isNotEmpty()
                && binding.inputRepeatPassword.text.toString().trim().isNotEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
