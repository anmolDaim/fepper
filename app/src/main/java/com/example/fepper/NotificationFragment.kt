package com.example.fepper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fepper.DataClass.notificationDataClass
import com.example.fepper.adapter.categoryAdapter
import com.example.fepper.adapter.notificationAdapter


class NotificationFragment : Fragment() {
 lateinit var notificationRecyclerView:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        notificationRecyclerView = view.findViewById(R.id.notificationRecyclerView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val notiArr=ArrayList<notificationDataClass>()
        notiArr.add(notificationDataClass(R.drawable.profile_icon,"Crispy Deal from our kuchii","gayfviuvb guahvb usgviu iaiugfbv uagfaubv uafygv yhv","Welcome"))
        notiArr.add(notificationDataClass(R.drawable.profile_icon,"Crispy Deal from our kuchii","gayfviuvb guahvb usgviu iaiugfbv uagfaubv uafygv yhv","Welcome"))
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        notificationRecyclerView.layoutManager = layoutManager
        val adapter = notificationAdapter(notiArr)
        notificationRecyclerView.adapter = adapter
    }
}