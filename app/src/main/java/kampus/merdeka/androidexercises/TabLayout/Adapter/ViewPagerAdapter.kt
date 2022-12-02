package kampus.merdeka.androidexercises.TabLayout.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import kampus.merdeka.androidexercises.TabLayout.Fragment.FirstFragment
import kampus.merdeka.androidexercises.TabLayout.Fragment.SecondFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter (fragmentManager, lifecycle){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
        }
        return fragment
    }
}