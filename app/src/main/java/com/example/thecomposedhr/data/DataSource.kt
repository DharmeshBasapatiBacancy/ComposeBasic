package com.example.thecomposedhr.data

import com.example.thecomposedhr.R
import com.example.thecomposedhr.data.models.Artwork
import com.example.thecomposedhr.data.models.Wellness

object DataSource {
    val wellnessList = listOf(
        Wellness("Day 1","6-Minute Mindful Workout",
            R.drawable.wellness_1,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 2","Tooth Brushing Meditation",
            R.drawable.wellness_2,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 3","Try a Mantra Workout",
            R.drawable.wellness_3,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 4","Reinvent 'Date' Night",
            R.drawable.wellness_4,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 5","Take a walk outside",
            R.drawable.wellness_5,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 6","Eat without distractions ",
            R.drawable.wellness_6,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 7","Write a letter to a friend",
            R.drawable.wellness_7,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 8","Carve out 30 minutes of alone time",
            R.drawable.wellness_8,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 9","Don’t set an alarm and wake up naturally",
            R.drawable.wellness_9,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
        Wellness("Day 10","Take 5 minutes to stretch your body",
            R.drawable.wellness_10,"It should be enjoyable and something you’re motivated to do (not something someone ELSE wants you to do or that you think you “should” do)"),
    )

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
}