
package project;

public class Input {
   private String firstName, lastName,pin;
   private char[] arr;
   private boolean ln,fn,pi,mm;
     
    public Input(String first,String last,String pin){
                firstName =first;
                arr=firstName.toCharArray();
                for (char c : arr) {
                    if (((c<=90)&&(c>=65))||((c<=122)&&(c>=97))) {
                     fn=false;
                    }else{fn=true;break;}
                }
               
                lastName = last;
                  arr=lastName.toCharArray();
                for (char c : arr) {
                    if (((c<=90)&&(c>=65))||((c<=122)&&(c>=97))) {
                     ln=false;
                    }else{ln=true;break;}
                }
               
                this.pin=pin;
                   arr=pin.toCharArray();
                    if (arr.length==4){
                        for (char c : arr) {
                            
                            if((c<=57)&(c>=49)) {
                                pi=false;
                            }else{pi=true;break;}
                        }
                    }
                    else{
                       pi=true; 
                    }
                
    }
    public boolean checkFLP(){
        if ((!ln)&(!fn)&(!pi)) {
        return true;}
       
       return false;
    }
    
    
     public Input(String s,String m){
               
                
                   arr=s.toCharArray();
                    if (arr.length<2000000000){
                        for (char c : arr) {
                            
                            if((c<=57)&(c>=48)) {
                                pi=true;
                            }else{pi=false;break;}
                        }
                    }
                    else{
                       pi=false; 
                    }
                    
                    
                    arr=m.toCharArray();

                            if(arr.length>=1) {
                               mm=true;
                            }else{mm=false;}
                        }
    
    
     public Input(String s){
               
                
                   arr=s.toCharArray();
                    if (arr.length<2000000000){
                        for (char c : arr) {
                            
                            if((c<=57)&(c>=48)) {
                                pi=true;
                            }else{pi=false;break;}
                        }
                    }
                    else{
                       pi=false; 
                    }
     }
      public boolean checkA(){
        if (pi) {
        return true;}
       
       return false;
    }
     
    public boolean checkAM(){
        if ((pi)&&(mm)) {
        return true;}
       
       return false;
    }
}
