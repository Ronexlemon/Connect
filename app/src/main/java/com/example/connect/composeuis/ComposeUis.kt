package com.example.connect.composeuis

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.connect.AppViewModel.AppViewModel
import com.example.connect.R
import com.example.connect.model.Men.clothes
import com.example.connect.model.MenAsset

import com.example.connect.model.MenAsstes
import com.example.connect.model.Products
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun LandingPage(modifier: Modifier =Modifier){
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally){

            Text(text= stringResource(R.string.Appland), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold))
            Image(painter= painterResource(R.drawable.connectfront),contentDescription = null,modifier=Modifier.size(width = 500.dp, height = 500.dp))
            Text(text= stringResource(R.string.landdown), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold))


    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier:Modifier=Modifier,list:List<Products>){

Column(modifier.fillMaxSize()){

    LazyVerticalGrid( cells= GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        items(list) { item ->

            LazyItem(data = item)
        }
    }

//    LazyColumn{
//        items(items=list, itemContent = {item->
//            //Todo inflating the item
//            LazyItem(data = item)
//
//        })
//    }

}
}

@Composable
fun LazyItem(modifier:Modifier=Modifier, data: Products) {
    Card(
        modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)){
        Box(modifier.fillMaxSize()){

                //     Image(painter = rememberGlidePainter(data.productImageUrl), contentDescription =null,modifier.fillMaxSize(), contentScale = ContentScale.Fit )
                Text(text="${data.productDescription}")

                AsyncImage(
                    model =data.productImageUrl,
                    contentDescription = null,
                    modifier.fillMaxSize(), contentScale = ContentScale.Crop
                )
//Image(painter = rememberAsyncImagePainter(data.productImageUrl),contentDescription = null,modifier.size(width = 50.dp, height = 50.dp))
                Log.i("Url",data.productImageUrl.toString())
                //Image(painter = painterResource(id =data.image!!), contentDescription = null)
                Text(text="${data.productName}")


        }








    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    //LandingPage()
   // HomeScreen()
}