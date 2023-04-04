package Game;
import java.util.List;
import java.util.ArrayList;

public class ItemList
{
    private List<Item> aItemList; 
    
    public ItemList()
    {
        aItemList = new ArrayList<Item>();
    }
    
/**
 * retourne la liste d'items de item list
 */
    public List<Item> getItems()
    {
        List<Item> vItem = new ArrayList<Item>();
        for(Item vElement : this.aItemList)
        {vItem.add(vElement);}
        return vItem;
    }
    
/**
 * retourne l'item a l'index correspond dans la liste d'item
 */
    public Item getItem(final int pInd)
    {return aItemList.get(pInd);}
    
/**
 * ajoute un item dans la liste d'items
 */    
    public void addItem(final Item pItem)
    {
        aItemList.add(pItem);
    }
    
/**
 * supprime l'item a l'index correspond 
 */
    public void removeItem(final int pIndex)
    {
        aItemList.remove(pIndex);
    }

/**
 * retourne la taille de la liste d'items
 */
    public int listSize()
    {return aItemList.size();}
}
