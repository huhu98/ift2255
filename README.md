IFT 2255 été 2020
#équipe 16
Maxime Lechasseur
Qiao Wang
Han Zhang


Devoir maison 1
Logiciel #GYM — Incrément 1 : Création
Tout au long du trimestre, vous allez développer le logiciel pour un centre sportif en suivant les techniques apprises en classe. Le développement suivra le modèle du processus unifié et sera divisé en trois livrables. Chaque livrable touche à tous les workflows, mais l'emphase est mise sur un workflow en particulier à chaque incrément. Vous êtes responsable de fournir une solution complète du projet à la livraison finale. Notez qu'à chaque incrément, le cadre du projet sera étendu. Il faut donc prévoir des changements dans les besoins.

Ce devoir se concentre sur le workflow des exigences et de l'analyse. Le but est de mettre en pratique la collecte des besoins, la spécification des exigences et la construction de diagrammes de cas d'utilisation et d'activités. De ce fait, les devoirs à venir se baseront sur celui-ci. Bien qu'essentiel dans un vrai projet commercial, vous n'avez pas besoin de produire un modèle d'affaire (business case) ni un cahier des charges.

Description des besoins pour le livrable 1
#GYM est un centre sportif qui offre des services pour différentes activités physiques. Les membres ont droit à un accès illimité à la salle des machines, la piscine et les salles multisport (basket, soccer, tennis). Ils ont également droit à des entrainements et consultations illimitées avec des professionnels, notamment des experts en exercice physique (entraineur personnel, de yoga, de cross-fit) et des experts de la santé physique (nutritionniste, physiothérapeute, massothérapeute).

Pour adhérer à #GYM, le client doit se présenter à la réception du centre. L'agent lui demande ses informations personnelles qu'il entre sur son ordinateur, ce qui les enregistre dans un système central: le Centre de Données #GYM. Ceci crée le nouveau membre et lui assigne un numéro unique.

À chaque visite, le membre doit se présenter à la réception pour que l'agent lui donne accès. L'agent vérifie le numéro de membre sur le logiciel. Si le numéro est valide, le mot Validé apparait sur l'écran. Si le numéro est invalide, la raison est affichée, tel que « Numéro invalide » ou « Membre suspendu ». Lorsque valide, l'agent lui ouvre le tourniquet du centre pour lui permettre l'accès. Pour participer à un cours de sport ou obtenir tout autre service d'un professionnel, le membre doit s'inscrire à la séance. Les inscriptions se font à la réception. L'agent l'aide à consulter l'ensemble des services offerts et les séances disponibles pour le jour même dans le Répertoire des Services. Quand il sélectionne une séance, il faut confirmer son inscription. À ce moment, le logiciel crée un enregistrement sur le disque qui contient les champs suivants.

    Date et heure actuelles
    Date à laquelle le service sera fourni
    Numéro du professionnel
    Numéro du membre
    Code du service
    Commentaires (facultatif).
Pour fournir un service chez #GYM, le professionnel doit se présenter à la réception du centre. Si c'est un nouveau professionnel, l'agent lui crée un compte de façon similaire à un membre. Pour créer une séance de service, l'agent envoie l'information ci-dessous au Centre de Données. Un professionnel de #GYM peut demander à l'agent de consulter les inscriptions à ses séances en envoyant une requête au Centre de Données.

    Date et heure actuelles
    Date de début du service
    Date de fin du service
    Heure de la séance
    Récurrence hebdomadaire de la séance (quels jours elle est offerte à la même heure)
    Capacité maximale
    Numéro du professionnel
    Code du service
    Commentaires (facultatif).
Avant que la séance ne commence, chaque membre doit se présenter à la réception pour confirmer sa présence. L'agent utilise le Répertoire des Services pour rechercher le code de service approprié à sept chiffres correspondant au service à fournir. Il sélectionne la séance qui affiche toute l'information nécessaire. Ensuite, il peut sélectionner Confirmer inscriptions pour entrer le code du membre. La requête est envoyée au Centre de Données qui vérifie si l'inscription est valide. Si c'est le cas, le mot Validé apparait à l'écran. Sinon, le membre se verra refusé l'accès à la séance. À ce moment, le logiciel crée un enregistrement sur le disque qui contient les champs ci-dessous. C'est la confirmation à l'avance que le service a été fourni.

    Date et heure actuelles
    Numéro du professionnel
    Numéro du membre
    Code du service
    Commentaires (facultatif).
Votre organisation a été octroyée le contrat de développer seulement le logiciel du Centre de Données de #GYM. Le contrat stipule que, lors des tests d'acceptation, les interactions avec l'ordinateur de l'agent sont simulées sur une console Java en tapant les touches du clavier et les données à afficher apparaissent à l'écran de la console. Le Répertoire des Services est créé comme un fichier. Il n'y a pas de base de données dans ce projet.

Tâches
Tâche 1 : Glossaire
Après s'être familiarisé avec le domaine métier de #GYM, produisez un glossaire composé d'une description brève des termes clés, tel qu'illustré dans la Figure 11.3 du livre.

Tâche 2 : Diagramme de cas d'utilisation UML
Identifiez les différents cas d'utilisation du système à construire. Vous devez les représenter sous forme d'un diagramme de cas d'utilisation UML en utilisant l'outil Visual Paradigm (VPP). Vous serez également évalué sur l'utilisation appropriée des éléments UML. Un ordre de grandeur d'une dizaine de cas d'utilisations est attendu.

Tâche 3 : Cas d'utilisation
Rédigez la description de chaque cas d'utilisation directement dans le rapport.htm en utilisant le format suivant. Vous pouvez copier le code source HTML de l'exemple ci-dessous.

    Cas d'utilisation : nom du CU en expression verbale.
    But : mise en contexte, description brève, préconditions nécessaires.
    Préconditions : préconditions nécessaires avant d'entammer le scéanrio principal.
    Acteurs : Acteur 1 (principal), Acteur 2 (secondaire).
    Scénario principal : description étape par étape, ordonnée numériquement
    1. Étape 1
      1.1. Étape 1.1
    2. Étape 2
    3. Étape 3
    Scénarios alternatifs : ramifications du déroulement principal, alternatives possible à certaines étapes
    1a.1. remplace étape 1 du scenario principal
    1b.1. autre remplacement de la même étape
    1b.2. suit 1b.1 indépendamment du scenario principal
    Postconditions : État du système lorsque le scénario principal achève avec succès.
La tâche de description des cas d'utilisation doit être distribuée équitablement entre les membres de l'équipe : chaque membre de l'équipe doit être assigné à peu près le même nombre de cas d'utilisation à rédiger.

Tâche 4 : Risques
Identifiez 5 risques potentiels du projet et classez-les par ordre de sévérité (voir la page 32 dans le module 2.1.Exigences des notes de cours)

Tâche 5 : Exigences non-fonctionnelles
Identifiez 5 besoins ou contraintes non-fonctionnelles du système.

Tâche 6 : Analyse
Maintenant que vous avez défini le modèle fonctionnel du projet #GYM, vous devez estimer ce qui est nécessaire pour mettre le système en opération. Dans un paragraphe de 100 mots (+/-10%), estimez les informations suivantes :

Quelles parties seront informatisées et comment ?
Où seront stockées les données ?
Quel matériel sera nécessaire ?
Comment le système #GYM que vous développez interagira avec les autres systèmes ?
Comment les utilisateurs interagiront avec le système ?
Tâche 7 : Diagramme d'activité UML
Produisez le modèle d'analyse dynamique du système #GYM illustrant le flux des différentes activités et actions du système. Vous devez le représenter sous forme d'un diagramme d'activité UML en utilisant l'outil Visual Paradigm (VPP). Vous devez dessiner un diagramme principal qui sert comme point d'entrée, ainsi que cinq autres diagrammes pour les cas d'utilisations suivants : ajouter/mettre à jour/supprimer un membre, ajouter/mettre à jour/supprimer un service, inscription à une séance, confirmer séance et procédure comptable. Ne produisez pas les diagrammes d'activité des autres cas d'utilisations. Vous serez également évalué sur l'utilisation appropriée des éléments UML.

Cette tâche doit être distribuée équitablement entre les membres de l'équipe : chaque membre de l'équipe doit être assigné à peu près le même nombre de diagrammes d'activité à produire.

Collaboration
À la fin du rapport, affichez une capture d'écran des statistiques et du pourcentage de propriété de votre dépôt BitBucket.

Assurez-vous de communiquer régulièrement au sein de votre équipe. Utilisez l'application Slack de votre équipe pour discuter et échanger. De ce fait, vous conservez une trace de vos décisions pour les itérations ultérieures. Pour faciliter la collaboration en équipe, vous devez utiliser le système de contrôle de révision BitBucket. Faites régulièrement des soumissions BitBucket (commit/push) de tous vos fichiers. Vous serez évalués sur la bonne utilisation de votre dépôt.

L'auxiliaire du cours est le représentant du client. Si vous avez besoin de clarifications et de précisions, communiquez avec lui directement par Slack ou en personne.

Barème
Glossaire [5%]
Image et fichier VPP du diagramme de cas utilisation [20%]
Description des cas d'utilisation [30%]
Risques [5%]
Besoins non-fonctionnels [5%]
Analyse [5%]
Image et fichier VPP du diagramme d'activité [30%]
Téléversez toutes les images, fichiers source, fichiers de données, projet VPP et y faire référence dans le rapport. Le fichier ZIP doit comprendre deux dossiers intitulés : Exigence et Analyse.

Ressources supplémentaires
Vous devez utiliser Visual Paradigm pour tous les diagrammes UML. Vous pouvez le télécharger, l'installer et l'activer à partir du lien disponible sur StudiUM.

Pour BitBucket vous pouvez utiliser le client SourceTree.

Pour communiquer en équipe vous pouvez utiliser Slack.

Informations pratiques
Le devoir vaut 20% de la note finale.

Voir la date de remise sur StudiUM à 23h55. Tout retard engendrera une pénalité de 5% par jour pour un maximum de deux jours.

Le devoir est à faire en équipe de trois (ou quatre au besoin). Aucun devoir effectué seul ne sera accepté. Consultez la Démo 1 sur StudiUM pour suivre la procédure de formation d'une équipe, si ce n'est pas déjà fait.

La remise du devoir est un fichier ZIP qui comprend un fichier HTML simple (rapport.htm) ainsi que tous les fichiers additionnels nécessaires (.jpg, .java, .txt, .vpp, tous les autres fichiers que vous voulez remettre). Le rapport doit avoir un lien explicite à tous les fichiers et afficher toutes les images directement sur la page. Vous devez inscrire dans l'entête du rapport : le nom de tous les membres de votre équipe, les quatre derniers chiffres de vos matricules, vos courriels et le temps mis par chaque membre sur le devoir (pour des raisons statistiques uniquement). Votre solution doit être incluse en entier dans le body du rapport. Inscrivez toutes vos hypothèses. Puis décrivez votre solution pour chaque tâche sous forme de rapport.

De plus, le rapport doit inclure une section Distribution des tâches. Cette section doit énumérer toutes les tâches accomplies et le pourcentage de contribution de chaque membre par tâche. Si les pourcentages ne sont pas plus ou moins égaux, la note peut différer d'un membre à l'autre. Vous pouvez trouver un exemple du rapport ici.

Une seule personne par équipe remet le devoir complet sur StudiUM. Les autres membres doivent uniquement soumettre le fichier rapport avec les noms et la distribution des tâches (ce n'est pas grave si les images n'apparaissent pas ou si les liens ne fonctionnent pas). Indiquez la personne qui soumet le devoir complet.

Omettre le rapport engendrera une pénalité de 5%.