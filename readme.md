Effectué : 

Classe Bag :
- Modifié l'ordre des variables par défaut pour la lisibilité
- Changé le nom de la variable money -> gold


A FAIRE D'URGENCE :
- Ajouter une classe BagFullException
- Ajouter une classe NotEnoughGoldException 
- Ajouter une class ItemNotFoundException 
- Lancer un BagFullException dans la fonction Bag.addItem() -> quand le sac est plein
- Lancer un NotEnougthGoldException dans le fonction Bag.removeGold() -> quand il n'y a pas asser de gold
- Lancer un ItemNotFoundException dans toutes les fonctions qui implémentent ItemContainer.getItem() -> quand un item n'existe pas.
    
