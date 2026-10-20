import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.designsystem.component.HorizontalSpace
import com.example.designsystem.component.InputBoxTitleText
import com.example.designsystem.component.SyncBoardButton
import com.example.designsystem.component.SyncBoardLogo
import com.example.designsystem.component.SyncManagerInput
import com.example.designsystem.component.VerticalSpace

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, onLoginClick: () -> Unit){
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 48.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            SyncBoardLogo(size = 34.dp)
            HorizontalSpace(10)
            Text(
                text = "Sync Board", style = MaterialTheme.typography.displaySmall
            )
        }

        VerticalSpace(30)

        Column {
            Text(
                text = "Create your account", style = MaterialTheme.typography.displayLarge
            )
            VerticalSpace(10)
            Text(
                text = "Plan work with your team, even without a connection.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        VerticalSpace(30)
        InputBoxTitleText("Name")
        VerticalSpace(8)
        SyncManagerInput(name, onValueChange = { name = it })
        VerticalSpace(20)
        InputBoxTitleText("Email")
        VerticalSpace(8)
        SyncManagerInput(email, onValueChange = { email = it })
        VerticalSpace(20)
        InputBoxTitleText("Password")
        VerticalSpace(8)
        SyncManagerInput(
            password,
            onValueChange = { password = it },
            isPassword = true
        )
        VerticalSpace(8)
        Text(
            text = "At least 8 characters with a letter and a number.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        VerticalSpace(24)
        SyncBoardButton("Sign Up", onClick = {})
        VerticalSpace(24)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Already Have Account?",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            HorizontalSpace(8)
            Text(
                text = "Log In",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.clickable(onClick = onLoginClick)
            )
        }
    }
}