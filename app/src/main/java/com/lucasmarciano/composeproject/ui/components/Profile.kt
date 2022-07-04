package com.lucasmarciano.composeproject.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lucasmarciano.composeproject.data.models.ProfileVO
import com.lucasmarciano.composeproject.ui.mockspreview.mockProfile
import com.lucasmarciano.composeproject.ui.mockspreview.mockProfileNonCallToAction
import com.lucasmarciano.composeproject.ui.mockspreview.mockTwoProfile
import com.lucasmarciano.composeproject.ui.mockspreview.mockTwoProfileNonAction
import com.lucasmarciano.composeproject.ui.theme.HomeAvatar
import com.lucasmarciano.iti_module.ItiTheme

@Composable
internal fun Profile(listProfile: List<ProfileVO>, avatar: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HomeAvatar()
        Spacer(modifier = Modifier.height(ItiTheme.spacing.medium))
        listProfile.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = ItiTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Body(text = it.name, color = ItiTheme.colors.onBg)
                    Body(text = it.title)
                }
                ButtonBordLess(it.callToActionVO)
            }

        }
    }
}

@Preview(name = "Profile", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ProfilePreview() {
    Profile(mockProfile(), "")
}


@Preview(name = "Profile no edit", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ProfileNonEditPreview() {
    Profile(mockProfileNonCallToAction(), "")
}

@Preview(name = "Profiles", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TwoProfilePreview() {
    Profile(mockTwoProfile(), "")
}


@Preview(name = "Profiles non edit", showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TwoProfileNonEditPreview() {
    Profile(mockTwoProfileNonAction(), "")
}

@Preview(name = "Profile Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ProfileDarkPreview() {
    Profile(mockProfile(), "")
}

@Preview(name = "Profile", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TwoProfileDarkPreview() {
    Profile(mockTwoProfile(), "")
}
