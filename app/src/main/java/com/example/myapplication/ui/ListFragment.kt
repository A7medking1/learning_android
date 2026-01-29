package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapters.MyAdapter
import com.example.myapplication.data.User
import com.example.myapplication.databinding.FragmentListBinding
import com.example.myapplication.viewModel.UserViewModel


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickFab()
        adapter = MyAdapter { user ->
            onDeleteUser(user)
        }

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        userViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })
    }

    private fun onDeleteUser(user: User) {

        val builder = AlertDialog.Builder(requireContext())

        builder.setPositiveButton("YES") { _, _ ->
            userViewModel.deleteUser(user)
            Toast.makeText(requireContext(), "Successfully removed", Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("NO") { _, _ -> }
        builder.setTitle("Delete ${user.firstName}")
        builder.setMessage("Are you sure you want to delete ${user.firstName}?")
        builder.create().show()
    }


    private fun onClickFab() {
        binding.FABS.setOnClickListener {
            findNavController().navigate(R.id.addFragment2, null)
        }
    }

}