package com.example.hello.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hello.R
import com.example.hello.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            if (validate()) {
                val email = binding.etEmail.text.toString().trim()
                val bundle = Bundle().apply {
                    putString("email", email)
                }
                findNavController().navigate(
                    R.id.action_login_to_home,
                    bundle
                )
            }
        }

        binding.tvGoRegister.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }
    }

    private fun validate(): Boolean {
        var valid = true

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

        return valid
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
