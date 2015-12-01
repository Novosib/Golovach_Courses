package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;
import static java.lang.System.arraycopy;

/**
 * Created by AdminAccount on 22.11.2015.
 */
public class DynamicArray {
    int[] data;

    public DynamicArray(){
        this.data = new int[0];
    }

    public void add(int elem){
        add(data.length, elem);
    }

    public void add(int index, int element){
        int tmp[] = new int[data.length + 1];
        arraycopy(data, 0, tmp, 0, index);
        arraycopy(data, index, tmp, index + 1, data.length - index);
        tmp[index] = element;
        this.data = tmp;
    }

    public void remove(){
        remove(data.length - 1);
    }

    public void remove(int index){
        int tmp[] = new int[data.length - 1];
        arraycopy(data, 0, tmp, 0, index);
        arraycopy(data, index + 1, tmp, index, data.length - index - 1);
        this.data = tmp;
    }
}
