package com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.test;

import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.Account;
import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.TransactionManager;
import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.TryAgainEx;
import com.Novosib.GolovachCources.JavaCore2012.Exceptions.lab2.ZedDeadEx;

/**
 * Created by AdminAccount on 01.12.2015.
 */
public class YTransactionManager implements TransactionManager {
    @Override
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
            return false;
        }
        return true;
    }
}