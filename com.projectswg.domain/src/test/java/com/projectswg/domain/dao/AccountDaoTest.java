package com.projectswg.domain.dao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.projectswg.domain.entity.Account;
import com.projectswg.domain.entity.PlayerCharacter;
import com.projectswg.domain.module.PersistenceModule;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;
import java.util.List;

@RunWith(JUnit4.class)
public class AccountDaoTest extends TestCase {

    private Injector injector;
    private AccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new PersistenceModule("projectswg"));
        accountDao = injector.getInstance(AccountDao.class);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

        /*
            Add an account to the database
         */
        Account account = new Account("pjmagee", "password");
        assertNull(account.getId());
        accountDao.save(account);
        assertNotNull(account.getId());


    }

    @Test
    public void testFindAccountByCharacterId() {

        PlayerCharacterDao characterDao = injector.getInstance(PlayerCharacterDao.class);

        Account account = new Account("pjmagee", "password", new Date());
        accountDao.save(account);
        assertNotNull(account.getId());

        account = accountDao.find(account.getId());

        PlayerCharacter character = new PlayerCharacter("Darth", "Vader", account);
        characterDao.save(character);
        assertNotNull(character.getId());

        Account foundAccount = accountDao.findAccountByCharacterId(character.getId());

        assertNotNull(foundAccount);

    }

    @Test
    public void testFindAllAccounts() throws Exception {

        /*
            Add accounts to the database
         */

        Account[] accounts = new Account[]
                {
                        new Account("pjmagee", "password"),
                        new Account("another", "password"),
                        new Account("treeku", "password"),
                        new Account("timm", "password"),
                        new Account("cable", "password"),
                        new Account("levarris", "password"),
                        new Account("mulligan", "password"),
                        new Account("cekis", "password")
                };

        int size = accounts.length;

        for(Account account : accounts) {
            accountDao.save(account);
            assertNotNull(account.getId());
        }

        List<Account> all = accountDao.findAll();

        assertSame(all.size(), size);

    }

    @Test
    public void testFindAccountById() throws Exception {

        Account account = new Account("pjmagee", "password");
        assertNull(account.getId());
        accountDao.save(account);
        assertNotNull(account.getId());

        account = accountDao.find(account.getId());

        assertNotNull(account);

    }


    @Test(expected = javax.persistence.EntityNotFoundException.class)
    public void testRemoveAccount() throws Exception  {

        /*
            Create the account
         */
        Account account = new Account("pjmagee", "password");
        assertNull(account.getId());

        /*
            Save the account
         */
        accountDao.save(account);
        assertNotNull(account.getId());

        /*
            Find the account
         */
        account = accountDao.find(account.getId());
        assertNotNull(account);

        long id = account.getId();

        /*
            Delete the account
         */

        accountDao.remove(account);

        /*
            Throw exception from not finding account with id
         */
        accountDao.find(id);
    }
}
