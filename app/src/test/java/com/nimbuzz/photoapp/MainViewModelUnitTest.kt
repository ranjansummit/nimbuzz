package com.piashcse.photoapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

import com.nimbuzz.photoapp.data.repository.NimBuzzRepository
import com.nimbuzz.photoapp.ui.screens.mainscreen.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockRepository: NimBuzzRepository // Mock the repository if used

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(mockRepository) // Inject mocks if needed
    }

    // Test cases for setImageList

    @Test
    fun `updateTriangularList calculates triangular numbers correctly for positive input`() {
        val number = 5

        viewModel.updateTriangularList(number)


        val expectedList = listOf(1, 3, 6, 10, 15)
       assertEquals(expectedList,viewModel.triangularList.value)
    }

    @Test
    fun `updateTriangularList returns empty list for non-positive input`() {
        val number = 0
        viewModel.updateTriangularList(number)
        assertEquals(0,viewModel.triangularList.value.size)
    }
}

