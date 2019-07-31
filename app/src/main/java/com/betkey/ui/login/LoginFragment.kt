package com.betkey.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.betkey.R
import com.betkey.base.BaseFragment
import com.betkey.ui.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LoginFragment : BaseFragment() {

    private val viewModel by sharedViewModel<MainViewModel>()

    companion object {
        const val TAG = "LoginFragment"

        fun newInstance() = LoginFragment().apply {
            arguments = Bundle().apply {
                //                    putInt("pos", id)
//                    putString("name", name)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity!!.include_toolbar.visibility = View.GONE
        login_username.requestFocus()

        login_btn.setOnClickListener {
            subscribe(viewModel.login("test2", "12345"), {

            })
        }
    }
}