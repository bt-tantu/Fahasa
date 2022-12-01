package com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.ui.supervisor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.DAO.SupervisorDAO;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.R;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Adapter.SupervisorAdapter;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.databinding.FragmentSupervisorBinding;
import com.example.doanltttbdd_hoangnguyenanhvy_nguyenthithuytien.Model.Supervisor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SupervisorFragment extends Fragment {

    private FragmentSupervisorBinding binding;
    private View mRoot;
    private ListView listView;
    private final SupervisorDAO supervisorDAO= new SupervisorDAO();
    private SupervisorAdapter adapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSupervisorBinding.inflate(inflater, container, false);
        mRoot = binding.getRoot();
        listView = binding.listViewSupervisor;

        List<Supervisor> supervisors = new List<Supervisor>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Supervisor> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Supervisor supervisor) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Supervisor> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Supervisor> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Supervisor get(int i) {
                return null;
            }

            @Override
            public Supervisor set(int i, Supervisor supervisor) {
                return null;
            }

            @Override
            public void add(int i, Supervisor supervisor) {

            }

            @Override
            public Supervisor remove(int i) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Supervisor> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Supervisor> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Supervisor> subList(int i, int i1) {
                return null;
            }
        };

        adapter = new SupervisorAdapter(mRoot.getContext(), R.layout.activity_view_records, supervisors);

        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);


        binding.fabSupervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateSupervisorActivity.class);
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

    @Override
    public void onResume() {
        setArguments(null);
        if (listView != null) {
            updateListview();
        }
        super.onResume();
    }

    private void updateListview() {
        List<Supervisor> s = supervisorDAO.getAll();
        adapter = new SupervisorAdapter(mRoot.getContext(), R.layout.activity_view_records, s);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }
}