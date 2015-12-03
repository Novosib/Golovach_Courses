package com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.test;

import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.TransactionManager;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by AdminAccount on 01.12.2015.
 */
public class TestTransactionManager {
    public static void main(String[] args) {
        for (int k = 0; k < 1000000; k++){
            final Random rnd = new Random(k);
            TransactionManager manager = new ZTransactionManager();
            final AtomicBoolean zedDead = new AtomicBoolean(false);
            XAccount[] accounts = {
                new XAccount(rnd, zedDead),
                new XAccount(rnd, zedDead),
                new XAccount(rnd, zedDead)};
            int[] money = {-1, -1, +2};
            boolean ok = manager.transfer(accounts, money);
            if(ok){
                for (int i = 0; i < accounts.length; i++){
                    if (accounts[i].getTotalChange() != money[i]){
                        throw new AssertionError("FAIL commit: " + Arrays.toString(accounts));
                    }
                }
            }else {
                if(!zedDead.get()){
                    throw new AssertionError("Zed alive but rollback!!!");
                }
                for (int i = 0; i < accounts.length; i++){
                    if (accounts[i].getTotalChange() != 0){
                        throw new AssertionError("FAIL rollback: " + Arrays.toString(accounts));
                    }
                }
            }
        }
        System.out.println("OK");
    }
}