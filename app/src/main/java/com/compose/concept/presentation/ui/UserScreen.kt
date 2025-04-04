package com.compose.concept.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.concept.presentation.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel) {

    val users by viewModel.users.collectAsState()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = { viewModel.insertUser(name, email) }) {
            Text("Add User")
        }

        Spacer(modifier = Modifier.width(5.dp))

        Button(onClick = { viewModel.clearUsers() }) {
            Text("Remove All")
        }




        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn {
            items(users.size) { index ->
                val user = users[index]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .shadow(4.dp),
                ) {

                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(text = "Name: ${user.name}", fontWeight = FontWeight.Bold)
                        Text(text = "Email: ${user.email}")
                    }

                }
            }

        }




    }


}