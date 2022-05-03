package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.exception.ExpenseManagerException;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.ui.MainActivity;
import android.database.sqlite.SQLiteDatabase;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.DatabaseHelper;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.InMemoryAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.InMemoryTransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;

public class PersistentDemoExpenseManager extends ExpenseManager{
    MainActivity context;

    public PersistentDemoExpenseManager(MainActivity context) {
        this.context=context;
        try {
            setup();
        } catch (ExpenseManagerException e) {
            System.out.println(e);
        }

    }

    @Override
    public void setup() throws ExpenseManagerException {
        DatabaseHelper dh = new DatabaseHelper(this.context);
        TransactionDAO persistentTransactionDAO = new PersistentTransactionDAO(dh);
        setTransactionsDAO(persistentTransactionDAO);

        AccountDAO persistentAccountDAO = new PersistentAccountDAO(dh);
        setAccountsDAO(persistentAccountDAO);

    }


}
