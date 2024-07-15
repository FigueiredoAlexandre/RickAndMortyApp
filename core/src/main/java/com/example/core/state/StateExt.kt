package com.example.core.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.core.actions.UIAction
import com.example.core.viewmodel.RickAndMortyViewModel


@Composable
fun <State: UIState, Action: UIAction> collectState(
    viewModel: RickAndMortyViewModel<State, Action>
): State {
    return viewModel.state.collectAsState().value
}