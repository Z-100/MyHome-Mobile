package com.myhome.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.myhome.R
import com.myhome.service.api.components.impl.AccountApiService
import com.myhome.blueprint.Account
import com.myhome.databinding.FragmentRegisterBinding
import com.myhome.other.ApiConstants
import com.myhome.other.SharedPref
import com.myhome.other.Strings
import com.myhome.service.data.DataHandlingService
import java.lang.Exception

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private var accountService = AccountApiService()
    private var dataService = DataHandlingService()

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
            if (noFieldEmpty()) register()
             else Snackbar.make(view!!, Strings.FILL_IN_ALL_FIELDS, Snackbar.LENGTH_LONG)
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

    private fun register() {
        val email: String = binding.inputEmail.text.toString()
        val password: String = binding.inputPassword.text.toString()
        val rPassword: String = binding.inputRepeatPassword.text.toString()

        if (password != rPassword)
            return

        try {
            accountService.registerNewAccount(context, email, password, Strings.DEFAULT_MEMBER_NAME) {
                    result ->
                val sp = context!!.getSharedPreferences()
                val account = Account(email, password, result.getString(ApiConstants.TOKEN_FIELD))

                dataService.saveData(sp, account)

                findNavController().navigate(R.id.register_to_members)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Snackbar.make(view!!, Strings.USERNAME_ALREADY_TAKEN, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
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
