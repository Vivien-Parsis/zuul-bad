package Game;
 

public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
/**
 * Retourne le mot de la commande
 */    
    public String getCommandWord()
    {return this.aCommandWord;}
/**
 * Retourne le second mot
 */        
    public String getSecondWord()
    {return this.aSecondWord;}
/**
 * Test si la commande a un second mot ou non
 */    
    public boolean hasSecondWord()
    {
        if(this.aSecondWord != null){return true;}
        else{return false;}
    }
    
/**
 * Test si la commande est inconnu ou non
 */
    public boolean isUnknown()
    {
        if(this.aCommandWord == null){return true;}
        else{return false;}
    }
}