package monster.donjabonoso.generalinventory.presentation.login

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import monster.donjabonoso.generalinventory.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ScreenLogin() {
    var textEmail by rememberSaveable {
        mutableStateOf("")
    }

    var textPassword by rememberSaveable {
        mutableStateOf("")
    }

    var hidden by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
            .padding(horizontal = 60.dp, vertical = 10.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(), horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val focusManager = LocalFocusManager.current

            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(id = R.drawable.inventory_login),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface)
            )
            Text(
                text = "Inventory", style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.W800,
                )
            )
            Spacer(modifier = Modifier.size(30.dp))
            OutlinedAppTextField(text = textEmail,
                onChange = {textEmail = it},
                placeholder = "Email",
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
                keyBoardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ))
            OutlinedAppTextField(
                text = textPassword,
                onChange = {textPassword = it},
                placeholder = "Password",
                imeAction = ImeAction.Send,
                keyboardType = KeyboardType.Password,
                visualTransformation = if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    IconButton(onClick = { hidden = !hidden }) {
                        val vector = painterResource(
                            if (hidden) R.drawable.visibility
                            else R.drawable.visibility_off
                        )
                        Icon(painter = vector, contentDescription = "Show/Hide Password")
                    }
                }
            )
            Spacer(modifier = Modifier.size(10.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Login")
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedAppTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    onChange: (String) -> Unit = {},
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyBoardActions: KeyboardActions = KeyboardActions(),
    isEnabled: Boolean = true,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        label = { Text(text = placeholder)},
        onValueChange = onChange,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = keyBoardActions,
        enabled = isEnabled,
        visualTransformation = visualTransformation,
        singleLine = singleLine,
    )
}