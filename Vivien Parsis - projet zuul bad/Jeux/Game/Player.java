package Game;

public class Player
{
    private String aNomIG;
    private int aPoids;
    private int aPoidsMax;
    private ItemList aInventaire;
    private Room aCurrentRoom;
    
    public Player()
    {
        this.aPoids = 0;
        this.aPoidsMax = 10;
        this.aNomIG = "";
        this.aInventaire = new ItemList();
    }
    
/**
* retourne la salle courante du joueur
*/
    public Room getPlayerRoom()
    {return this.aCurrentRoom;}

/**
* retourne la liste d'items du joueur
*/
    public ItemList getInventaire()
    {return this.aInventaire;}

/**
 * retourne le poids max du joueur
 */
    public int getPoidsMax()
    {return this.aPoidsMax;}

/**
 * modifie la salle courante du joueur
 */
    public void setPlayerRoom(final Room pR)
    {this.aCurrentRoom = pR;}

/**
 * modifie le nom du joueur
 */
    public void setPlayerNom(final String pNom)
    {this.aNomIG=pNom;}

/**
 * modifie le poids max du joueur
 */
    public void setPoidsMax(final int ppoids)
    {this.aPoidsMax=ppoids;}

/**
 * enleve l'items a l'index correspondante dans la liste d'items du joueur
 */
    public void remove(final int pindex)
    {this.aInventaire.removeItem(pindex);}

/**
 * ajoute un items passé en parametre dans la liste d'items  du joueur
 */
    public void add(final Item pitem)
    {this.aInventaire.addItem(pitem);}

/**
 * drop l'items correspondant passé en parametre depuis la liste d'item du joueur
 */
    public String playerDrop(final String pDropItem)
    {
        if(aInventaire==null || aInventaire.listSize()==0)
        {return "You have no item";}
        else
        {
            for(int x=0; x<this.aInventaire.listSize(); x++)
            {
                Item vItem = aInventaire.getItem(x);
                if(vItem.getNom().equals(pDropItem))
                {
                    this.aPoids-=vItem.getPoids();
                    this.aInventaire.removeItem(x);
                    this.aCurrentRoom.add(vItem);
                    return "You drop the "+pDropItem;
                }
            }   
            return "Unknow item"; 
        } 
    }
/**
 * prend l'items correspondant passé en parametre depuis la salle courante
 */    
    public String playerTake(final String pTakeItem)
    {
        if(this.aCurrentRoom.getInventaire().listSize()==0)
        {return "No item here";}
        else
        {
            if(this.aPoids==this.aPoidsMax)
            {return "Inventory full";}
            
            for(int x=0; x<this.aCurrentRoom.getItemList().listSize(); x++)
            {
                Item vItem = this.aCurrentRoom.getItemList().getItem(x);
                if(vItem.getNom().equals(pTakeItem))
                {
                    this.aPoids+=vItem.getPoids();
                    this.aCurrentRoom.remove(x);
                    this.aInventaire.addItem(vItem);
                    return "You take the "+pTakeItem;
                }
            }
            return "Unknow Item";
        }
    }

}
