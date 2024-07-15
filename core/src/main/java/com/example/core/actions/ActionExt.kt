package com.example.core.actions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun <Action : UIAction> onSingleAction(
    actionFlow: Flow<Action>,
    onAction: (Action) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = actionFlow) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            actionFlow.collect { action ->
                onAction(action)
            }
        }
    }
}