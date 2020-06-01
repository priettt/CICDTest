package com.example.cicdtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CounterViewModelTest {

    private lateinit var viewModel: CounterViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = CounterViewModel()
    }

    @Test
    fun onButtonPressed_addsOneToCounter() {
        viewModel.onButtonPressed()
        assertEquals(1, viewModel.getCount().value)
    }
}