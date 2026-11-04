package com.example.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(9.dp),  // Segmented control buttons
    small = RoundedCornerShape(11.dp),       // Small buttons, chips
    medium = RoundedCornerShape(12.dp),      // Inputs
    large = RoundedCornerShape(14.dp),       // Primary buttons
    extraLarge = RoundedCornerShape(16.dp)   // Cards, lists
)

// Specific shapes from prototype
val ButtonShape = RoundedCornerShape(14.dp)
val SmallButtonShape = RoundedCornerShape(11.dp)
val CardShape = RoundedCornerShape(16.dp)
val InputShape = RoundedCornerShape(12.dp)
val SheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
val DialogShape = RoundedCornerShape(24.dp)
val FabShape = RoundedCornerShape(18.dp)
val ColumnShape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp)
