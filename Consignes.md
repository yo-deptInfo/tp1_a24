# Travail Pratique

## Partie 1 : Programmation

À partir du [diagramme de classes](uml/diagramme_de_classes.png), et du [diagramme de séquences](uml/diagramme_de_sequences.png), créez les classes suivantes :
- `Localisation`,
- `Meteo`,
- `MeteoActuelle`,
- `PrevisionsHoraire`.

Complétez également la classe `OpenWeatherMapService` pour que les points suivants soient respectés :

1. *Attribut* :
    - `API_KEY` : Doit être initialisé votre clé API

2. *Endpoints (chemins)* :
    - Assurez-vous que les appels utilisent la ville reçue en paramètre.
    - Utilisez la clé API fournie par OpenWeatherMap. Vous pouvez (encore) vous inscrire sur leur site [openweathermap.org](https://openweathermap.org/) pour obtenir une clé API gratuite.
    - Configurez les appels pour récupérer les températures en Celsius.
    - Configurez les appels pour avoir l'information en français.

3. *Méthodes* :
    - Implémentez les méthodes de l'interface `ApiService` :
        - `obtenirDonneesMeteoActuelle(String ville)` : String=
        - `obtenirDonneesPrevisionsHoraires(String ville)` : String=
    - Dans ces méthodes, il vous faut :
      - construire vos endpoints
      - déclancher l'envoi de requête

## Partie 2 : Documentation

Fournissez de la documentation logicielle en format Markdown, dans le fichier nommé ~README.md~, pour expliquer votre travail :

Das une section **Introduction**, vous devez présenter l'application :
- Donnez une vue d'ensemble de l'application.
- Décrivez ce qui se passe lors de l'exécution de l'application.

Das une section **Architecture**, vous devez présenter `Maven` :
- Expliquez le rôle de Maven et tout ce qu'il apporte à l'application.
- Mentionnez les principales librairies utilisées dans votre projet.
- En particulier, mettez en avant la dépendance à `org.json` :
    - Expliquez pourquoi elle est utilisée.
- Donnez des exemples de son utilisation dans le code du projet (très important).

Ajoutez également une section **Composants Principaux**. 

## Partie 3 : Investigation

### À partir de la classe `OpenWeatherMapService.java` :

1. Dans la partie **Composants Principaux**, ajoutez une sous-partie **Appel à une api**. Identifiez :
   - La classe qui permet d’établir une connexion HTTP depuis une application Java.
   - Les classes qui permettent de lire la réponse de l'API ligne par ligne.
    
2. Toujours dans la partie **Appel à une api**, copiez le code ci-dessous. 

3. À l'aide de commentaires : 
**Expliquez toutes les étapes nécessaires à l'envoi de la requête**, depuis l'ouverture de la connexion jusqu'à la fermeture. 

```java
private String envoyerRequete(String endpoint) {
    StringBuilder reponse = new StringBuilder();
    try {
        URL urlFinale = new URL(BASE_URL + endpoint);
        HttpURLConnection connexionHttp = (HttpURLConnection) urlFinale.openConnection();
        connexionHttp.setRequestMethod("GET");

        BufferedReader entrant = new BufferedReader(new InputStreamReader(connexionHttp.getInputStream()));
        String ligneRecue;

        while ((ligneRecue = entrant.readLine()) != null) {
            reponse.append(ligneRecue);
        }

        entrant.close();
        connexionHttp.disconnect();

    } catch (Exception e) {
        e.printStackTrace();
    }
    return reponse.toString();
}
```

### Un nouveau concept, la déserialization :

Dans la partie **Composants Principaux**, ajoutez une sous-partie "La déserialization".

#### La théorie

Après avoir fait vos recherches : 

1. Présentez ce qu'est la désérialisation (3 ou 4 phrases) :
   - Expliquez comment cela est mis en place dans le projet, en vous appuyant sur le code du projet pour illustrer vos propos (toujours très important).

2. Complétez les méthodes suivantes :
   - `deserialiserPrevisionsHoraire()` :
       - Construisez une instance de `Localisation` et retournez une instance de `PrevisionHoraire`.

   - `deserialiserMeteoActuelle()` :
       - Construisez une instance de `Condition`, une instance de `Localisation`, et retournez une instance de `MeteoActuelle`.

Notez qu'il y a une différence de structure dans les réponses selon que vous demandez la météo actuelle ou les prévisions horaires. Assurez-vous de bien gérer ces différences dans vos implémentations.

## Finalement
Une fois votre travail terminé, assurez-vous de pousser votre code et votre documentation sur le dépôt GitHub.

Dernière question.
Inscrivez ici le nombre d'heure passées sur ce Tp : 

