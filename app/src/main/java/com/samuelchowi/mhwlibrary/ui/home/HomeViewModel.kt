package com.samuelchowi.mhwlibrary.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _recentItems = MutableStateFlow(listOf("","","","","","","","","","","","","",""))
    val recentItems = _recentItems.asStateFlow()

    fun userAction(event: HomeEvent) {
        viewModelScope.launch {
            when (event) {
                is HomeEvent.SearchQuery -> _searchQuery.emit(event.query)
                is HomeEvent.GoToDetail -> _searchQuery.emit(event.itemId)
            }
        }
    }
}

sealed class HomeEvent {
    data class SearchQuery(val query: String) : HomeEvent()
    data class GoToDetail(val itemId: String) : HomeEvent()
}
