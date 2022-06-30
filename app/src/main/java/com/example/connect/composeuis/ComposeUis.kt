package com.example.connect.composeuis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.connect.AppViewModel.AppViewModel
import com.example.connect.R
import com.example.connect.model.Men.clothes
import com.example.connect.model.MenAsset

import com.example.connect.model.MenAsstes
import com.example.connect.model.Products

@Composable
fun LandingPage(modifier: Modifier =Modifier){
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally){

            Text(text= stringResource(R.string.Appland), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold))
            Image(painter= painterResource(R.drawable.connect),contentDescription = null,modifier=Modifier.size(width = 500.dp, height = 500.dp))
            Text(text= stringResource(R.string.landdown), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold))


    }
}
@Composable
fun HomeScreen(modifier:Modifier=Modifier,list:List<Products>){

Column(modifier.fillMaxSize()){
    LazyColumn{
        items(items=list, itemContent = {item->
            //Todo inflating the item
            LazyItem(data = item)

        })
    }

}
}

@Composable
fun LazyItem(modifier:Modifier=Modifier, data: Products) {
    Card(
        modifier
            .fillMaxWidth()
            .wrapContentHeight()){
        Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly){
            Text(text="${data.productDescription}")
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