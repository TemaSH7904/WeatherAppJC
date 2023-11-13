package com.juraj.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juraj.weatherapp.ui.theme.DarkBlue
import com.juraj.weatherapp.ui.theme.LightGray
import com.juraj.weatherapp.ui.theme.VeryLightGray
import com.juraj.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    WeatherPage()
                }
            }
        }
    }
}

@Composable
fun WeatherPage() {
    Column( //Контейнер Column позволяет выстроить вложенные компоненты в столбик (https://metanit.com/kotlin/jetpack/2.2.php)
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderImage()
        MainInfo()
        InfoTable()
    }
}

@Composable
fun HeaderImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_couple),
        contentDescription = null,
        modifier = Modifier.width(200.dp)
    )
}

@Composable
fun MainInfo() {
    Column(
        modifier = Modifier.padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "4°", color = DarkBlue, fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Москва",
            color = DarkBlue,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Дождливо. \n ЮЗ-Ветер от 5 до 12 м/с",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }
}

@Composable
fun InfoTable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(
                VeryLightGray
            )
    ) {
        Row(Modifier.padding(16.dp)) {//Контейнер Row располагает вложенные компоненты в строку(https://metanit.com/kotlin/jetpack/2.3.php)
            InfoItem(
                iconRes = R.drawable.ic_humidity,
                title = "Влажность",
                subtitle = "85%",
                modifier = Modifier.weight(
                    1f
                )
            )
            InfoItem(
                iconRes = R.drawable.ic_sun_full,
                title = "УФ-Индекс",
                subtitle = "0 of 3",
                modifier = Modifier.weight(
                    1f
                )
            )
        }
        Divider(color = LightGray, modifier = Modifier.padding(horizontal = 16.dp))
        Row(Modifier.padding(16.dp)) {
            InfoItem(
                iconRes = R.drawable.ic_sun_half,
                title = "Восход",
                subtitle = "8:00",
                modifier = Modifier.weight(
                    1f
                )
            )
            InfoItem(
                iconRes = R.drawable.ic_sun_half,
                title = "Закат",
                subtitle = "16:30 PM",
                modifier = Modifier.weight(
                    1f
                )
            )
        }
    }
}


@Composable
fun InfoItem(@DrawableRes iconRes: Int, title: String, subtitle: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp)
                .width(40.dp)
        )
        Column {
            Text(title, color = Color.Gray)
            Text(subtitle, color = DarkBlue, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        WeatherPage()
    }
}