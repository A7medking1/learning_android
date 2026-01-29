package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.data.User
import com.example.myapplication.databinding.FragmentAddBinding
import com.example.myapplication.utils.text
import com.example.myapplication.utils.validateNotEmpty
import com.example.myapplication.utils.validateOnTextChange
import com.example.myapplication.viewModel.UserViewModel


class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private val args: AddFragmentArgs by navArgs()
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

        if (args.user != null) {
            initForms()
        }
        binding.submitBtn.setText(
            if (args.user == null) R.string.submit else R.string.update
        )

        (activity as? AppCompatActivity)?.supportActionBar?.title =
            if (args.user == null) "Add User" else "Update User"

        validateFormRealTime()

        binding.submitBtn.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        if (!validateForm()) return


        val firstName = binding.firstName.text()
        val lastName = binding.secondName.text()
        val age = binding.age.text()

        val userId = args.user?.id ?: 0


        val user = User(userId, firstName, lastName, age.toInt())

        if (args.user != null) {
            updateUser(user)
        } else {
            addUser(user)
        }

    }

    private fun addUser(user: User) {
        userViewModel.addUser(user)
        findNavController().navigate(R.id.listFragment2)
        Toast.makeText(requireContext(), "Done Added", Toast.LENGTH_SHORT).show()
    }

    private fun updateUser(user: User) {
        userViewModel.updateUser(user)
        findNavController().navigate(R.id.listFragment2)
        Toast.makeText(requireContext(), "Done updated", Toast.LENGTH_SHORT).show()
    }


    private fun validateFormRealTime() {
        binding.firstName.validateOnTextChange("first name is requires")
        binding.secondName.validateOnTextChange("second name is requires")
        binding.age.validateOnTextChange("age must be between 1 and 120") {
            it.toIntOrNull() in 1..120
        }
    }

    private fun validateForm(): Boolean {
        val isFirstNameValid =
            binding.firstName.validateNotEmpty("first name is required")

        val isLastNameValid =
            binding.secondName.validateNotEmpty("second name is required")

        val isAgeValid =
            binding.age.validateNotEmpty("age is required")

        return isFirstNameValid && isLastNameValid && isAgeValid
    }

    private fun initForms() {
        binding.firstName.editText?.setText(args.user?.firstName)
        binding.secondName.editText?.setText(args.user?.lastName)
        binding.age.editText?.setText(args.user?.age.toString())
    }
}

