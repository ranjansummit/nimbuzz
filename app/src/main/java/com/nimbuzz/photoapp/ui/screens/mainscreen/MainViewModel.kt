    package com.nimbuzz.photoapp.ui.screens.mainscreen

    import android.net.Uri
    import androidx.compose.runtime.MutableState
    import androidx.compose.runtime.mutableStateOf
    import androidx.lifecycle.ViewModel

    import com.nimbuzz.photoapp.data.repository.NimBuzzRepository
    import dagger.hilt.android.lifecycle.HiltViewModel

    import javax.inject.Inject

    @HiltViewModel
   open class MainViewModel @Inject constructor(private val repo: NimBuzzRepository) : ViewModel() {

        val imageList:  MutableState<Pair<Uri?, Uri?>> = mutableStateOf(Pair(null,null))
        val selectionError : MutableState<Boolean> = mutableStateOf(false)
        val triangularList : MutableState<List<Int>> = mutableStateOf(emptyList())

        fun setImageList(uris: List<Uri> ) {
            if (uris.size==2) {
                // Create a new list containing the new pair
                val updatedList = Pair(uris[0], uris[1])

                // Update the _imageList state with the new list
                imageList.value = updatedList
                selectionError.value = false

            }
         else
             selectionError.value = true
        }

        fun updateTriangularList(number: Int) {
            if (number <= 0) {
                triangularList.value =  emptyList()
            }

            val triangularNumbers = mutableListOf<Int>()
            for (i in 1..number) {
                triangularNumbers.add(i * (i + 1) / 2)
            }
             triangularList.value =  triangularNumbers.toList()
        }


    }