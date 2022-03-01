
package project;

import java.util.ArrayList;
import java.util.Random;

public class Bank {


    /**
 * The name of the bank.
 */
private final String name= "National Bank of Egypt";



    /**
     * The account holders of the bank.
     */
    private ArrayList<User> users;

    /**
     * The accounts of the bank.
     */
    private ArrayList<Account> accounts;

    /**
     * Create a new Bank object with empty lists of users and accounts.
     */
    public Bank() {


        // init users and accounts
        users = new ArrayList<User>();
        accounts = new ArrayList<Account>();

    }



        /* The compareTo() method compares two strings lexicographically.
         The comparison is based on the Unicode value of each character in the strings.
         The method returns 0 if the string is equal to the other string.
         */


        /**
         * Generate a new universally unique ID for a user.
         * return the uuid
         */
        public String getNewUserUUID() {

            // inits
            String uuid;
            Random rng = new Random();
            int len = 7;
            boolean nonUnique;

            // continue looping until we get a unique ID
            do {

                // generate the number
                uuid = "";
                for (int c = 0; c < len; c++) {
                    uuid += ((Integer)rng.nextInt(10)).toString();
                }

                // check to make sure it's unique
                nonUnique = false;
                //Enhanced for Loop
                //it will loop in the arraylist of type User which is in the bank class
                for (User u : this.users) {
                    if (uuid.compareTo(u.getUUID()) == 0) {
                        nonUnique = true;
                        break;
                    }
                }

            } while (nonUnique);

            return uuid;
        }

        /**
         * Generate a new universally unique ID for an account.
         * 	return the uuid
         */
        public String getNewAccountUUID() {

        // inits
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique = false;

        // continue looping until we get a unique ID
        do {

            // generate the number
            uuid = "";
            for (int c = 0; c < len; c++) {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            // check to make sure it's unique
            //Enhanced for Loop
            //it will loop in the arraylist of type Account which is in the bank class

            for (Account a : this.accounts) {
                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;

    }


     /* Create a new user of the bank.
            * @param firstName	the user's first name
            * @param lastName	the user's last name
            * @param pin				the user's pin
            * @return					the new User object
	 */
    public User addUser(String firstName, String lastName, String pin) {

        // create a new User object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        // create a current account for the user and add it to our list
        CurrentAccount newCurrentAccount = new CurrentAccount("Current", newUser, this);
        // create a savings account for the user and add it to our list
        SavingAccount newSavingAccount = new SavingAccount("Saving", newUser, this);
        //adding the accounts the list of the user's accounts
        newUser.CurrentAccount(newCurrentAccount);
        newUser.SavingAccount(newSavingAccount);
        //adding the accounts the list of the Bank's accounts

        this.accounts.add(newCurrentAccount);
        this.accounts.add(newSavingAccount);

        return newUser;

    }

    /**
     * Add an existing account for a particular User.
     * @param newCurrentAccount	the account
       @param newSavingAcccount the account      */
    public void addAccount(CurrentAccount newCurrentAccount,SavingAccount newSavingAcccount) {
        this.accounts.add(newSavingAcccount);
        this.accounts.add(newCurrentAccount);

    }

    /**
     * Get the User object associated with a particular userID and pin, if they
     * are valid.
     *	the user UUID to log in
     * 	the associate pin of the user
     * 	the User object, if login is successfull, or null, if
     * 	it is not
     */
    public User userLogin(String userID, String pin) {

        // search through list of users
        for (User u : this.users) {

            // if we find the user, and the pin is correct, return User object
            if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
                return u;
            }
        }

        // if we haven't found the user or have an incorrect pin, return null
        return null;

    }

    /**
     * Get the name of the bank.
     * @return	the name
     */
    public String getName() {
        return this.name;
    }

}
