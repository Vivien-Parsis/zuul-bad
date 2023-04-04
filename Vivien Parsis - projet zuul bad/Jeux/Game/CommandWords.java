package Game;
 

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{

    public final String[] aValidCommands;

    public CommandWords()
    {this.aValidCommands = new String[]{"go", "help", "quit","look","eat","back","test","take","drop","rest","inventory","time","use"};}

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        for ( int i=0; i<this.aValidCommands.length; i++ ) {
            if ( this.aValidCommands[i].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands
        return false;
    }
    
    /**
     * Affiche tout les commandes possibles
     */
    public void showAll()
    {
        String reponse = "Command : ";
        for(int x = 0; x<aValidCommands.length; x++)
        {reponse+=" " + aValidCommands[x];}
        System.out.println(reponse);
    }
    /**
     * Retourne la liste de toute les commande possible
     */
    public String getCommandList()
    {
        String reponse = "Command : ";
        for(int x = 0; x<aValidCommands.length; x++)
        {reponse+= " " + aValidCommands[x];}
        return reponse;
    }
}