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
import com.myhome.databinding.FragmentLoginBinding
import com.myhome.other.Strings

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateBindings()
    }

    private fun generateBindings() {
        binding.submitButton.isEnabled = false
        binding.submitButton.setOnClickListener {
            if (checkEmptyFields()) {
                //TODO Login stuff
                findNavController().navigate(R.id.login_to_members)
            } else
                Snackbar.make(view!!, Strings.FILL_IN_ALL_FIELDS, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        binding.registerInsteadButton.setOnClickListener {
            findNavController().navigate(R.id.login_to_register)
        }

        binding.inputEmail.doOnTextChanged {
                _,_,_,_ -> binding.submitButton.isEnabled = checkEmptyFields()
        }

        binding.inputPassword.doOnTextChanged {
                _,_,_,_ -> binding.submitButton.isEnabled = checkEmptyFields()
        }
    }

    private fun checkEmptyFields(): Boolean {
        return binding.inputEmail.text.toString().trim().isNotEmpty()
                && binding.inputPassword.text.toString().trim().isNotEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
