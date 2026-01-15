# Meland - Plateforme de Micro-finance 🚀

**Meland** est une solution web moderne dédiée à la micro-finance et à la gestion de prêts en Côte d'Ivoire. Elle permet aux particuliers et aux entreprises de consulter des offres de financement et aux structures financières de gérer leurs produits via un espace dédié.

![Meland Preview](https://github.com/mmeland07-oss/meland-finance/raw/main/src/main/resources/static/images/hero-preview.png) *(Note: Preview image placeholder)*

## 🌟 Fonctionnalités

### 👥 Espace Visiteur
- **Recherche multicritère** : Filtrage par type de prêt, structure financière ou commune.
- **Catégories de prêts** : Micro-crédits, PME, Agricole, Scolaire, Personnel.
- **Détails complets** : Taux d'intérêt, montants (FCFA), durées, conditions et documents requis.
- **Contact direct** : Boutons de demande de prêt et partage d'offres.

### 🏢 Espace Structure Financière
- **Dashboard dédié** : Statistiques de vues et gestion du catalogue d'offres.
- **Gestion des offres** : Créer, modifier ou supprimer des offres de prêts.
- **Module Premium** : Visibilité accrue pour les partenaires certifiés.

### 🛡️ Espace Administrateur
- **Gestion globale** : Suivi des structures inscrites et des offres publiées.
- **Statistiques** : Analyse de l'activité globale de la plateforme.

## 🛠️ Stack Technique

- **Backend** : [Spring Boot 3](https://spring.io/projects/spring-boot) (Java 17)
- **Frontend** : [Thymeleaf](https://www.thymeleaf.org/) & [Tailwind CSS](https://tailwindcss.com/)
- **Données** : Persistance JSON (Sans base de données SQL/NoSQL comme requis).
- **Design** : Responsive, moderne et épuré.

## 🚀 Installation Locale

1. **Cloner le projet** :
   ```bash
   git clone https://github.com/mmeland07-oss/meland-finance.git
   cd meland-finance
   ```

2. **Lancer l'application** :
   Assurez-vous d'avoir Maven installé.
   ```bash
   mvn spring-boot:run
   ```

3. **Accès** :
   Ouvrez votre navigateur sur [http://localhost:8080](http://localhost:8080)

## 📁 Structure du Projet

- `src/main/java` : Logique métier (Modèles, Services, Contrôleurs).
- `src/main/resources/templates` : Pages HTML (Thymeleaf).
- `src/main/resources/data` : Fichiers JSON pour le stockage des données.
- `src/main/resources/static` : Fichiers CSS et images.

## 📄 Licence
Projet développé dans le cadre d'une solution de gestion financière pour Meland.

---
*Site ivoirien — Montants exprimés en FCFA*
