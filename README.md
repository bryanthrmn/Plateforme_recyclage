
# Plateforme de recyclage de déchets électroniques
Plateforme de recyclage de déchets électronqiues
Projet Java - Semestre 4 - EPF 2A

## Objectif

L'objectif du projet est d'écrire un programme permettant de mettre en relation des consommateurs et des entreprises avec des centres de recyclage, pour traiter leurs déchets électroniques.

---

## Description du programme

Le programme est utilisé d’une part par les consommateurs et les entreprises et d’autre part par les centres de recyclage.

### Création de compte

- Lorsqu’un **client** (consommateur ou entreprise) se connecte pour la première fois sur la plateforme, il doit commencer par **créer un compte**.  
- Il doit fournir :
  - Une **adresse électronique**  
  - Un **mot de passe**  
  - Une **fiche d’informations détaillées** (nom, numéro de téléphone, adresse postale, etc.).  

- Lorsqu’un **centre de recyclage** s’inscrit sur la plateforme, il doit fournir les mêmes informations et indiquer :
  - Les **types de déchets acceptés**  
  - Les **horaires d’ouverture**  
  - La **capacité de stockage**  

---

### Demande de collecte de déchets

- Une **entreprise** peut faire une demande de collecte en remplissant un **formulaire** :  
  - Type de déchets (équipements informatiques, télécommunication, équipements audiovisuels, etc.).  
  - Quantité à collecter.  
- Une fois qu’un **centre de recyclage** accepte la demande, il fixe une **date de collecte**.  
- L’**entreprise** peut consulter la **liste des collectes à venir** (centre de recyclage et date prévue).  

---

### Recherche de centres de recyclage

- Un **consommateur** peut utiliser la plateforme pour **trouver un centre de recyclage** où déposer ses déchets.

---

### Historique des déchets recyclés

- Les clients (entreprises ou consommateurs) peuvent consulter leur **historique de recyclage** :  
  - Trier par **date de collecte** ou **date de dépôt**.  
  - Trier par **type de déchets** ou **centre de recyclage**.  
  - Accéder aux **fiches d’informations** des centres de recyclage concernés.  

---

### Gestion des demandes par les centres de recyclage

- Un **centre de recyclage** peut consulter la **liste des demandes de collecte** correspondant aux types de déchets qu’il accepte.  
- Il peut choisir **d’accepter une demande** et fixer une **date de collecte**.  
- Il peut également consulter son **historique de collectes effectuées** et trier les données :  
  - Par **date de collecte** ou **date de dépôt**.  
  - Par **type de déchets** ou **client**.  
  - Accéder aux **fiches d’informations des clients**.  

- Les centres de recyclage peuvent à tout moment **modifier leurs informations**.  

---

### Mis à jour
Après chaque collecte effectuée :  
- Les **listes des demandes de collecte** et les **historiques** sont **automatiquement mis à jour**.  

---
EPF - Engineering School
Gabriel BREMME & Bryan THIRIMANNA
