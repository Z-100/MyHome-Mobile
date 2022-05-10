package com.myhome.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.myhome.R
import com.myhome.databinding.FragmentMembersBinding

import org.json.JSONException

import org.json.JSONArray

import com.myhome.api.impl.AccountApiService
import com.myhome.blueprint.Member
import com.myhome.other.GridAdapter
import com.myhome.other.SpStrings
import com.myhome.service.data.DataHandlingService
import java.lang.Exception

import android.widget.AdapterView.OnItemClickListener
import com.myhome.other.Session

/**
 * @author Z-100
 */
class MembersFragment : Fragment() {

    private var _binding: FragmentMembersBinding? = null
    private val binding get() = _binding!!

    private var accountService = AccountApiService()
    private var dataService = DataHandlingService()

    private val members = ArrayList<Member>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentMembersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMembersFromApi()
        // Debug only. Remove
            members.add(Member(1, "Hans Peter", 2))
            members.add(Member(2, "Andrei Miti", 6))
            members.add(Member(3, "Marvin", 10))
            members.add(Member(4, "Gimme a good grade please", 12))
        generateBindings()
    }

    private fun generateBindings() {
        binding.addMemberButton.setOnClickListener {
            findNavController().navigate(R.id.members_to_add_member)
        }

        val gridAdapter = GridAdapter(context, members, R.layout.member_grid_item)
        binding.gridView.adapter = gridAdapter

        binding.gridView.onItemClickListener = OnItemClickListener {
                _, _, position, _ ->

            Session.create(members[position], members)

            findNavController().navigate(MembersFragmentDirections
                .membersToDashboard().setBackButton(R.id.dashboard_to_members))
        }
    }

    private fun getMembersFromApi() {
        members.clear()

        val sp = context!!.getSharedPreferences(SpStrings.SP_NAME_ACC, Context.MODE_PRIVATE)
        val account = dataService.loadData(sp)

        try {
            val email = account!!.email
            val token = account.token

            accountService.getAllMembers(context, email, token) { result ->
                parseMembers(result)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws(JSONException::class)
    fun parseMembers(members: JSONArray) {
        for (i in 0 until members.length()) {
            val member = members.getJSONObject(i)
            this.members.add(Member(
                member.getLong("id"),
                member.getString("name"),
                member.getInt("icon")
            ))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
