package com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2;

/**
 * Created by AdminAccount on 01.12.2015.
 */
public interface Account {
    public void change(int delta) throws TryAgainEx, ZedDeadEx;
    int getTotalChange();
}