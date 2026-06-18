package com.example.hello.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hello.R
import com.example.hello.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            if (validate()) {
                findNavController().navigate(R.id.action_register_to_login)
            }
        }

        binding.tvGoLogin.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }
    }

    private fun validate(): Boolean {
        var valid = true

        if (binding.etNickname.text.isNullOrBlank()) {
            binding.tilNickname.error = getString(R.string.error_empty_nickname)
            valid = false
        } else {
            binding.tilNickname.error = null
        }

        if (binding.etEmail.text.isNullOrBlank()) {
            binding.tilEmail.error = getString(R.string.error_empty_email)
            valid = false
        } else {
            binding.tilEmail.error = null
        }

        if (binding.etPassword.text.isNullOrBlank()) {
            binding.tilPassword.error = getString(R.string.error_empty_password)
            valid = false
        } else {
            binding.tilPassword.error = null
        }

        val password = binding.etPassword.text.toString()
        val confirm = binding.etConfirmPassword.text.toString()
        if (password != confirm) {
            binding.tilConfirmPassword.error = getString(R.string.error_password_mismatch)
            valid = false
        } else {
            binding.tilConfirmPassword.error = null
        }

        return valid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
