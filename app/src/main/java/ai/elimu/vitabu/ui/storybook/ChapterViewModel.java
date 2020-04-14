package ai.elimu.vitabu.ui.storybook;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ai.elimu.model.gson.content.multimedia.ImageGson;

public class ChapterViewModel extends ViewModel {

    private List<ImageGson> images;

    private MutableLiveData<Integer> index = new MutableLiveData<>();

    private LiveData<ImageGson> image = Transformations.map(index, new Function<Integer, ImageGson>() {
        @Override
        public ImageGson apply(Integer input) {
            Log.i(getClass().getName(), "apply");

            Log.i(getClass().getName(), "input: " + input);

            // Lookup image based on chapter index
            // TODO: use "input" variable to get the corresponding chapter
            ImageGson imageGson = images.get(0);

            return imageGson;
        }
    });

    private LiveData<String> text = Transformations.map(index, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            Log.i(getClass().getName(), "apply");

            Log.i(getClass().getName(), "input: " + input);

            return "Hello world from chapter: " + input;
        }
    });

    public void setImages(List<ImageGson> images) {
        this.images = images;
    }

    public void setIndex(int index) {
        this.index.setValue(index);
    }

    public LiveData<ImageGson> getImage() {
        return image;
    }

    public LiveData<String> getText() {
        return text;
    }
}