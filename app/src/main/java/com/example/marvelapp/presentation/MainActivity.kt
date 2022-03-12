package com.example.marvelapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.marvelapp.R
import com.example.marvelapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configurando os componentes do navigation
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_container) as NavHostFragment
        navController = navHostFragment.navController

        //configurando os botões do bottomNavMain
        binding.bottomNavMain.setupWithNavController(navController)

        //define os destinos iniciais
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.charactersFragment, R.id.favoritesFragment, R.id.aboutFragment)
        )

        //Configurei a tool bar
        binding.toolbarApp.setupWithNavController(navController, appBarConfiguration)

        /*
         Caso a tela seja os primeiros destinos configurados no
         appBarConfiguration não ira mostrar o icone de voltar.
         */
        navController.addOnDestinationChangedListener{_, destination ,_ ->
            val isTopLevelDestination = appBarConfiguration.topLevelDestinations.contains(destination.id)
            if (!isTopLevelDestination){
                binding.toolbarApp.setNavigationIcon(R.drawable.ic_back)
            }
        }

    }
}
