package com.example.syncboard.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.syncboard.R

val provider: GoogleFont.Provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val BricolageGrotesque = FontFamily(
    Font(googleFont = GoogleFont("Bricolage Grotesque"), fontProvider = provider),
    Font(googleFont = GoogleFont("Bricolage Grotesque"), fontProvider = provider, weight = FontWeight.Bold),
    Font(googleFont = GoogleFont("Bricolage Grotesque"), fontProvider = provider, weight = FontWeight.Medium)
)

val IBMPlexSans = FontFamily(
    Font(googleFont = GoogleFont("IBM Plex Sans"), fontProvider = provider),
    Font(googleFont = GoogleFont("IBM Plex Sans"), fontProvider = provider, weight = FontWeight.Bold),
    Font(googleFont = GoogleFont("IBM Plex Sans"), fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = GoogleFont("IBM Plex Sans"), fontProvider = provider, weight = FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = BricolageGrotesque,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp,
        lineHeight = 40.sp,
        letterSpacing = (-0.01).sp
    ),
    displayMedium = TextStyle(
        fontFamily = BricolageGrotesque,
        fontWeight = FontWeight.Bold,
        fontSize = 27.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.01).sp
    ),
    displaySmall = TextStyle(
        fontFamily = BricolageGrotesque,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.01).sp
    ),
    titleLarge = TextStyle(
        fontFamily = BricolageGrotesque,
        fontWeight = FontWeight.Bold,
        fontSize = 23.sp,
        lineHeight = 28.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = IBMPlexSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = IBMPlexSans,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontFamily = IBMPlexSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = IBMPlexSans,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
)
