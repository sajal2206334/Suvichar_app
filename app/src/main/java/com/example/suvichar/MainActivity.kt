package com.example.suvichar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.suvichar.data.Datasource
import com.example.suvichar.model.Suvichar
import com.example.suvichar.ui.theme.SuvicharTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuvicharTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Suvichar()
                }
            }
        }
    }
}

@Composable
fun Suvichar() {
    SuvicharList(suvicharList = Datasource().loadAffirmations())
}

@Composable
fun SuvicharBackgroundcard(suvichar : Suvichar,modifier: Modifier = Modifier) {
    Card(modifier = Modifier) {
        Column {
            Image(painter = painterResource(suvichar.imageResourceId),
                contentDescription = stringResource(suvichar.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop)
            Text(text = LocalContext.current.getString(suvichar.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall)
        }
    }
}

@Composable
fun SuvicharList(suvicharList: List<Suvichar>,modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier) {
        items(suvicharList) {
            suvichar ->
            SuvicharBackgroundcard(suvichar = suvichar,
            modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SuvicharsPreview() {
    SuvicharTheme {
        SuvicharBackgroundcard(com.example.suvichar.model.Suvichar(R.string.affirmation1,R.drawable.image1))
    }
}