package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                LemonApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp() {

    var currentStep by remember { mutableStateOf(1) }
    var tapsRequired by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                },
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Card(
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    tapsRequired = (2..4).random()
                                    currentStep = 2
                                },
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_tree),
                                contentDescription = stringResource(R.string.lemon_tree),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(35.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.tap_lemon_tree))
                    }
                }

                2 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Card(
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    tapsRequired = (2..4).random()
                                    currentStep = 2
                                },
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_squeeze),
                                contentDescription = stringResource(R.string.squeeze),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(35.dp)
                                    .clickable {
                                        tapsRequired--
                                        if (tapsRequired <= 0) {
                                            currentStep = 3
                                        }
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.tap_squeeze))
                    }
                }

                3 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Card(
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    tapsRequired = (2..4).random()
                                    currentStep = 2
                                },
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_drink),
                                contentDescription = stringResource(R.string.lemonade),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(35.dp)
                                    .clickable {
                                        currentStep = 4
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.tap_lemonade))
                    }
                }

                4 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Card(
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    tapsRequired = (2..4).random()
                                    currentStep = 2
                                },
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_restart),
                                contentDescription = stringResource(R.string.glass),
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(35.dp)
                                    .clickable {
                                        currentStep = 1
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.tap_glass))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonApp()
}
