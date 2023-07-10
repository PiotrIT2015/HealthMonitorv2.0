package engine.pp.healthmonitor;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;


@Entity
public class memJoy {

    @PrimaryKey(autoGenerate = true)
    private int mem_id;

    @ColumnInfo(name = "note_content") // column name will be "note_content" instead of "content" in table
    private String content;

    private String title;

    public memJoy(int mem_id, String content, String title) {
        this.mem_id = mem_id;
        this.content = content;
        this.title = title;
    }

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof memJoy)) return false;

        memJoy mem = (memJoy) o;

        if (mem_id != mem.mem_id) return false;
        return title != null ? title.equals(mem.title) : mem.title == null;
    }



    @Override
    public int hashCode() {
        int result = mem_id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + mem_id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
