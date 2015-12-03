package com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.test;

import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.Account;
import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.TransactionManager;
import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.TryAgainEx;
import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.ZedDeadEx;

import java.util.Arrays;

/**
 * Created by AdminAccount on 01.12.2015.
 */
public class ZTransactionManager implements TransactionManager {
    public boolean transfer(Account[] accounts, int[] money) {
        try {
            for (int k = 0; k < accounts.length; k++){
                while (true){
                    try {
                        accounts[k].change(money[k]);
                        break;
                    } catch (TryAgainEx e) {
                        //NOP
                    }
                }
            }
        } catch (ZedDeadEx e) {
            try {
                for (int k = 0; k < accounts.length; k++){
                    while (true){
                        try {
                            accounts[k].change(- accounts[k].getTotalChange());
                            break;
                        } catch (TryAgainEx ex) {
                            //NOP
                        }
                    }
                }
            } catch (ZedDeadEx zedDeadEx){
                //NOP
            }
            return false;
        }
        return true;
    }
}