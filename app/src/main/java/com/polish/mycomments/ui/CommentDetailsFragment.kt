package com.polish.mycomments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.polish.mycomments.R
import com.polish.mycomments.databinding.FragmentCommentDetailsBinding
import kotlinx.android.synthetic.main.toolbar_detail.*

/*
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

 */

/**
 * A simple [Fragment] subclass.
 * Use the [CommentDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CommentDetailsFragment : Fragment() {

    /*
        receive the arguement from the source
     */
    val args:CommentDetailsFragmentArgs by navArgs()

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
//        return inflater.inflate(R.layout.fragment_comment_details, container, false)

        /*
            create a binding object and inflate the fragment layout
         */
        val binding = FragmentCommentDetailsBinding.inflate(inflater)
        /*
            this set the data received on the view
         */
        binding.postItem = args.postItem

        /*
            back navigation icon
         */
//        back_nav_cdId.setOnClickListener {
//
//        }

        return binding.root
    }

    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CommentDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommentDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

     */


}