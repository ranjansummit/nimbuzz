    package com.nimbuzz.photoapp.ui.screens.mainscreen

    import android.net.Uri
    import android.util.Log
    import androidx.activity.compose.rememberLauncherForActivityResult
    import androidx.activity.result.contract.ActivityResultContracts
    import androidx.compose.foundation.layout.*
    import androidx.compose.material.*
    import androidx.compose.runtime.*
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.hilt.navigation.compose.hiltViewModel
    import com.nimbuzz.photoapp.R
    import com.nimbuzz.photoapp.ui.component.PhotosItemList

    import com.nimbuzz.photoapp.ui.component.appbar.HomeAppBar

    import com.nimbuzz.photoapp.utils.networkconnection.ConnectionState
    import com.nimbuzz.photoapp.utils.networkconnection.connectivityState
    import kotlinx.coroutines.launch


    @Composable
    fun RequestContentPermission() {


    }

    @Preview
    @Composable
    fun MainScreen() {
        val mainViewModel = hiltViewModel<MainViewModel>()
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val isAppBarVisible = remember { mutableStateOf(true) }
        // internet connection
        val connection by connectivityState()
        val isConnected = connection === ConnectionState.Available
        val launcher = rememberLauncherForActivityResult(contract =
        ActivityResultContracts.GetMultipleContents()) { uri: List<Uri> ->
            mainViewModel.setImageList(uri)
        }
        LaunchedEffect(key1 = 0) {
        }


        Scaffold(scaffoldState = scaffoldState,
            topBar = {

                HomeAppBar(title = "Photo App", openDrawer = {
                    scope.launch {
                        scaffoldState.drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }, openFilters = {
                    isAppBarVisible.value = false
                })
            },
            floatingActionButton = {
                RequestContentPermission()
            }, snackbarHost = {
                if (isConnected.not()) {
                    Snackbar(
                        action = {}, modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = stringResource(R.string.there_is_no_internet))
                    }
                }
            },
            content = { padding ->
                Column(modifier = Modifier.padding(padding)) {
                    Column() {
                        Button(onClick = {
                            launcher.launch("image/*")
                        }) {
                            Text(text = "Pick 2 Images") // Emphasize selecting two images
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        if (mainViewModel.selectionError.value) {
                            // Show error dialog if less than 2 images selected
                            AlertDialog(
                                onDismissRequest = {},
                                text = { Text("Please select exactly 2 images.") },
                                confirmButton = {
                                    TextButton(onClick = {
                                        launcher.launch("image/*")
                                        Log.d("rantest", "ok pressed") }) {
                                        Text("Choose Again")
                                    }
                                },
                                dismissButton = {
                                    TextButton(onClick = {
                                        mainViewModel.selectionError.value = false
                                        Log.d("rantest", "cancel pressed") }) {
                                        Text("Cancel")
                                    }


                                }



                            )
                        }

                        PhotosItemList(photos = mainViewModel.imageList.value, size = 50)



                    }

                }
            })
    }






