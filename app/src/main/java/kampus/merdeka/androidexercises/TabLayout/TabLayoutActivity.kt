package kampus.merdeka.androidexercises.TabLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kampus.merdeka.androidexercises.R
import kampus.merdeka.androidexercises.TabLayout.Adapter.ViewPagerAdapter
import kampus.merdeka.androidexercises.databinding.ActivityTabLayoutBinding

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding){
            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when(position){
                    0 -> tab.text ="Tab Pertama"
                    1 -> tab.text ="Tab Kedua"
                }
            }.attach()
        }
    }
}