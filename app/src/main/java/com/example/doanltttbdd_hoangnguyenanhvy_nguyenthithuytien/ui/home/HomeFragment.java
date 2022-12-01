package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO.ProductDAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.HomeActivity;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.MainActivity;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter.ProductAdapter;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.FragmentHomeBinding;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Product;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ListView listView;
    private ProductAdapter adapter;
    private View mRoot;
    ProductDAO productDAO = new ProductDAO();
    String idCat = null;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        mRoot = binding.getRoot();
        setHasOptionsMenu(true);
        listView = binding.listViewHome;
        if (getArguments() != null) {
            Log.e("Debug2", "onCreateView: " + idCat);

            idCat = String.valueOf(getArguments().getLong("id"));
        }
        List<Product> products = productDAO.filterByCat(idCat);
        setArguments(null);
        adapter = new ProductAdapter(mRoot.getContext(), R.layout.activity_view_records, products);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateProductActivity.class);
                startActivity(intent);
            }
        });

        binding.fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditProductActivity.class);
                startActivity(intent);
            }
        });

        binding.fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DeleteProductActivity.class);
                startActivity(intent);
            }
        });

        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void updateListview() {
        List<Product> products = productDAO.filterByCat(idCat);
        adapter = new ProductAdapter(mRoot.getContext(), R.layout.activity_view_records, products);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        idCat = null;
    }

    @Override
    public void onResume() {
        setArguments(null);
        if (listView != null) {
            updateListview();
        }
        super.onResume();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(((HomeActivity) mRoot.getContext()).getSupportActionBar().getThemedContext());
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);
        item.setActionView(searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Product> products = productDAO.filterByName(newText);
                adapter = new ProductAdapter(mRoot.getContext(), R.layout.activity_view_records, products);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                return false;
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                          }
                                      }
        );
    }
}