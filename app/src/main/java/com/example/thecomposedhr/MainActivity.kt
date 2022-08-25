package com.example.thecomposedhr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thecomposedhr.ui.theme.AndroidGreen
import com.example.thecomposedhr.ui.theme.DarkTeal
import com.example.thecomposedhr.ui.theme.LightTeal
import com.example.thecomposedhr.ui.theme.TheComposeDHRTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheComposeDHRTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EntryPoint()
                }
            }
        }
    }
}

// Compose function to declare routes of application & start destination.
@Composable
fun EntryPoint() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "homeScreen") {
        composable(route = "homeScreen") {
            HomeScreenWithButtons(navController)
        }
        composable(route = "myLemonadeStall") {
            MyLemonadeStall(navController)
        }
        composable(route = "diceRoller") {
            DiceWithButtonAndImage(navController)
        }
        composable(route = "businessCard") {
            BusinessCardApp(navController)
        }
        composable(route = "myArtSpace") {
            MyArtSpaceApp(navController)
        }
    }
}

@Composable
fun MyArtSpaceApp(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomToolbarWithBackArrow(title = "My Art Space App", navController)
        },
        content = {

            val artworkList = listOf(
                Artwork(1, "Brian Lara", "Artwork Title #1", "1980", R.drawable.sample_art_1),
                Artwork(
                    2,
                    "Sir Vivian Richards",
                    "Artwork Title #2",
                    "1985",
                    R.drawable.sample_artwork
                ),
                Artwork(3, "Clive Lloyd", "Artwork Title #3", "1990", R.drawable.sample_art_3),
                Artwork(4, "Courtney Walsh", "Artwork Title #4", "1995", R.drawable.sample_art_4),
                Artwork(5, "Andre Russell", "Artwork Title #5", "2000", R.drawable.sample_art_5),
            )

            var artworkCount by remember {
                mutableStateOf(0)
            }

            Surface(color = Color.White) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ArtWorkWall(artworkList[artworkCount].artworkImage)
                    Spacer(modifier = Modifier.height(10.dp))
                    ArtWorkDescriptor(artworkList[artworkCount])
                    Spacer(modifier = Modifier.height(10.dp))
                    ArtWorkDisplayController(artworkCount, onPreviousClick = {
                        if (artworkCount >= 1) {
                            artworkCount -= 1
                        }
                    }) {
                        if (artworkCount <= 3) {
                            artworkCount += 1
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ArtWorkWall(artworkImage: Int) {
    Surface(
        color = Color.White,
        border = BorderStroke(2.dp, color = Color.DarkGray),
        elevation = 5.dp, modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(20.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(30.dp)
                .wrapContentWidth()
                .height(300.dp),
            contentScale = ContentScale.FillHeight,
            painter = painterResource(id = artworkImage),
            contentDescription = null
        )
    }
}

@Composable
fun ArtWorkDescriptor(artwork: Artwork) {
    Card(
        elevation = 3.dp, modifier = Modifier
            .wrapContentWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .padding(10.dp)
        ) {
            Text(
                artwork.artworkTitle,
                fontSize = 20.sp, fontWeight = FontWeight.W300
            )
            Row() {
                Text(artwork.artistName, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(5.dp))
                Text("(${artwork.artworkYear})", fontWeight = FontWeight.Light)
            }
        }
    }
}

@Composable
fun ArtWorkDisplayController(
    artworkCount: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.wrapContentWidth(),
            enabled = artworkCount >= 0,
        ) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onNextClick,
            modifier = Modifier.wrapContentWidth(),
            enabled = artworkCount <= 4,
        ) {
            Text(text = "Next")
        }
    }
}


@Composable
fun HomeScreenWithButtons(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomToolbar(title = "Compose Basic App")
        },
        content = {
            Surface(color = Color.White) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = { navController.navigate("myLemonadeStall") },Modifier.width(200.dp)) {
                        Text(text = "My Lemonade Stall")
                    }
                    Button(onClick = { navController.navigate("diceRoller") },Modifier.width(200.dp)) {
                        Text(text = "My Dice Roller")
                    }
                    Button(onClick = { navController.navigate("businessCard") },Modifier.width(200.dp)) {
                        Text(text = "My Business Card")
                    }
                    Button(onClick = { navController.navigate("myArtSpace") },Modifier.width(200.dp)) {
                        Text(text = "My Art Space")
                    }
                }
            }
        }
    )


}

@Composable
fun MyLemonadeStall(navController: NavHostController) {
    var stepNumber by remember { mutableStateOf(1) }
    var lemonSqueezedCount by remember { mutableStateOf(4) }
    val stepTitle: String
    val stepImage: Painter
    when (stepNumber) {
        1 -> {
            stepTitle = stringResource(id = R.string.txt_step_1)
            stepImage = painterResource(id = R.drawable.lemon_tree)
        }
        2 -> {
            stepTitle = stringResource(id = R.string.txt_step_2)
            stepImage = painterResource(id = R.drawable.lemon_squeeze)

        }
        3 -> {
            stepTitle = stringResource(id = R.string.txt_step_3)
            stepImage = painterResource(id = R.drawable.lemon_drink)
        }
        else -> {
            stepTitle = stringResource(id = R.string.txt_step_4)
            stepImage = painterResource(id = R.drawable.lemon_restart)
        }
    }

    Scaffold(
        topBar = {
            CustomToolbarWithBackArrow("My Lemonade Stall", navController)
        },
        content = {
            Surface(color = Color.White) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = stepTitle, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(
                        painter = stepImage,
                        contentDescription = null,
                        Modifier
                            .wrapContentSize()
                            .border(
                                BorderStroke(2.dp, Color(105, 205, 216)),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .padding(16.dp)
                            .clickable {
                                when (stepNumber) {
                                    1 -> {
                                        stepNumber = 2
                                        lemonSqueezedCount = (2..4).random()
                                    }
                                    2 -> {
                                        lemonSqueezedCount -= 1
                                        if (lemonSqueezedCount == 0) {
                                            stepNumber += 1
                                        }
                                    }
                                    3 -> {
                                        stepNumber = 4
                                    }
                                    4 -> {
                                        stepNumber = 1
                                    }
                                }
                            }
                    )
                }
            }
        }
    )

}

@Composable
fun CustomToolbarWithBackArrow(title: String, navController: NavHostController) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            // navigation icon is use
            // for drawer icon.
            IconButton(onClick = { navController.popBackStack() }) {
                // below line is use to
                // specify navigation icon.
                Icon(
                    Icons.Filled.ArrowBack,
                    "contentDescription",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun CustomToolbar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
    )
}

@Composable
fun DiceWithButtonAndImage(navController: NavHostController) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageResource = when (result) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        else -> "Six"
    }

    Scaffold(topBar = {
        CustomToolbarWithBackArrow("My Dice Roller", navController)
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = imageResource,
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { result = (1..6).random() }) {
                Text(text = stringResource(R.string.roll), fontSize = 24.sp)
            }
        }
    })


}

@Composable
fun BusinessCardApp(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomToolbarWithBackArrow("My Business Card", navController)
        },
        content = {
            Surface(color = DarkTeal) {
                Column {
                    Spacer(modifier = Modifier.weight(1f))
                    AppLogoNameTitleCard()
                    Spacer(modifier = Modifier.weight(1f))
                    ContactDetailsCard()
                }
            }
        }
    )
}

@Composable
fun AppLogoNameTitleCard() {
    val logo = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )
        Text(
            text = stringResource(R.string.user_name),
            color = Color.White,
            fontSize = 50.sp,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Light
        )
        Text(
            text = stringResource(R.string.user_position),
            color = AndroidGreen,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactDetailsCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 20.dp)
            .wrapContentHeight()
    ) {
        LightTealDivider()
        IconWithText(
            painterResource(id = R.drawable.ic_baseline_local_phone_24),
            stringResource(R.string.user_number)
        )
        LightTealDivider()
        IconWithText(
            painterResource(id = R.drawable.ic_baseline_share_24),
            stringResource(R.string.user_handle)
        )
        LightTealDivider()
        IconWithText(
            painterResource(id = R.drawable.ic_baseline_email_24),
            stringResource(R.string.user_email)
        )
    }
}

@Composable
fun LightTealDivider() {
    Divider(color = LightTeal, thickness = 2.dp)
}

@Composable
fun IconWithText(painterResource: Painter, text: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp)
    ) {
        Icon(
            painter = painterResource,
            contentDescription = null,
            tint = AndroidGreen,
            modifier = Modifier.weight(1.3f)
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(3f)
        )
    }
}
