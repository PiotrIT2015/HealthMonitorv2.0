package engine.pp.healthmonitor;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

@Dao
public interface memDao {
    //@Query("SELECT * FROM videos")
    //List<memJoy> getAllImages();

    //@Query("SELECT * FROM videos WHERE video_name = :imageId")
    //memJoy getImageById(int imageId);

    @Insert
    void insertImage(memJoy image);

    @Update
    void updateImage(memJoy image);

    @Delete
    void deleteImage(memJoy image);
}
