
package project;



public class CurrentAccount  extends Account {
    /**
     * Create new Account instance
     *
     * @param name    the name of the account
     * @param holder  the User object that holds this account
     * @param theBank the bank that issues the account
     */
    public CurrentAccount(String name, User holder, Bank theBank) {
        super(name, holder, theBank);
    }

}
