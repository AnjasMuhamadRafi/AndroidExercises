package kampus.merdeka.androidexercises.BottomNavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kampus.merdeka.androidexercises.BottomNavigation.Fragment.Chat
import kampus.merdeka.androidexercises.BottomNavigation.Fragment.Home
import kampus.merdeka.androidexercises.BottomNavigation.Fragment.Profile
import kampus.merdeka.androidexercises.R
import kampus.merdeka.androidexercises.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> replaceFragment(Home())
                R.id.nav_chat -> replaceFragment(Chat())
                R.id.nav_profile -> replaceFragment(Profile())

                else ->{

                }

            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}