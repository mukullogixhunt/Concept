package com.compose.concept

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.compose.concept.databinding.ActivityMainBinding
import com.compose.concept.presentation.ui.UserAdapter
import com.compose.concept.presentation.ui.UserScreen
import com.compose.concept.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.observeOn


///Compose Style
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserScreen(userViewModel)
        }
    }
}


///XML Data binding
//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//
//
//    private lateinit var binding: ActivityMainBinding
//    private val userViewModel: UserViewModel by viewModels()
//    private lateinit var adapter: UserAdapter
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        adapter = UserAdapter()
//        binding.recyclerView.adapter = adapter
//        binding.viewModel = userViewModel
//        binding.lifecycleOwner = this
//
//        userViewModel.users.observe(this){
//            adapter.submitList(it)
//        }
//    }
//}