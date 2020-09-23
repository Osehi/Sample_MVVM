package com.polish.mycomments.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycomments.R
import com.polish.mycomments.adapter.HomePageAdapter
import com.polish.mycomments.databinding.FragmentHomePageBinding
import com.polish.mycomments.model.jpsearch.UserIdInput
import com.polish.mycomments.viewmodel.HomePageViewModel
import com.polish.mycomments.viewmodel.SearchCommentViewModel

/*
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

 */

/**
 * A simple [Fragment] subclass.
 * Use the [HomePageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomePageFragment : Fragment() {

    val TAG = "HOME_PAGE_FRAGMENT"
    lateinit var adapter:HomePageAdapter
    lateinit var myRecyclerView: RecyclerView
    lateinit var homePageViewModel: HomePageViewModel
    lateinit var searchCommentViewModel: SearchCommentViewModel
    lateinit var binding: FragmentHomePageBinding

    /*
    private var param1: String? = null
    private var param2: String? = null

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

         */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home_page, container, false)

        /*
            create a binding object to inflate the homePageFragment layout
         */
         binding = FragmentHomePageBinding.inflate(inflater)


        /*
            initialize the viewModels
         */
        homePageViewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)
        searchCommentViewModel = ViewModelProvider(requireActivity()).get(SearchCommentViewModel::class.java)

        /*
            onclick of the search button
         */
        binding.searchButtonId.setOnClickListener {
            val userInfo = userInput()
            Log.d(TAG, "from user: ${userInfo}")
            searchCommentViewModel.displaySearchResult(userInfo)
            binding.inputSearchId.text.clear()
            findNavController().navigate(R.id.action_homePageFragment_to_searchResultFragment)
        }



        /*
            initialize the recyclerview and set it layout manager
         */
        myRecyclerView = binding.myRecyclerview
        myRecyclerView.layoutManager = LinearLayoutManager(context)

        /*
            initialize the adapter
         */
        adapter = HomePageAdapter(
            HomePageAdapter.OnClickListener{
                it?.let {
                    val action = HomePageFragmentDirections.actionHomePageFragmentToCommentDetailsFragment(it)
                    findNavController().navigate(action)
//                    Toast.makeText(context, "click: ${it}", Toast.LENGTH_LONG).show()
                }
            }
        )
        /*
            connect the recyclerview to the adapter
         */
        myRecyclerView.adapter = adapter

        /*
            observe the data from the livedata
         */
        homePageViewModel.myListOfPost.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
//                Log.d(TAG, "result: ${it}")
            }
        })

        /*
            navigate to the add_comment fragment
         */
        binding.floatingActionButtonId.setOnClickListener{
            findNavController().navigate(R.id.action_homePageFragment_to_addCommentsFragment)
        }


        return binding.root

    }

    /*
        receive user input and add validation
     */

    private fun userInput():String{


        val userId = binding.inputSearchId.text.toString()
        /*
        var enteredId = UserIdInput()
        val userId = binding.inputSearchId.text.toString()
        enteredId = UserIdInput(userId)
        return enteredId

         */
        return userId
    }

    /*

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomePageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomePageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

     */



}