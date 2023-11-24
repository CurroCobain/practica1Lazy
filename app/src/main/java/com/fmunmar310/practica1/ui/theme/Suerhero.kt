package com.fmunmar310.practica1.ui.theme

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.fmunmar310.practica1.R
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Superhero(var superheroName: String,
                     val realNAme: String,
                     var  publisher: String,
                     var photo: Int
)
val miLista = mutableListOf<Superhero>()
val spider = Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman)
val wolv = Superhero("Wolverine", "James Howlett","Marvel",R.drawable.logan)
val bat = Superhero("Batman", "Bruce Wayne","DC",R.drawable.batman)
val thor = Superhero("Thor", "Thor Odinson","Marvel",R.drawable.thor)
val flash = Superhero("Flash", "Barry Allen","DC",R.drawable.flash)
val green = Superhero("Green Lantern", "Alan Scott","DC",R.drawable.green_lantern)
val wonder = Superhero("Wonder Woman", "Diana Price","DC",R.drawable.wonder_woman)

fun getSuperHeroes():MutableList<Superhero>{
    miLista.add(spider)
    miLista.add(wolv)
    miLista.add(bat)
    miLista.add(thor)
    miLista.add(flash)
    miLista.add(green)
    miLista.add(wonder)
    return miLista
}

/**
 * Función con LazyColumn y el toast
 */
@Composable
fun SuperheroView(){
    val context = LocalContext.current
    LazyColumn(){
        items (getSuperHeroes()) {
            ItemHero (superhero = it, onItemSelected = {superhero ->
                Toast.makeText(context, superhero.realNAme, Toast.LENGTH_SHORT).show()
            })
        }
    }
}
/**
 * Función con LazyVerticalGrid y la opción GridCells.Fixed a 2 columnas
 */
@Preview
@Composable
fun SuperheroView2(){
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
    ){
        items (getSuperHeroes()) {
            ItemHero (superhero = it, onItemSelected = {superhero ->
                Toast.makeText(context, superhero.realNAme, Toast.LENGTH_SHORT).show()
            })
        }
    }
}
/**
 * Función con LazyVerticalGrid y la opción GridCells.Adaptative a 120.dp
 */
@Preview
@Composable
fun SuperheroView3(){
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Adaptive(120.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
    ){
        items (getSuperHeroes()) {
            ItemHero (superhero = it, onItemSelected = {superhero ->
                Toast.makeText(context, superhero.realNAme, Toast.LENGTH_SHORT).show()
            })
        }
    }
}

/**
 * Función composable con un card compuesta a su vez por una imagen y tres textos
 */
@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit){
        Card(modifier = Modifier.border(width = 2.dp, color = Color.Red,)
            .fillMaxWidth()
            .clickable { onItemSelected (superhero)}
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = superhero.photo),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Superhero Avatar",
                    modifier = Modifier.fillMaxWidth())
                Text(text = superhero.superheroName,
                    fontSize = 20.sp)
                Text(text = superhero.realNAme,
                    fontSize = 15.sp,)
                Text(text = superhero.publisher,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(5.dp)
                        .align(Alignment.End)
                    )
            }
        }
}
