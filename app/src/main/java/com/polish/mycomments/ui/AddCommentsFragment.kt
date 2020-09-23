package com.polish.mycomments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycomments.R
import com.polish.mycomments.adapter.AddCommentAdapter
import com.polish.mycomments.databinding.FragmentAddCommentsBinding
import com.polish.mycomments.model.jpbody.JPBody
import com.polish.mycomments.viewmodel.AddCommentViewModel
import kotlinx.android.synthetic.main.fragment_add_comments.*

/*
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

 */

/**
 * A simple [Fragment] subclass.
 * Use the [AddCommentsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddCommentsFragment : Fragment() {

    val TAG = "ADD_COMMENT_FRAGMENT"
    lateinit var adapter:AddCommentAdapter
    lateinit var addCommentRecyclerviewOne:RecyclerView
    lateinit var addCommentViewModel:AddCommentViewModel


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
//        return inflater.inflate(R.layout.fragment_add_comments, container, false)

        /*
            create the binding object and inflate the addComment fragment layout
         */
        val binding = FragmentAddCommentsBinding.inflate(inflater)

        /*
            initialize the viewModel
         */
        addCommentViewModel = ViewModelProvider(this).get(AddCommentViewModel::class.java)

        /*
            post your comment when you click the "Add_Comment_Button"
         */
        binding.addCommentButtonId.setOnClickListener {
            val userInput = getUserInput()
            addCommentViewModel.posting(userInput)
            add_comment_titleId.editText?.text?.clear()
            add_comment_bodyId.editText?.text?.clear()
        }



        /*
           initialize the recyclerview and set it layout manager
        */
        addCommentRecyclerviewOne = binding.addCommentRecyclerview
        addCommentRecyclerviewOne.layoutManager = LinearLayoutManager(context)

        /*
            initialize the adapter
         */
        adapter = AddCommentAdapter( AddCommentAdapter.OnClickListener{

        })

        /*
            connect the recyclerview to the adapter
         */
        addCommentRecyclerviewOne.adapter = adapter

        /*
            observe data from the livedata
         */
        addCommentViewModel.viewMyPostResponse.observe(viewLifecycleOwner, Observer {
            it?.let {
                new_add_titleId.text = it.body
                new_add_bodyId.text = it.title
            }
        })




        return binding.root

    }

    /*
        get user input and validate with the validator class
     */
    private fun getUserInput():JPBody{
        var body = JPBody()
        val commentTitle = add_comment_titleId.editText?.text.toString()
        val commentMessage = add_comment_bodyId.editText?.text.toString()
        body = JPBody(commentTitle, commentMessage)
        return body
    }

    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddCommentsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddCommentsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

     */
}