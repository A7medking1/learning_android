package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.User
import com.example.myapplication.data.UserViewModel
import com.example.myapplication.databinding.FragmentAddBinding


class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private val userViewModel: UserViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitBtn.setOnClickListener {
            insertDataToDatabase()
        }

    }


    private fun insertDataToDatabase() {
        val firstName = binding.firstName.editText?.text.toString().trim()
        val lastName = binding.secondName.editText?.text.toString().trim()
        val age = binding.age.editText?.text.toString().trim()

        if (inputCheck(firstName, lastName, age)) {
            val user = User(0, firstName, lastName, age.toInt())
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Done Added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.listFragment2)
        } else {
            Toast.makeText(requireContext(), "Please fill out all field", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean {
        return !(firstName.isEmpty() && lastName.isEmpty() && age.isEmpty())
    }


}