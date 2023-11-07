package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFc1d0b5)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}


@Composable
fun GreetingWithImage(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(130.dp) // Adjust the size as needed
                .padding(8.dp) // Add padding to the image
                .background(Color(0xFF084d56)) // Set the background color
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null, // Set an appropriate content description
                modifier = Modifier
                    .fillMaxSize() // Make the image fill the entire Box
            )
        }
        Text(
            text = "Nuha Nordin",
            fontSize = 40.sp,
        )
        Text(
            text = "Ordinary Mobile Computing Student",
            fontSize = 18.sp,
            color = Color(0xFF407e65),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInformation(
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_phone_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "(+60) 1110064869",
                fontSize = 14.sp
            )
        }

        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_location_on_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Batu Caves, Selangor",
                fontSize = 14.sp
            )
        }

        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_mail_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "nuhanordin1@gmail.com",
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingWithImage()
        ContactInformation()
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCard()
}
/*@Preview(showBackground = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        GreetingWithImage()
        ContactInformation()
    }
}*/