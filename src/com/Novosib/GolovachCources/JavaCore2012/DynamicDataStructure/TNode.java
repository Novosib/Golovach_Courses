package com.Novosib.GolovachCources.JavaCore2012.DynamicDataStructure;

/**
 * Created by AdminAccount on 24.11.2015.
 */
public class TNode {
    int value;
    TNode nextLeft;
    TNode nextRight;

    TNode(int value, TNode nextL, TNode nextR){
        this.value = value;
        this.nextLeft = nextL;
        this.nextRight = nextR;
    }
}
