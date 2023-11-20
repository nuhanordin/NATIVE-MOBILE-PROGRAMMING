package com.example.dessert30days

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import com.example.dessert30days.data.Datasource
import com.example.dessert30days.model.Dessert
import com.example.dessert30days.ui.theme.Dessert30DaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dessert30DaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DessertApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DessertApp() {
    Scaffold(
        topBar = {
            DessertTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp) // Adjust the height as needed
            )
        },
        content = {
            DessertList(
                dessertList = Datasource().loadDessert(),
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DessertTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun DessertList(dessertList: List<Dessert>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier
        .padding(top = 66.dp)
        .systemBarsPadding()
    ) {
        itemsIndexed(dessertList) {index, dessert ->
            DessertCard(
                dessert = dessert,
                dayCount = index + 1,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun DessertCard(dayCount: Int, dessert: Dessert, modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    Card(modifier = modifier.clickable { expanded = !expanded},
        ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Day $dayCount",
                    modifier = Modifier.padding(6.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            }
            Text(
                text = LocalContext.current.getString(dessert.stringResourceId),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            if (expanded) {
                Image(
                    painter = painterResource(dessert.imageResourceId),
                    contentDescription = stringResource(dessert.stringResourceId1),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = LocalContext.current.getString(dessert.stringResourceId1),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DessertApp()
    //DessertCard(
      //  dayCount = 1,
        //Dessert(R.string.name1, R.string.desc1, R.drawable.image1))
}