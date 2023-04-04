package Game;

public class Item
{
    private int aValeur;
    private int aPoids;
    private String aNom;  
    //null si ce n'est pas un beamer, "uncharged" et "charged" si c'est un beamer
    private String aBeamer;
    
/**
 * Construit un item en fonction du poids, valeur et nom passer en paramètre
 */    
    public Item(final int pValeur, final int pPoids, final String pNom)
    {
        this.aValeur = pValeur;
        this.aPoids = pPoids;
        this.aNom = pNom;
        this.aBeamer = null;
    }
    public Item(final int pValeur, final int pPoids, final String pNom, final String pBeamer)
    {
        this(pValeur, pPoids, pNom);
        if(pBeamer.equals(null) || pBeamer.equals("uncharged") || pBeamer.equals("charged"))
        {this.aBeamer = pBeamer;}
        else
        {return;}
    }
/**
 * Retourne la valeur de l'objet
 */
    public int getValeur()
    {return this.aValeur;}

/**
 * Retourne le poids de l'objet
 */
    public int getPoids()
    {return this.aPoids;}

/**
 * Retourne le nom de l'objet
 */
    public String getNom()
    {return this.aNom;}
    
/**
 * Retourne la charge ou non de l'item
 */    
    public String getCharged()
    {return this.aBeamer;}

/**
 * modifie la charge de l'item
 */
    public void setCharged(final String pCharged)
    {
        if(pCharged.equals(null) || pCharged.equals("uncharged") || pCharged.equals("charged"))
        {this.aBeamer = pCharged;}
        else
        {return;}
    }
    
}
