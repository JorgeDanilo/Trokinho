package sitemas.jd.silva.trokinho.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sitemas.jd.silva.trokinho.R

@Composable
fun FinanceResumeHeader(
    value: Double,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3F51B5))
            .padding(vertical = 10.dp),
        Arrangement.Center
    ) {
        FinanceResume(
            stringResource(R.string.txtSaldo),
            "R$ %.2f".format(value),
            icon = Icons.Sharp.Info,
        )
    }
}

@Composable
private fun FinanceResume(
    label: String,
    value: String,
    icon: ImageVector,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Initial",
            tint = Color.White,
        )

        Text(
            modifier = Modifier.padding(start = 6.dp, end = 6.dp),
            text = label,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            color = Color.White,
        )
    }
    Text(
        text = value,
        fontSize = 18.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(
                color = Color(0xFF3F51B5).copy(0.4f, 0.5f, 0.6f),
                shape = RoundedCornerShape(50.dp)
            )
            .padding(start = 12.dp, end = 12.dp)
    )
}

@Preview
@Composable
fun ResumeHeaderPreview() {
    FinanceResumeHeader(value = 5000.0)
}