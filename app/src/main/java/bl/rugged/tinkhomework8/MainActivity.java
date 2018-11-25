package bl.rugged.tinkhomework8;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import bl.rugged.tinkhomework8.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private NodesAdapter adapter;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        setContentView(R.layout.activity_main);

        initRecyclerView();

        viewModel.nodesLiveData.observe(this, this::applyNewViewState);
    }

    private void applyNewViewState(List<Node> nodes) {
        if (nodes != null) {
            adapter.setData(nodes);
        }
    }

    private void onAdapterItemChosen(Node coinInfo) {
        viewModel.onAdapterItemChosen(coinInfo);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NodesAdapter(this::onAdapterItemChosen);
        recyclerView.setAdapter(adapter);
    }
}
