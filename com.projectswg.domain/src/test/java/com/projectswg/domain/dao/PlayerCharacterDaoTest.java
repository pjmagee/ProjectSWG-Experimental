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

import javax.persistence.PersistenceException;
import java.util.Arrays;
import java.util.List;

@RunWith(JUnit4.class)
public class PlayerCharacterDaoTest extends TestCase {

    private Injector injector;
    private AccountDao accountDao;
    private PlayerCharacterDao characterDao;
    private Account account;

    @Before
    public void setUp() throws Exception {

        /*
            Setup Guice
         */
        injector = Guice.createInjector(new PersistenceModule("projectswg"));
        accountDao = injector.getInstance(AccountDao.class);
        characterDao = injector.getInstance(PlayerCharacterDao.class);

        /*
            Account entity for player character entities
         */
        account = new Account("pjmagee", "password");
        assertNull(account.getId());

        /*
            Save the entity to the db
         */
        accountDao.save(account);
        assertNotNull(account.getId());

         /*
            Attach entity
         */
        account = accountDao.find(account.getId());
    }

    @After
    public void tearDown() throws Exception {

       /*
            Cleanup any resources
        */

    }

    @Test(expected = PersistenceException.class)
    public void testSaveFailsWithoutAccount() throws Exception {

        PlayerCharacter playerCharacter = new PlayerCharacter("patrick", "magee");
        characterDao.save(playerCharacter);
    }

    @Test
    public void testSaveSuccessfulWithAccount() throws Exception {

        /*
            Create new character associated with attached entity
         */
        PlayerCharacter playerCharacter = new PlayerCharacter("patrick", "magee", account);

        assertNull(playerCharacter.getId());
        characterDao.save(playerCharacter);
        assertNotNull(playerCharacter.getId());

    }


    @Test
    public void testFindAllCharactersByAccount() throws Exception {

        /*
            Create some characters associated with this account
         */

        PlayerCharacter[] charactersToSave = new PlayerCharacter[]
        {
                new PlayerCharacter("pjmagee", "password", account),
                new PlayerCharacter("another", "password", account),
                new PlayerCharacter("treeku", "password", account),
                new PlayerCharacter("timm", "password", account),
                new PlayerCharacter("cable", "password", account),
                new PlayerCharacter("levarris", "password", account),
                new PlayerCharacter("mulligan", "password", account),
                new PlayerCharacter("cekis", "password", account)
        };

        int size = charactersToSave.length;

        /*
            Save the characters
         */
        for(PlayerCharacter character : Arrays.asList(charactersToSave)){

            assertNull(character.getId());
            characterDao.save(character);
            assertNotNull(character.getId());
            assertSame(character.getAccount(), account);
            System.out.println(character.toString());
        }

        /*
            Now find them by the account id
         */

        List<PlayerCharacter> characters = characterDao.findAllByAccountId(account.getId());
        assertSame(characters.size(), size); // check same result returned



    }

    @Test
    public void testFind() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }
}
