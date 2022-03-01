
package project;

import java.security.MessageDigest;
import java.util.ArrayList;

public class User {
         // The first name of the user.

        private String firstName;


        // The last name of the user.

        private String lastName;


         //The ID number of the user.

        private String uuid;


          //the user's pin number.

        private byte pinHash[];


         // The list of accounts for this user.

        private ArrayList<Account> accounts;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

        
        
        /**
         * Create new user
         *  firstName   the user's first name
         *  lastName	the user's last name
         *  pin			the user's account pin number (as a String)
         *  theBank		the bank that the User is a customer of
         */
        public User (String firstName, String lastName, String pin, Bank theBank) {

            // set user's name
            this.firstName = firstName;
            this.lastName = lastName;

            // store the pin's
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                this.pinHash = md.digest(pin.getBytes());
            } catch (Exception e) {
                System.err.println("error, caught exeption : " + e.getMessage());
                System.exit(1);
            }

            // get a new, unique universal unique ID for the user
            this.uuid = theBank.getNewUserUUID();

            // create empty list of accounts
            this.accounts = new ArrayList<Account>();

          

        }

    public String getFirstName() {
        return firstName;
    }

        /**
         * Get the user ID number
         * return the uuid
         */
        public String getUUID() {
            return this.uuid;
        }

        /**
         * Add an  Current account for the user.
         * @param anAcct	the account to add
         */
        public void CurrentAccount(CurrentAccount anAcct) {
            this.accounts.add(anAcct);
        }

    /**
     * Add an  Saving account for the user.
     * @param anAcct	the account to add
     */
    public void SavingAccount(SavingAccount anAcct) {
        this.accounts.add(anAcct);
        
    }
   
    
        /**
         * Get the number of accounts the user has.
         * @return	the number of accounts
         */
        public int numAccounts() {
            return this.accounts.size();
        }

        /**
         * Get the balance of a particular account.
         * @param acctIdx	the index of the account to use
         * @return			the balance of the account
         */
        public double getAcctBalance(int acctIdx) {
            return this.accounts.get(acctIdx).getBalance();
        }

        /**
         * Get the UUID of a particular account.
         * @param acctIdx	the index of the account to use
         * @return			the UUID of the account
         */
        public String getAcctUUID(int acctIdx) {
            return this.accounts.get(acctIdx).getUUID();
        }

        /**
         * Print transaction history for a particular account.
         * @param acctIdx	the index of the account to use
         */
        public String[] printAcctTransHistory(int acctIdx) {
            
                    return this.accounts.get(acctIdx).printTransHistory();
        }

        /**
         * Add a transaction to a particular account.
         * @param acctIdx	the index of the account
         * @param amount	the amount of the transaction
         * @param memo		the memo of the transaction
         */
        public void addAcctTransaction(int acctIdx, double amount, String memo) {
            this.accounts.get(acctIdx).addTransaction(amount, memo);
        

        }


 /* Check whether a given pin matches the true User pin
	 * @param aPin	the pin to check
	 * @return		whether the pin is valid or not
	 */
    public boolean validatePin(String aPin) {


            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                return MessageDigest.isEqual(md.digest(aPin.getBytes()),
                        this.pinHash);
            } catch (Exception e) {
                System.err.println("error, caught exeption : " + e.getMessage());
                System.exit(1);
            }

            return false;
        }

      
        
        
    }

