package com.example.jobfinder.ui.features.search.composble

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.example.jobfinder.ui.theme.Typography
import com.example.jobfinder.ui.theme.black37
import com.example.jobfinder.ui.theme.dimens
import com.example.jobfinder.ui.theme.white200

@Composable
fun SearchTextField(
    query: String,
    onValueChange: (String) -> Unit,
    hint: String = "Search",
    iconPainter: Painter,

    ) {
    Column {
        OutlinedTextField(
            singleLine = true,
            value = query,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimens.space8)
                .height(MaterialTheme.dimens.space64),
            label = {
                Text(
                    text = hint,
                    color = black37,
                    style = Typography.displaySmall
                )
            },
            shape = MaterialTheme.shapes.medium,
            maxLines = 1,
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedSupportingTextColor =  MaterialTheme.colorScheme.onTertiaryContainer,
//                focusedContainerColor = Color.Transparent,
//                disabledContainerColor = (MaterialTheme.colorScheme.onTertiary),
//                focusedBorderColor =  MaterialTheme.colorScheme.onTertiaryContainer,
//                unfocusedBorderColor = MaterialTheme.colorScheme.onTertiaryContainer,
//
//            ),
            leadingIcon = {
                Icon(
                    painter = iconPainter,
                    contentDescription = hint,
                    tint = white200
                )
            }


        )
    }

}