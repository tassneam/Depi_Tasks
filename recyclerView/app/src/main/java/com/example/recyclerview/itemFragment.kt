package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.FragmentInfoBinding
import com.example.recyclerview.databinding.FragmentItemBinding


class itemFragment : Fragment() {
    lateinit var binding: FragmentItemBinding
    var list = mutableListOf<User>()
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBinding.inflate(layoutInflater, container, false)
        addUser()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=myAdapter(list){
            findNavController().navigate(R.id.infoFragment, bundleOf(
//                "name" to it.name,
//                "phone" to it.phone,
//                "email" to it.email
                 "user" to it
            ))
        }
    }
    fun addUser(){
        list.add(User("t","32432344","t@gmail.com"))
        list.add(User("x","32432344","x@gmail.com"))
        list.add(User("y","32432344","y@gmail.com"))
        list.add(User("z","32432344","z@gmail.com"))
        list.add(User("w","32432344","w@gmail.com"))
    }

    override fun onDestroy() {
        super.onDestroy()
        list.clear()
    }
}