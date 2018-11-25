package bl.rugged.tinkhomework8;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "node_table")
public class Node {
    @PrimaryKey(autoGenerate = true)
    long id;
    int value;
    long parentId;

    public Node(int value, long parentId) {
        this.value = value;
        this.parentId = parentId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public long getParentId() {
        return parentId;
    }
}
