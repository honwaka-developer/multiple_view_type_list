package com.honwakadeveloper.multipleviewtypelist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.honwakadeveloper.multipleviewtypelist.adapter.ContentTypeListItem
import com.honwakadeveloper.multipleviewtypelist.adapter.MultipleTypeListAdapter
import com.honwakadeveloper.multipleviewtypelist.adapter.MultipleTypeListItem
import com.honwakadeveloper.multipleviewtypelist.adapter.HeaderTypeListItem

class MultipleTypeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MultipleTypeListAdapter
    private lateinit var viewManager: GridLayoutManager

    companion object {
        fun newInstance(): MultipleTypeListFragment {
            return MultipleTypeListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_multiple_type_list, container, false)

        val data: Array<MultipleTypeListItem> = arrayOf(
            HeaderTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            HeaderTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem(),
            ContentTypeListItem()
        )

        viewManager = GridLayoutManager(context, 3)
        viewManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {

                val viewType = viewAdapter.getItemViewType(position)

                return when (MultipleTypeListItem.type(viewType)) {
                    MultipleTypeListItem.Type.HEADER -> 3
                    MultipleTypeListItem.Type.CONTENT -> 1
                }
            }

        }

        viewAdapter = MultipleTypeListAdapter(data)

        recyclerView = view.findViewById<RecyclerView>(R.id.multiple_type_list_recycler_view).apply {

            layoutManager = viewManager

            adapter = viewAdapter
        }

        return view
    }
}