# Rapport : API REST de gestion des produits

## Présentation

Ce projet est une petite API réalisée avec Spring Boot. Elle permet de stocker et de consulter des produits. Le travail suit les étapes montrées dans la vidéo [First Demo Spring Boot Spring Data JPA Hibernate REst API](https://www.youtube.com/watch?v=UXs39oVoaSs).

Les produits ont un nom, un prix et une quantité. 
Le projet utilise Spring Data JPA pour communiquer avec une base de données H2 en mémoire.

## Outils utilisés

- Java 21
- Spring Boot et Spring Data JPA
- H2, une base de données en mémoire
- Swagger, pour tester les routes de l’API

## Étapes du projet

### 1. Créer l’application et ajouter des produits

La classe principale démarre l’application. Au démarrage, elle ajoute trois produits de démonstration : un ordinateur, une imprimante et un téléphone. Le terminal affiche ensuite les produits enregistrés.

![Classe principale et ajout des produits](<captures/Capture d'écran 2026-10-23 231358.png>)

![Démarrage de l’application et produits affichés dans le terminal](<captures/Capture d'écran 2026-10-23 232601.png>)

### 2. Vérifier la base de données H2

La console H2 permet de se connecter à la base et de vérifier les données. Dans ce projet, l’URL de la base est `jdbc:h2:mem:products-db` et l’utilisateur est `sa`. Une fois connecté, on peut afficher la table `PRODUCTS` avec la requête `SELECT * FROM PRODUCTS`.

![Écran de connexion H2 avec l’URL de la base du projet](<captures/Capture d'écran 2026-10-23 232637.png>)

![Écran de connexion H2 avec les paramètres proposés par défaut](<captures/Capture d'écran 2026-10-24 001124.png>)

![Table PRODUCTS et produits enregistrés](<captures/Capture d'écran 2026-10-24 001247.png>)

### 3. Créer les premières routes de l’API

Le contrôleur reçoit les demandes HTTP et utilise le dépôt `ProductRepository` pour accéder aux produits. Le dépôt hérite de `JpaRepository`, ce qui fournit déjà les opérations principales comme la recherche et l’enregistrement.

![Démarrage de l’application après la configuration de la base](<captures/Capture d'écran 2026-10-24 001324.png>)

![Premières routes de consultation dans le contrôleur](<captures/Capture d'écran 2026-10-24 002118.png>)

### 4. Tester les routes dans le navigateur

La route de consultation renvoie la liste des produits au format JSON. Une autre route permet de rechercher les produits dont le nom contient un mot-clé.

![Réponse de la route qui affiche tous les produits](<captures/Capture d'écran 2026-10-24 004237.png>)

![Recherche des produits avec le mot-clé m](<captures/Capture d'écran 2026-10-24 004449.png>)

### 5. Tester l’API avec Swagger

Swagger présente les routes disponibles et permet de les essayer depuis une page web. On peut notamment rechercher un produit par son identifiant.

![Première présentation des routes dans Swagger](<captures/Capture d'écran 2026-10-24 005303.png>)

![Route de recherche d’un produit par identifiant testée dans le navigateur](<captures/Capture d'écran 2026-10-24 014252.png>)

![Réponse Swagger pour le produit dont l’identifiant est 1](<captures/Capture d'écran 2026-10-24 014409.png>)

![Réponse Swagger avec la liste des produits](<captures/Capture d'écran 2026-10-24 014433.png>)

![Recherche Swagger avec le mot-clé m](<captures/Capture d'écran 2026-10-24 014502.png>)

### 6. Ajouter et enregistrer un produit

La route `POST` permet d’envoyer un nouveau produit au format JSON. Le serveur l’enregistre dans la base et renvoie le produit créé, avec son identifiant.

![Ajout de la méthode d’enregistrement dans le contrôleur](<captures/Capture d'écran 2026-10-24 014817.png>)

![Routes disponibles dans la version finale de Swagger](<captures/Capture d'écran 2026-10-24 015211.png>)

![Ajout du produit HP avec Swagger et réponse du serveur](<captures/Capture d'écran 2026-10-24 015852.png>)

## Routes disponibles

Les routes sont précédées de `/api` dans le projet :

| Méthode | Adresse | Description |
| --- | --- | --- |
| `GET` | `/api/products` | Afficher tous les produits |
| `GET` | `/api/products/{id}` | Afficher un produit par son identifiant |
| `GET` | `/api/find/products?kw=m` | Rechercher les produits par nom |
| `POST` | `/api/products` | Ajouter un produit |
| `DELETE` | `/api/products/{id}` | Supprimer un produit |

## Lancer le projet

Il faut avoir Java 21 installé. Dans un terminal ouvert à la racine du projet, exécuter :

```powershell
.\mvnw.cmd spring-boot:run
```

L’application démarre sur le port `8084`. La documentation Swagger est disponible à l’adresse [http://localhost:8084/swagger-ui/index.html](http://localhost:8084/swagger-ui/index.html). La console H2 est disponible à [http://localhost:8084/h2-console](http://localhost:8084/h2-console).

La base H2 est en mémoir ainsi les données sont recréées au démarrage de l’application et ne sont pas conservées après son arrêt.

## Conclusion

A travers ce projet, j’ai découvert comment créer une API REST avec Spring Boot, enregistrer des données avec Spring Data JPA et tester les routes avec un navigateur et Swagger.