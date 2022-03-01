
package project;



public class ATM  {
    public User mainMenuPrompt(Bank theBank,String text,String passw) {
        return theBank.userLogin(text, passw);
    }

    public void transferFunds(User theUser, int toAc,int frAc,double amount) {

        theUser.addAcctTransaction(frAc, -1 * amount, String.format(
                "Transfer to account %s", theUser.getAcctUUID(toAc)));
        theUser.addAcctTransaction(toAc, amount,String.format(
                "Transfer from account %s", theUser.getAcctUUID(frAc)));

    }

    public void depositFunds(User theUser, int toAc,double amoun,String mem) {

        theUser.addAcctTransaction(toAc, amoun, mem);

    }

    public String[] showTransHistory(User theUser, int theAcct) {

      
        // print the transaction history
        return theUser.printAcctTransHistory(theAcct);

    }


  

    
}




