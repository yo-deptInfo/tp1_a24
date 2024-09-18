
## À partir des diagrammes ci-dessous :

Complétez le code

## Écrivez une documentation en format Markdown

-> Je veux qu'ils me parlent de Maven et de comment c'est utilisé, quelles sont les librairies utilisées

## Si vous partez des tests :
- `ConditionTest` -> vous permets d'écrire le toString() de Condition
- `OpenWeatherMapServiceTest` -> Vous permet de vérifier que vous passez bien un appel à OpenWeatherMap
- `MonAppMeteoTest` -> Vous permet de vérifier si vous avez correctement récupéré un objet à partir du json reçu

## Classe à compléter : OpenWeatherMapService

Complétez les endpoints afin que vos appels :
- utilise la ville reçue en paramètre
- utilise votre clé fourni par OpenWeatherService.org
- vous fournisse des températures en celcisu
- vous retourne de l'information en français

## Explication du code :

À partir de la classe `OpenWeatherMapService.java`

Identifiez :
- la classe qui permet établir une connexion HTTP depuis une application Java
- les classes qui permettent de lire la réponse de l'API ligne par ligne

Expliquez les étapes nécessaires à l'envoi de la requête, depuis l'ouverture de la connexion jusqu'à la fermeture.

## Complétez la méthode `deserialiserMeteoActuelle()` 
Complétez la méthode `deserialiserMeteoActuelle()` de la classe `MonAppMeteo` afin de construire un objet de type `MeteoActuelle` à partir de la réponse reçue.





