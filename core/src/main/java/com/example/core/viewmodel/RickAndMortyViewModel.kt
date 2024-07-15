package com.example.core.viewmodel

import com.example.core.actions.UIAction
import com.example.core.state.UIState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow

open class RickAndMortyViewModel<State: UIState, Action: UIAction>(
    private val initialUIState: State
) {

    private val _state = MutableStateFlow(initialUIState)
    val state: StateFlow<State> = _state.asStateFlow()

    private val _actions = Channel<Action>()
    val action = _actions.receiveAsFlow()
}