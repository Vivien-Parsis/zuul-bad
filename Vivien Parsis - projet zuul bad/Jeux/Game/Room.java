package Game;
import java.util.HashMap;
import java.util.Set;

public class Room
{
   private String aDescription;
   private HashMap<String, Room> aExits = null;
   private String aImageName;
   private ItemList aItem;
   private String aNom;

/**
 * Construit une salle en fonction de sa descprition et image passé en paramètre
 */
   public Room(final String pDescription, final String pImage, final String pNom)
   {
       this.aDescription = pDescription;
       this.aExits = new HashMap<String, Room>();
       this.aImageName = pImage;
       this.aItem = new ItemList();
       this.aNom = pNom;
   }
/**
 * Retourne la description de la salle
 */   
   public String getDescription()
   {return this.aDescription;}

/**
 * Met en place les sorties de la salle
 */   
    public void setExit(final String pDirection, final Room pRoom)
    {
        if(pDirection == null || pRoom == null)
        {return;}
        else
        {this.aExits.put(pDirection, pRoom);}
    }
 
/**
 * Retourne la sortie en fonction de la direction donnée en paramètre
 */
        
    public Room getExit(final String pDirection)
    {return this.aExits.get(pDirection);}
    
    
    public ItemList getItemList()
    {return this.aItem;}

/**
 * Retourne la description et sorties de la salle
 */
    
    public String getLongDescription()
    {return "" + this.aDescription + "\n" + this.getExitString();}

/**
 * Retourne les sorties
 */
    public String getExitString()
    {
        String vReponse = "Exits :";
        Set<String> keys = aExits.keySet();
        for(String aExits : keys)
        {vReponse +=" " + aExits;}
        return vReponse;
    }
/**
 * Retourne l'image de la salle
 */    
    public String getImageName()
    {return this.aImageName;}

/**
 * Retourne le nom de la salle
 */
    public String getNom()
    {return this.aNom;}

/**
 * Retourne la liste d'items de la salle courante
 */
    public ItemList getInventaire()
    {return this.aItem;}

/**
 * Ajoute l'item passé en parametre dans la liste d'items de la salle 
 */
    public void add(final Item pitem)
    {this.aItem.addItem(pitem);}

/**
 * Enleve l'item a l'index correspondant dans la liste d'item de la salle
 */
    public void remove(final int pindex)
    {this.aItem.removeItem(pindex);}
    
    
    public void setNom(final String pNom)
    {this.aNom = pNom;}
}

    