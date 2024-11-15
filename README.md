# P6-Full-Stack-Réseau-Dev

Ce projet consiste à créer une base de données et à connecter celle-ci à une API pour un réseau de partage d'articles et de thématiques. Les utilisateurs peuvent s'abonner à des thèmes, lire des articles et laisser des commentaires.

## Prérequis

1. Assurez-vous d'avoir un serveur local (par exemple, MySQL ou PostgreSQL) configuré et en cours d'exécution pour héberger la base de données.

## Étapes de configuration

### 1. Création de la base de données

Utilisez le modèle suivant pour structurer votre base de données :

#### Tables

- **`user`** : Stocke les informations des utilisateurs.
  - `id` (BIGINT, PK) : Identifiant unique de l'utilisateur.
  - `email` (VARCHAR, UNIQUE) : Adresse e-mail de l'utilisateur.
  - `firstname` (VARCHAR) : Prénom de l'utilisateur.
  - `lastname` (VARCHAR) : Nom de famille de l'utilisateur.
  - `password` (VARCHAR) : Mot de passe de l'utilisateur.
  - `created_at` (DATETIME) : Date de création du compte.
  - `updated_at` (DATETIME) : Dernière mise à jour du compte.
  - `role` (VARCHAR) : Rôle de l'utilisateur (par exemple, `user`, `admin`).
  - `token` (VARCHAR) : Jeton pour l'authentification de session.

- **`subject`** : Représente les thématiques auxquelles les utilisateurs peuvent s'abonner.
  - `id` (BIGINT, PK) : Identifiant unique du sujet.
  - `name` (VARCHAR) : Nom du sujet.
  - `description` (VARCHAR) : Description du sujet.
  - `created_by` (BIGINT, FK) : Identifiant de l'utilisateur ayant créé le sujet.
  - `creation_date` (DATETIME) : Date de création du sujet.

- **`article`** : Stocke les articles publiés sur le réseau.
  - `id` (BIGINT, PK) : Identifiant unique de l'article.
  - `title` (VARCHAR) : Titre de l'article.
  - `content` (TEXT) : Contenu de l'article.
  - `published_date` (DATETIME) : Date de publication de l'article.
  - `subject_id` (BIGINT, FK) : Identifiant du sujet associé à l'article.
  - `author_id` (BIGINT, FK) : Identifiant de l'auteur de l'article.

- **`subscription`** : Gère les abonnements des utilisateurs aux articles et sujets.
  - `id` (BIGINT, PK) : Identifiant unique de l'abonnement.
  - `user_id` (BIGINT, FK) : Identifiant de l'utilisateur abonné.
  - `subject_id` (BIGINT, FK, nullable) : Identifiant du sujet auquel l'utilisateur est abonné.
  - `article_id` (BIGINT, FK, nullable) : Identifiant de l'article auquel l'utilisateur est abonné.
  - **Note** : Au moins `subject_id` ou `article_id` doit être renseigné pour éviter les valeurs nulles.

### 2. Configuration de l'API

1. Dans le fichier `resources/application.properties`, configurez la connexion à la base de données en ajoutant vos informations de connexion :

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/votre_base_de_donnees
   spring.datasource.username=VotreNomUtilisateur
   spring.datasource.password=VotreMotDePasse
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true

   ### 3. Démarrage du backend

Dans votre IDE, appuyez sur le bouton **RUN** pour démarrer le backend de l'API.

### 4. Démarrage du frontend

1. Ouvrez un terminal dans le répertoire du frontend.
2. Exécutez la commande suivante pour lancer le serveur Angular :

   ```bash
   ng serve

