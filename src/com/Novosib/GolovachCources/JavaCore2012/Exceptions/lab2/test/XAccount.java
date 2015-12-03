package com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.test;

import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.Account;
import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.TryAgainEx;
import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.ZedDeadEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by AdminAccount on 01.12.2015.
 */
public class XAccount implements Account{
    private final Random rnd;
    private final AtomicBoolean zedDead;
    private int totalChange = 0;
    private List<Integer> history = new ArrayList<Integer>();
    private boolean imDead = false;

    XAccount(Random rnd, AtomicBoolean zedDead) {
        this.rnd = rnd;
        this.zedDead = zedDead;
    }

    @Override
    public void change(int delta) throws TryAgainEx, ZedDeadEx {
        if (imDead) {
            throw new ZedDeadEx("This account totally dead!");
        }

        int r = rnd.nextInt(100);
        //int r = rnd.nextInt(4);

        if (r == 0 && !zedDead.get()) {// r = 0 and zedDead = false
            zedDead.set(true);
            imDead = true;
            throw new ZedDeadEx("First time!");
        } else if (r < 50) {
            throw new TryAgainEx();
        } else {
            totalChange += delta;
            history.add(delta);
        }
    }

    public int getTotalChange() {
        return totalChange;
    }

    @Override
    public String toString() {
        return "Acc[totalChange=" + totalChange + ", history=" + history + "]";
    }
}