package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.ui.category;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO.CategoryDAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter.CategoryAdapter;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.FragmentCategoryBinding;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Category;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.ui.home.HomeFragment;

import java.util.List;

public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding;

    private ListView listView;
    private CategoryAdapter adapter;
    private View mRoot;
    private final CategoryDAO categoryDAO = new CategoryDAO();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        mRoot = binding.getRoot();

        List<Category> categories = categoryDAO.getAll();
        listView = binding.listViewCategories;

        adapter = new CategoryAdapter(mRoot.getContext(), R.layout.activity_view_records, categories);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Category o = (Category) listView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putLong("id", o.getId());

                Fragment fragment = new HomeFragment();
                fragment.setArguments(bundle);

                Navigation.findNavController(mRoot).navigate(R.id.navigation_product, bundle);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateCategoryActivity.class);
                startActivity(intent);
            }
        });

        return mRoot;
    }

    @Override
    public void onResume() {
        setArguments(null);
        if (listView != null) {
            updateListview();
        }
        super.onResume();
    }

    private void updateListview() {
        List<Category> s = categoryDAO.getAll();
        adapter = new CategoryAdapter(mRoot.getContext(), R.layout.activity_view_records, s);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}