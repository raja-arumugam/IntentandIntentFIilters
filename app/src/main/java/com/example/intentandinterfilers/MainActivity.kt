package com.example.intentandinterfilers

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.intentandinterfilers.ui.theme.IntentAndInterFilersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentAndInterFilersTheme {
                MaterialTheme {

                    Column {
                        // Compose a email
                        Button(
                            onClick = {
                                val sendIntent = Intent(Intent.ACTION_SEND).apply {
                                    type = "text/plain"
                                    putExtra(Intent.EXTRA_EMAIL, "rajaarumugam01@gmail.com")
                                    putExtra(Intent.EXTRA_SUBJECT, "Message")
                                    putExtra(Intent.EXTRA_TEXT, "Hi Raja, Message from Intent")
                                }
                                if (sendIntent.resolveActivity(packageManager) != null) {
                                    startActivity(sendIntent)
                                }
                            },
                            modifier = Modifier
                                .padding(16.dp)
                                .height(50.dp)
                                .fillMaxSize(),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text(
                                text = "Click to Share",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontFamily = FontFamily.Monospace
                                ),
                                textAlign = TextAlign.Center
                            )
                        }

                        // Open another app
                        Button(
                            onClick = {
                                Intent(Intent.ACTION_MAIN).also {
                                    it.`package` = "com.google.android.youtube"

                                    try {
                                        startActivity(it)
                                    } catch (e: ActivityNotFoundException) {
                                        Log.e("MainActivity", e.toString())
                                    }
                                }

                            },
                            modifier = Modifier
                                .padding(16.dp)
                                .height(50.dp)
                                .fillMaxSize(),
                            colors = ButtonDefaults.buttonColors(Color.Black),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                text = "Click to Open",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontFamily = FontFamily.Monospace
                                ),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}