package fastcampus.aop.part4.chapter03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import fastcampus.aop.part4.chapter03.databinding.ActivityMainBinding
import fastcampus.aop.part4.chapter03.model.LocationLatLngEntity
import fastcampus.aop.part4.chapter03.model.SearchResultEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initAdapter()
        initData()
        setData()
    }

    private fun initViews() = with(binding) {
        emptyResultTextView.isVisible = false
        searchRecyclerView.adapter
    }

    private fun initAdapter() {
        adapter = SearchRecyclerAdapter()
        binding.searchRecyclerView.adapter = adapter
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun initData() {
        adapter.notifyDataSetChanged()
    }

    private fun setData() {
        val dataList = (0..10).map {
            SearchResultEntity(
                name = "빌딩${it}",
                fullAddress = "주소${it}",
                locationLatLngEntity = LocationLatLngEntity(
                    it.toFloat(),
                    it.toFloat()
                )
            )
        }

        adapter.setSearchResultList(dataList) {

        }
    }
}