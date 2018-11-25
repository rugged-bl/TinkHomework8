package bl.rugged.tinkhomework8;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;


@Dao
public interface NodeDao {
    @Insert
    long insert(Node user);

    @Query("DELETE FROM node_table")
    int deleteAll();

    @Query("SELECT * FROM node_table WHERE parentId = :id")
    Flowable<List<Node>> getNodesByParentId(long id);

    @Query("SELECT * FROM node_table")
    Flowable<List<Node>> getAllNodes();
}
