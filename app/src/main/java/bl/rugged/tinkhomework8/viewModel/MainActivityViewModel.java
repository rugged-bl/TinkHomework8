package bl.rugged.tinkhomework8.viewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import bl.rugged.tinkhomework8.Injection;
import bl.rugged.tinkhomework8.Node;
import bl.rugged.tinkhomework8.NodeDao;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends AndroidViewModel {
    public final MutableLiveData<List<Node>> nodesLiveData;
    private final NodeDao nodeDao;

    @SuppressLint("CheckResult")
    public MainActivityViewModel(Application application) {
        super(application);

        nodeDao = Injection.provideDatabse(application).nodeDao();
        this.nodesLiveData = new MutableLiveData<>();

        //noinspection ResultOfMethodCallIgnored
        Completable.fromAction(() -> {
            nodeDao.insert(new Node(10, 0));
            nodeDao.insert(new Node(11, 0));
            nodeDao.insert(new Node(12, 0));
        }).andThen(nodeDao.getNodesByParentId(0))
                .subscribeOn(Schedulers.io())
                .subscribe(value -> nodesLiveData.postValue(value));
    }

    @SuppressLint("CheckResult")
    public void onAdapterItemChosen(Node node) {
        //noinspection ResultOfMethodCallIgnored
        nodeDao.getNodesByParentId(node.getParentId())
                .subscribeOn(Schedulers.io())
                .subscribe(nodesLiveData::postValue);
    }
}