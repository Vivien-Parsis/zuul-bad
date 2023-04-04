package Game;

import java.util.List;
import java.util.Stack;
import java.util.Scanner;

public class GameEngine
{
    private boolean aJour;
    private Parser aParser;
    private UserInterface aGui;
    private Stack<Room> aLastRooms;
    private final String[] aDirection = {"north","east","south","west","up","down"};
    private final String[] aCommandValide = {"go", "help", "quit","look","eat","back","test","take","drop","rest","inventory","time","use"};
    private Room[] aAllRooms;
    private Item[] aAllItems;
    private Player aPlayer;
    private int aTimeLimit;
    private final int aTimeMax = 100;
    
/**
 * Creer le moteur de jeu
 * Execute la création des Rooms
 */
    
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aPlayer = new Player();
        this.createRooms();
        aLastRooms = new Stack();
    }
    
/**
* Initialise l'interface
*/
 
    public void setGUI(final UserInterface pInterface)
    {
        this.aGui = pInterface;
        this.printWelcome();
    }
    
/**
* Creer les rooms et les items, et affecte les sorties et items pour les rooms
*/
    
    public void createRooms()
    {
        
        //instancier et iniatilisation des rooms
        
        Room vSpawnForest = new Room("You are wander in a burn part in a forest","Images/Foret00.png","vSpawnForest");
        Room vForest01 = new Room("You are in a greenfull forest, you can only go on north or on south","Images/Foret01.png","vForest01");
        Room vForest02 = new Room("You are in a greenfull forest, you can only go on north or on south","Images/Foret02.png","vForest02");
        Room vForest03 = new Room("You are in a greenfull forest, on north you see a high cliffs and the citie on east","Images/Foret03.png","vForest03");
        Room vMontain = new Room("You are on a top of the moutain, you can only in enter in the castle located on east","Images/Montagne.png","vMontain");
        
        Room vCastle = new Room("You are wander in the castle","Images/Chateau.png","vCastle");
        Room vCities = new Room("You are wander in the citie, you see a tavern","Images/Ville.png","vCities");
        Room vGate = new Room("Front of you, you see the gate of the citie","Images/Porte.png","vGate");
        Room vVillage = new Room("You are wander in the village, you see a inn, a merchant and a forge","Images/Village.png","vVillage");
        Room vForest10 = new Room("You are in a greenfull forest, you can only go on east or on west","Images/Foret10.png","vForest10");
        
        Room vPlain20 = new Room("You are wander in a plain","Images/Plaine.png","vPlain20");
        Room vWell = new Room("You are in a crossroads, wich next to a well","Images/Puit.png","vWell");
        Room vCamp = new Room("You are close to a bandits camps","Images/Campement.png","vCamp");
        Room vFreezemount1 = new Room("You feel cold temperature","Images/MontagneFroid23.png","vFreezemount1");
        Room vFreezemount2 = new Room("You feel cold temperature and on west, you see the castle","Images/MontagneFroid24.png","vFreezemount2");
        
        Room vCourSud = new Room("You are in south Courtyard","Images/CourSud.png","vCourSud");
        Room vCourEst = new Room("You are in east Courtyard","Images/CourEst.png","vCourEst");
        Room vJardin = new Room("You are wander in the garden","Images/Jardin.png","vJardin");
        Room vCaserne = new Room("You are in barracks","Images/Caserne.png","vCaserne");
        Room vEntre = new Room("You are in the main enter of the castle","Images/Chateau.png","vEntre");
        
        Room vForest00 = new Room("You are outside the forest","Images/Foret00.png","vForest00");
        
        aAllRooms = new Room[] {vSpawnForest, vForest01, vForest02, vForest03, vMontain, vCastle, vCities, vGate, vVillage,
            vForest10, vPlain20, vWell, vCamp, vFreezemount1, vFreezemount2, vCourSud, vCourEst, vJardin, vCaserne, vEntre, vForest00};
        
        //instanciation et initialisation des items
        Item vEpee = new Item(2,2,"sword");
        Item vDocument = new Item(0,1,"original_file");
        Item vPomme = new Item(0,1,"Apple");
        Item vTenueGarde = new Item(0,3,"uniform_guard");
        Item vTenueFroid = new Item(0,3,"warm_cloth");
        Item vTenueDiscrete = new Item(0,3,"discreet_outfit");
        Item vDague = new Item(2,0,"bandits_dagger");
        Item vBaton = new Item(0,0,"Stick");
        Item vCookie = new Item(0,0,"cookie");
        Item vBeamer = new Item(0,0,"Beamer","uncharged");
        
        Item vFeuille = new Item(0,0,"Feuille");
        
        aAllItems = new Item[] {vEpee, vDocument, vPomme, vTenueGarde, vTenueFroid, vTenueDiscrete, vDague, vBaton, vCookie, vBeamer, vFeuille};
            
        //iniatilisation des sorties
        
        vSpawnForest.setExit("north",vForest01);vSpawnForest.setExit("east",vForest10);
        vForest01.setExit("north",vForest02);vForest01.setExit("south",vSpawnForest);
        vForest02.setExit("north",vForest03);vForest02.setExit("south",vForest01);
        vForest03.setExit("north",vMontain);vForest03.setExit("east",vCities);vForest03.setExit("south",vForest02);
        vMontain.setExit("east",vJardin);
        
        vForest10.setExit("west",vSpawnForest);vForest10.setExit("east",vPlain20);
        vVillage.setExit("north",vGate);vVillage.setExit("east",vWell);
        vGate.setExit("north",vCities);vGate.setExit("south",vVillage);
        vCities.setExit("up",vCourSud);vCities.setExit("south",vGate);
        
        vPlain20.setExit("north",vWell);vPlain20.setExit("west",vForest10);
        vWell.setExit("north",vCamp);vWell.setExit("west",vVillage);vWell.setExit("south",vPlain20);
        vCamp.setExit("south",vWell);
        vFreezemount1.setExit("up",vFreezemount2);vFreezemount1.setExit("south",vCamp);
        vFreezemount2.setExit("west",vEntre);
        
        vCourSud.setExit("down",vCities);vCourSud.setExit("east",vCaserne);vCourSud.setExit("north",vJardin);
        vCaserne.setExit("west",vCourSud);vCaserne.setExit("north",vCourEst);
        vCourEst.setExit("south",vCaserne);vCourEst.setExit("west",vJardin);
        vJardin.setExit("south",vCourSud);vJardin.setExit("east",vCourEst);vJardin.setExit("north",vEntre);
        vEntre.setExit("south",vEntre);
        
        
        vForest00.setExit("north",vSpawnForest);
        vSpawnForest.setExit("south",vForest00);
        
        
        //iniatialisation des items des rooms
        
        vForest10.add(vPomme);
        vForest10.add(vBaton);
        vForest01.add(vCookie);
        vForest02.add(vEpee);
        vCaserne.add(vTenueGarde);
        vEntre.add(vDocument);
        vSpawnForest.add(vBaton);
        vWell.add(vBeamer);
        
        vForest00.add(vFeuille);

        //Room de départ
        
        this.aPlayer.setPlayerRoom(vSpawnForest);
        
        this.aTimeLimit = 0;
    }
/**
 * Exectue une autre méthode en fonction de la commande passé en paramètre
 * 
 */
    
    public void interpretCommand(final String pCommandLine)
    {
        int test = 0;
        this.aGui.println("> "+pCommandLine);
        Command vCommand = this.aParser.getCommand(pCommandLine);
        
        if(vCommand.isUnknown()==true)
        {this.aGui.println("I don't know what you mean...");return;}
        
        String vCommandWord = vCommand.getCommandWord();
        for(int x=0; x<aCommandValide.length; x++)
        {if(vCommandWord.equals(aCommandValide[x])){test=x+1;break;}}
        
        if(test==1){this.goRoom(vCommand);}
        if(test==2){this.printHelp();}
        if(test==3){this.quit(vCommand);}
        if(test==4){this.look(vCommand);}
        if(test==5){this.eat(vCommand);}
        if(test==6){this.back(vCommand);}
        if(test==7){this.test(vCommand);}
        if(test==8){this.take(vCommand);}
        if(test==9){this.drop(vCommand);}
        if(test==10){this.rest(vCommand);}
        if(test==11){this.inventory();}
        if(test==12){this.time(vCommand);}
        if(test==13){this.use(vCommand);}
    }
    
/**
 * Affiche un message de bienvenue
 */
    
    public void printWelcome()
    {
        this.aGui.println("Welcome to the World of Zuul!");
        this.aGui.println("World of Zuul is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help.");
        this.aGui.println("");
        this.printLocationInfo();
        if(this.aPlayer.getPlayerRoom().getImageName()!=null)
        {this.aGui.showImage(this.aPlayer.getPlayerRoom().getImageName());}
    }
    
/**
 * Affiche un message d'aide
 */
    
    public void printHelp()
    {
        this.printLocationInfo();
        this.aGui.println("");
        this.aGui.println("Your command words are:");
        this.aGui.println(this.aParser.showCommands());
    }
    
/**
 * Affiche la description des items presant dans la salle courante
 */
    
    public void printItemDescription()
    {
        List<Item> vCollection = this.aPlayer.getPlayerRoom().getInventaire().getItems();
        String reponse="";
        if(vCollection.size()==0)
        {reponse = "there is no item here";}
        else
        {
            reponse += "there is a";
            for (Item vElement : vCollection)
            {
                reponse += " " + vElement.getNom();
            }
        }
        this.aGui.println(reponse);
    }
    
/**
 * Affiche les informations de la salle courante
 */
    
    public void printLocationInfo()
    {
        this.aGui.println(this.aPlayer.getPlayerRoom().getLongDescription());
        if(this.aPlayer.getPlayerRoom().getImageName()!=null)
        {this.aGui.showImage(this.aPlayer.getPlayerRoom().getImageName());}
        this.printItemDescription();
        
    }
    
/**
 * Méthode executer pour quitter
 */
    public void quit(final Command pCom)
    {
        if(pCom.hasSecondWord()==true)
        {this.aGui.println("Quit what ??");}
        else
        {
            this.aGui.println("Thank you for playing. Good bye.");
            this.aGui.enable(false);
            System.exit(0);
        }
    }
    
/**
 * Méthode executer pour regarder
 */   
    
    public void look(final Command plook)
    {
        if(plook.hasSecondWord()==true)
        {this.aGui.println("I don't know how to look at something in particular yet.");}
        else
        {this.aGui.println(this.aPlayer.getPlayerRoom().getLongDescription());}
    }
    
/**
 * Méthode pour retourner en arrière
 */
    
    public void back(final Command pback)
    {
        if(aLastRooms.empty()==false && aLastRooms!=null)
        {
            if(pback.hasSecondWord()==true){this.aGui.println("error");return;}
            Room vBack = this.aLastRooms.pop();
            this.aPlayer.setPlayerRoom(vBack);
            this.printLocationInfo();
            if(this.aPlayer.getPlayerRoom().getImageName()!=null)
            {this.aGui.showImage(this.aPlayer.getPlayerRoom().getImageName());}
            this.aTimeLimit += 1;
        }
        else
        {this.aGui.println("error");}
    }
    
/**
 * Méthode pour manger
 */
    
    public void eat(final Command peat)
    {
        if(peat.hasSecondWord()==false)
        {this.aGui.println("eat what ?");return;}
        
        if(peat.getSecondWord().equals("Apple") || peat.getSecondWord().equals("cookie"))
        {
            if(this.aPlayer.getInventaire().listSize()==0)
            {this.aGui.println("you have no item");return;}
            
            List<Item> vinventaire = this.aPlayer.getInventaire().getItems();
            for(int x = 0; x<vinventaire.size(); x++)
            {
                Item vitem = vinventaire.get(x);
                if(vitem.getNom().equals("Apple") || vitem.getNom().equals("cookie"))
                {
                    this.aGui.println("you have eaten " + vitem.getNom());
                    if(vitem.getNom().equals("cookie"))
                    {this.aPlayer.setPoidsMax(2*this.aPlayer.getPoidsMax());}
                    this.aPlayer.remove(x);
                    return;
                }
                
            }
            
            this.aGui.println("you have item to eat");
        }
        this.aGui.println("eat what ?");
    }

/**
 * méthode pour executé les commandes d'un fichier text de test
 */    
    public void test(final Command ptest)
    {
        if(ptest.hasSecondWord()==false)
        {
            this.aGui.println("error : unknow path file");
            return;
        }
        String vS = ptest.getSecondWord();
        java.io.InputStream vIS = this.getClass().getResourceAsStream(vS+".txt");
        Scanner sc = new Scanner(vIS);
        while(sc.hasNextLine())
        {
            String vLigne = sc.nextLine();
            this.interpretCommand(vLigne);
        } 
    }
    
/**
 * méthode pour faire dormir le joueur
 */    
    public void rest(final Command prest)
    {
        if(prest.hasSecondWord()==false)
        {
            if(this.aPlayer.getPlayerRoom().getNom().equals("vCities")
            ||this.aPlayer.getPlayerRoom().getNom().equals("vVillage")
            ||this.aPlayer.getPlayerRoom().getNom().equals("vSpawnForest"))
            {
                this.aGui.println("you rest");
                this.aTimeLimit += 1;
                if(aJour==false){aJour=true;return;}
                if(aJour==true){aJour=false;return;}
            }
            else
            {this.aGui.println("You can't rest here.");}
        }
        else
        {this.aGui.println("rest what ?");}
    }

 /**
 * méthode pour que le joueur prenne un item
 */    
    public void take(final Command ptake)
    {
        if(ptake.hasSecondWord()==false)
        {this.aGui.println("take what ?");return;}
        String vR = ptake.getSecondWord();
        vR = this.aPlayer.playerTake(vR);
        this.aGui.println(vR);
    }
    
/**
 * méthode pour faire tomber un item du joueur dans la salle courante
 */    
    public void drop(final Command pdrop)
    {
        if(pdrop.hasSecondWord()==false)
        {this.aGui.println("drop what ?");return;}
        String vR = pdrop.getSecondWord();
        vR = this.aPlayer.playerDrop(vR);
        this.aGui.println(vR);
    }
 
/**
 * méthode pour afficher l'inventaire du joueur
 */
    public void inventory()
    {
        String vReponse= "";
        ItemList vItems = this.aPlayer.getInventaire();
        if(vItems.listSize()==0)
        {
            this.aGui.println("no item in your inventory");
            return;
        }
        
        List<Item> vInventaire = vItems.getItems();
        
        for(int x = 0; x<vInventaire.size(); x++)
        {
            Item vItem = vInventaire.get(x);
            vReponse += " " + vItem.getNom() + ": " + vItem.getPoids() + ", " + vItem.getValeur() + " gold" + ";";
        }
        this.aGui.println(vReponse);
    }

/**
 * Méthode pour afficher si il fait jour ou nuit
 */
    public void time(final Command ptime)
    {
        if(ptime.hasSecondWord()==true)
        {this.aGui.println("time what ?");return;}
        if(aJour==true)
        {this.aGui.println("It day");return;}
        if(aJour==false)
        {this.aGui.println("It night");return;}
    }

/**
 * Méthode pour utilisé un objet
 */
    public void use(final Command puse)
    {
        Room vBeamerRoom = null;
        if(puse.hasSecondWord()==false)
        {this.aGui.println("Use what ?");return;}
        else
        {
            String vObjet = puse.getSecondWord();
            if(this.aPlayer.getInventaire().listSize()==0)
            {this.aGui.println("You have no item in your's inventory !");return;}
            
            for(int x = 0; x<this.aPlayer.getInventaire().listSize(); x++)
            {
                String vItem = this.aPlayer.getInventaire().getItem(x).getNom();
                if(vItem.equals(vObjet))
                {
                    if(vObjet.equals("Beamer"))
                    {
                        if(this.aPlayer.getInventaire().getItem(x).getCharged().equals("uncharged"))
                        {this.aGui.println("Your beamer is not charged.");}
                        if(this.aPlayer.getInventaire().getItem(x).getCharged().equals("charged"))
                        {
                            this.aPlayer.getInventaire().getItem(x).setCharged("uncharged");
                            for(int y = 0; x<this.aAllRooms.length; x++)
                            {
                                if(this.aAllRooms[x].getNom().equals("vWell"))
                                {vBeamerRoom = this.aAllRooms[x];break;}
                                
                            }
                            this.aPlayer.setPlayerRoom(vBeamerRoom);
                            this.printLocationInfo();
                        }
                        
                        break;
                    }
                    if(vObjet.equals("sword"))
                    {
                        if(this.aPlayer.getPlayerRoom().getNom().equals("vCamp"))
                        {
                            this.aGui.println("You defeat bandits !");
                            this.aAllRooms[12].setExit("north",this.aAllRooms[13]);
                            this.aAllRooms[12].setNom("vCampSafe");
                        }
                        else
                        {this.aGui.println("You should not use your sword here !");}
                    }
                    break;
                }
            }
        }
    }
    
/**
 * Changer de salle en fonction de la commande passé en paramètre
 */
    public void goRoom(final Command pCom)
    {
        boolean test = false;
        if(pCom.hasSecondWord()==false)
        {this.aGui.println("Go where?");return;}
        
        Room vNextRoom = null;
        String vDirection = null;
        if(pCom.hasSecondWord()==true)
        {
            vDirection = pCom.getSecondWord();
            for(int x = 0; x<aDirection.length; x++)
            {if(vDirection.equals(aDirection[x])){test=true;break;}}
            
            if(test=true)
            {
                vNextRoom=this.aPlayer.getPlayerRoom().getExit(vDirection);
                if(vNextRoom==null)
                {this.aGui.println("there is no door!");return;}
                else
                {
                    this.aLastRooms.push(this.aPlayer.getPlayerRoom());
                    
                    if(this.aPlayer.getPlayerRoom().getNom().equals("vFreezemount1") && vNextRoom.getNom().equals("vFreezemount2") || 
                    this.aPlayer.getPlayerRoom().getNom().equals("vFreezemount2") && vNextRoom.getNom().equals("vEntre")||
                    this.aPlayer.getPlayerRoom().getNom().equals("vMountain") && vNextRoom.getNom().equals("vJardin"))
                    {this.aLastRooms.clear();}
                    
                    this.aPlayer.setPlayerRoom(vNextRoom);
                    this.printLocationInfo();
                    if(this.aPlayer.getPlayerRoom().getImageName()!=null)
                    {this.aGui.showImage(this.aPlayer.getPlayerRoom().getImageName());}
                    this.aTimeLimit += 1;
                    if(vNextRoom.getNom().equals("vCities") && this.aPlayer.getInventaire().listSize()!=0)
                    {
                        for(int z = 0; z<this.aPlayer.getInventaire().listSize(); z++)
                        {
                            if(this.aPlayer.getInventaire().getItem(z).getNom().equals("Beamer"))
                            {this.aPlayer.getInventaire().getItem(z).setCharged("charged");}
                        }
                    }
                }
            }
            else{this.aGui.println("Unknow direction !");return;}
        }
    }

}
