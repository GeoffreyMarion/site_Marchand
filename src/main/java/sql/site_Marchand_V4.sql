-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jul 15, 2022 at 10:54 AM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `site_Marchand`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrateur`
--

CREATE TABLE `administrateur` (
  `id_administrateur` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `email` varchar(70) NOT NULL,
  `mot_de_passe` varchar(100) NOT NULL,
  `privileges` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrateur`
--

INSERT INTO `administrateur` (`id_administrateur`, `nom`, `email`, `mot_de_passe`, `privileges`) VALUES
(1, 'admin', 'admin@test.fr', '123456', ''),
(2, 'admin', 'admin@test.fr', '123456', '');

-- --------------------------------------------------------

--
-- Table structure for table `adresse_livraison`
--

CREATE TABLE `adresse_livraison` (
  `id_adresse` int(11) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `code_postal` int(11) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `pays` varchar(30) NOT NULL,
  `fk_id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adresse_livraison`
--

INSERT INTO `adresse_livraison` (`id_adresse`, `adresse`, `code_postal`, `ville`, `pays`, `fk_id_utilisateur`) VALUES
(1, '1 rue du test', 75001, 'Paris', 'France', 1),
(2, '2bis rue du test', 13001, 'Marseille', 'France', 1),
(3, '1 rue du test', 75001, 'Paris', 'France', 2),
(4, '2bis rue du test', 13001, 'Marseille', 'France', 2),
(5, '12 rue de l\'eglise', 75004, 'Paris', 'Fran', 3),
(6, '234 avenue Foch', 69003, 'Lyon', 'France', 3);

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `titre` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `titre`) VALUES
(1, 'informatique'),
(4, 'livre'),
(7, 'musique');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE `commande` (
  `id_commande` int(11) NOT NULL,
  `fk_id_utilisateur` int(11) NOT NULL,
  `date` date NOT NULL,
  `total` float NOT NULL,
  `fk_id_adresse` int(11) NOT NULL,
  `etat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`id_commande`, `fk_id_utilisateur`, `date`, `total`, `fk_id_adresse`, `etat`) VALUES
(1, 2, '2022-07-15', 120, 2, 1),
(3, 2, '2022-07-19', 34, 3, 1),
(4, 3, '2022-07-16', 100, 5, 1),
(5, 3, '2022-07-20', 12, 6, 1),
(6, 3, '2022-06-10', 79, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `commentaire`
--

CREATE TABLE `commentaire` (
  `id_commentaire` int(11) NOT NULL,
  `commentaire` varchar(255) NOT NULL,
  `note` int(11) NOT NULL,
  `fk_id_produit` int(11) NOT NULL,
  `fk_id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commentaire`
--

INSERT INTO `commentaire` (`id_commentaire`, `commentaire`, `note`, `fk_id_produit`, `fk_id_utilisateur`) VALUES
(1, 'Produit tres tres bien', 4, 15, 2),
(2, 'Produit moyen', 2, 40, 3),
(3, 'Bien', 4, 40, 3),
(4, 'Pas bien ntgb infg4in4igf4f4gbf tinibibgibt tgtgntgnt tgtgjtgbtjbgj tgtbgtbgtbg tkngtbtbgtbg gjtjgbjtgbjtbg tjgtjbgjtbgjbgjtbtj tintigtingintin', 1, 40, 2),
(5, 'SUPER SUPER', 5, 37, 3),
(6, 'GREAT BOOK', 5, 2, 3),
(7, 'BOF', 1, 7, 2),
(8, 'SUPER ', 4, 42, 2);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id_contact` int(11) NOT NULL,
  `fk_id_utilisateur` int(11) NOT NULL,
  `sujet` varchar(30) NOT NULL,
  `message` text NOT NULL,
  `etat_contact` tinyint(1) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id_contact`, `fk_id_utilisateur`, `sujet`, `message`, `etat_contact`, `email`) VALUES
(1, 2, 'Vacances', 'Bien bien ces vacances', 1, 'moussa@gmail.com'),
(2, 1, 'Pas compris le site', 'oo 44ngn4ogg t4gtngot4n', 1, 'guest@test.fr');

-- --------------------------------------------------------

--
-- Table structure for table `coordonnees`
--

CREATE TABLE `coordonnees` (
  `id_coordonnees` int(11) NOT NULL,
  `nom` varchar(70) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `logo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coordonnees`
--

INSERT INTO `coordonnees` (`id_coordonnees`, `nom`, `adresse`, `telephone`, `email`, `logo`) VALUES
(1, 'site_Marchand', 'rue Politzer 75012 Paris', '0142424242', 'contact@site_marchand.fr', '');

-- --------------------------------------------------------

--
-- Table structure for table `details_commande`
--

CREATE TABLE `details_commande` (
  `id_details_commande` int(11) NOT NULL,
  `fk_id_commande` int(11) NOT NULL,
  `fk_id_produit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `details_commande`
--

INSERT INTO `details_commande` (`id_details_commande`, `fk_id_commande`, `fk_id_produit`, `quantite`, `prix`) VALUES
(1, 1, 15, 2, 15),
(2, 3, 2, 1, 30),
(3, 4, 27, 1, 15),
(4, 4, 16, 3, 20),
(5, 5, 9, 1, 12),
(6, 5, 9, 1, 9),
(7, 6, 22, 1, 30),
(8, 6, 23, 1, 35),
(9, 6, 23, 1, 35);

-- --------------------------------------------------------

--
-- Table structure for table `entree_en_stock`
--

CREATE TABLE `entree_en_stock` (
  `id_entree_en_stock` int(11) NOT NULL,
  `fk_id_fournisseur` int(11) NOT NULL,
  `fk_id_produit` int(11) NOT NULL,
  `date_entree_en_stock` date NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `entree_en_stock`
--

INSERT INTO `entree_en_stock` (`id_entree_en_stock`, `fk_id_fournisseur`, `fk_id_produit`, `date_entree_en_stock`, `quantite`) VALUES
(1, 1, 2, '2022-06-01', 20),
(2, 1, 7, '2022-06-01', 500),
(5, 1, 9, '2022-06-01', 340),
(6, 1, 11, '2022-06-01', 100),
(7, 1, 13, '2022-06-01', 200),
(8, 1, 15, '2022-06-01', 250),
(9, 1, 16, '2022-06-01', 70),
(10, 1, 21, '2022-06-01', 220),
(11, 1, 22, '2022-06-01', 40),
(12, 1, 23, '2022-06-01', 15),
(13, 1, 24, '2022-06-01', 67),
(14, 2, 27, '2022-05-12', 300),
(15, 2, 28, '2021-05-12', 70),
(16, 2, 31, '2021-05-12', 100),
(17, 2, 32, '2021-05-12', 25),
(18, 2, 35, '2022-05-12', 20),
(19, 2, 36, '2022-05-26', 10),
(20, 2, 37, '2022-05-27', 8),
(21, 2, 38, '2021-05-12', 4),
(22, 2, 39, '2022-06-24', 14),
(23, 2, 40, '2022-05-26', 15),
(24, 2, 41, '2022-05-27', 35),
(25, 2, 42, '2022-06-01', 12);

-- --------------------------------------------------------

--
-- Table structure for table `favori`
--

CREATE TABLE `favori` (
  `id_favori` int(11) NOT NULL,
  `fk_id_produit` int(11) NOT NULL,
  `fk_id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `favori`
--

INSERT INTO `favori` (`id_favori`, `fk_id_produit`, `fk_id_utilisateur`) VALUES
(1, 2, 2),
(2, 9, 2),
(3, 23, 3),
(4, 28, 3),
(5, 38, 2),
(6, 36, 2),
(7, 41, 3),
(8, 27, 3);

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id_fournisseur` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fournisseur`
--

INSERT INTO `fournisseur` (`id_fournisseur`, `nom`) VALUES
(1, 'fournisseur_1'),
(2, 'fournisseur_2');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id_image` int(11) NOT NULL,
  `fk_id_produit` int(11) NOT NULL,
  `url` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `titre_produit` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `prix` float NOT NULL,
  `image` varchar(100) NOT NULL,
  `fk_id_sous_categorie` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `stock_minimum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id_produit`, `titre_produit`, `description`, `prix`, `image`, `fk_id_sous_categorie`, `stock`, `stock_minimum`) VALUES
(1, 'testTitre', 'NEW DESCRIPTION', 999, '', 12, 4, 2),
(2, 'roman2', 'Je suis la description Je suis la description Je suis la description Je suis la description', 10, '', 12, 10, 5),
(7, 'roman3', 'Je suis la description Je suis la description Je suis la description Je suis la description', 15, '', 12, 10, 5),
(9, 'manga1', 'Je suis la description Je suis la description Je suis la description Je suis la description', 7, '', 13, 6, 4),
(11, 'manga2', 'Je suis la description Je suis la description Je suis la description Je suis la description', 10, '', 13, 10, 5),
(13, 'manga3', 'Je suis la description Je suis la description Je suis la description Je suis la description', 10, '', 13, 10, 5),
(15, 'livreEnfant1', 'Je suis la description Je suis la description Je suis la description Je suis la description', 10, '', 16, 20, 10),
(16, 'livreEnfant2', 'Je suis la description Je suis la description Je suis la description Je suis la description', 7, '', 16, 7, 5),
(21, 'livreEnfant3', 'Je suis la description Je suis la description Je suis la description Je suis la description', 25, '', 16, 8, 4),
(22, 'sciencesHumaines1', 'Je suis la description Je suis la description Je suis la description Je suis la description', 25, '', 17, 30, 5),
(23, 'sciencesHumaines2', 'Je suis la description Je suis la description Je suis la description Je suis la description', 40, '', 17, 5, 5),
(24, 'sciencesHumaines3', 'Je suis la description Je suis la description Je suis la description Je suis la description', 20, '', 17, 2, 2),
(27, 'coffretIntegrale1', 'Je suis la description Je suis la description Je suis la description Je suis la description', 19.99, '', 4, 50, 20),
(28, 'coffretIntegrale2', 'Je suis la description Je suis la description Je suis la description Je suis la description', 17.99, '', 4, 200, 50),
(31, 'coffretIntegrale3', 'Je suis la description Je suis la description Je suis la description Je suis la description', 8.99, '', 4, 30, 10),
(32, 'vinyle1', 'Je suis la description Je suis la description Je suis la description Je suis la description', 12, '', 5, 49, 10),
(35, 'vinyle2', 'Je suis la description Je suis la description Je suis la description Je suis la description', 25, '', 5, 100, 44),
(36, 'vinyle3', 'Je suis la description Je suis la description Je suis la description Je suis la description', 33, '', 5, 44, 33),
(37, 'instrumentMusique1', 'Je suis la description Je suis la description Je suis la description Je suis la description', 200, '', 8, 24, 20),
(38, 'instrumentMusique2', 'Je suis la description Je suis la description Je suis la description Je suis la description', 3999, '', 8, 77, 50),
(39, 'instrumentMusique3', 'Je suis la description Je suis la description Je suis la description Je suis la description', 79, '', 8, 35, 10),
(40, 'carteGraphique1', 'Je suis la description Je suis la description Je suis la description Je suis la description', 899.99, '', 1, 33, 15),
(41, 'carteGraphique2', 'Je suis la description Je suis la description Je suis la description Je suis la description', 1299, '', 1, 79, 20),
(42, 'carteGraphique3', 'Je suis la description Je suis la description Je suis la description Je suis la description', 799.99, '', 1, 10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `recherche`
--

CREATE TABLE `recherche` (
  `id_recherche` int(11) NOT NULL,
  `fk_id_utilisateur` int(11) NOT NULL,
  `mot_cle` varchar(30) NOT NULL,
  `date_recherche` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recherche`
--

INSERT INTO `recherche` (`id_recherche`, `fk_id_utilisateur`, `mot_cle`, `date_recherche`) VALUES
(1, 2, 'couches', '2022-07-14'),
(2, 3, 'carte', '2022-07-16'),
(3, 3, 'graf', '2022-07-14'),
(4, 1, 'roma', '2022-07-16');

-- --------------------------------------------------------

--
-- Table structure for table `slide`
--

CREATE TABLE `slide` (
  `id_slide` int(11) NOT NULL,
  `titre_slide` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `url` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sous_categorie`
--

CREATE TABLE `sous_categorie` (
  `id_sous_categorie` int(11) NOT NULL,
  `titre` varchar(30) NOT NULL,
  `fk_id_categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sous_categorie`
--

INSERT INTO `sous_categorie` (`id_sous_categorie`, `titre`, `fk_id_categorie`) VALUES
(1, 'carte_graphique', 1),
(3, 'disque_dur', 1),
(4, 'coffret_integrale', 7),
(5, 'vinyle', 7),
(8, 'instrument_musique', 7),
(10, 'ssd', 1),
(12, 'roman', 4),
(13, 'manga', 4),
(16, 'livre_enfant', 4),
(17, 'sciences_humaines', 4);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id_utilisateur` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_inscription` date NOT NULL,
  `email` varchar(70) NOT NULL,
  `mot_de_passe` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `nom`, `prenom`, `date_inscription`, `email`, `mot_de_passe`) VALUES
(1, 'GUEST', 'Welcome', '2022-07-12', 'welcomeguest@test.fr', '123456'),
(2, 'Camara', 'Moussa', '2022-07-12', 'moussa.camara@gmail.com', '123456'),
(3, 'test', 'test', '2022-07-13', 'test@test.fr', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `visite`
--

CREATE TABLE `visite` (
  `id_visite` int(11) NOT NULL,
  `fk_id_produit` int(11) NOT NULL,
  `fk_id_utilisateur` int(11) NOT NULL,
  `date_visite` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visite`
--

INSERT INTO `visite` (`id_visite`, `fk_id_produit`, `fk_id_utilisateur`, `date_visite`) VALUES
(1, 13, 2, '2022-07-04'),
(2, 28, 2, '2022-06-17'),
(3, 40, 3, '2022-07-04'),
(4, 41, 3, '2022-07-04'),
(5, 9, 1, '2022-07-04'),
(6, 9, 1, '2022-07-11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id_administrateur`);

--
-- Indexes for table `adresse_livraison`
--
ALTER TABLE `adresse_livraison`
  ADD PRIMARY KEY (`id_adresse`);

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Indexes for table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `fk_commande_utilisateur` (`fk_id_utilisateur`),
  ADD KEY `fk_commande_adresse` (`fk_id_adresse`);

--
-- Indexes for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id_commentaire`),
  ADD KEY `fk_commentaire_produit` (`fk_id_produit`),
  ADD KEY `fk_commentaire_utiliateur` (`fk_id_utilisateur`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id_contact`),
  ADD KEY `fk_contact_utilisateur` (`fk_id_utilisateur`);

--
-- Indexes for table `coordonnees`
--
ALTER TABLE `coordonnees`
  ADD PRIMARY KEY (`id_coordonnees`);

--
-- Indexes for table `details_commande`
--
ALTER TABLE `details_commande`
  ADD PRIMARY KEY (`id_details_commande`),
  ADD KEY `fk_detail_commande_commande` (`fk_id_commande`),
  ADD KEY `fk_detail_commande_produit` (`fk_id_produit`);

--
-- Indexes for table `entree_en_stock`
--
ALTER TABLE `entree_en_stock`
  ADD PRIMARY KEY (`id_entree_en_stock`),
  ADD KEY `fk_entree_en_stock_fournisseur` (`fk_id_fournisseur`),
  ADD KEY `fk_entre_en_stock_produit` (`fk_id_produit`);

--
-- Indexes for table `favori`
--
ALTER TABLE `favori`
  ADD PRIMARY KEY (`id_favori`),
  ADD KEY `fk_favori_produit` (`fk_id_produit`),
  ADD KEY `fk_favori_utilisateur` (`fk_id_utilisateur`);

--
-- Indexes for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id_fournisseur`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id_image`),
  ADD KEY `fk_image_produit` (`fk_id_produit`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `fk_produit_sous_categorie` (`fk_id_sous_categorie`);

--
-- Indexes for table `recherche`
--
ALTER TABLE `recherche`
  ADD PRIMARY KEY (`id_recherche`),
  ADD KEY `fk_recherche_utilisateur` (`fk_id_utilisateur`);

--
-- Indexes for table `slide`
--
ALTER TABLE `slide`
  ADD PRIMARY KEY (`id_slide`);

--
-- Indexes for table `sous_categorie`
--
ALTER TABLE `sous_categorie`
  ADD PRIMARY KEY (`id_sous_categorie`),
  ADD KEY `fk_sous_categorie_categorie` (`fk_id_categorie`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id_utilisateur`);

--
-- Indexes for table `visite`
--
ALTER TABLE `visite`
  ADD PRIMARY KEY (`id_visite`),
  ADD KEY `fk_visite_produit` (`fk_id_produit`),
  ADD KEY `fk_visite_utilisateur` (`fk_id_utilisateur`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `id_administrateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `adresse_livraison`
--
ALTER TABLE `adresse_livraison`
  MODIFY `id_adresse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id_commentaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id_contact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `coordonnees`
--
ALTER TABLE `coordonnees`
  MODIFY `id_coordonnees` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `details_commande`
--
ALTER TABLE `details_commande`
  MODIFY `id_details_commande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `entree_en_stock`
--
ALTER TABLE `entree_en_stock`
  MODIFY `id_entree_en_stock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `favori`
--
ALTER TABLE `favori`
  MODIFY `id_favori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id_fournisseur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id_image` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `recherche`
--
ALTER TABLE `recherche`
  MODIFY `id_recherche` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `slide`
--
ALTER TABLE `slide`
  MODIFY `id_slide` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sous_categorie`
--
ALTER TABLE `sous_categorie`
  MODIFY `id_sous_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `visite`
--
ALTER TABLE `visite`
  MODIFY `id_visite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fk_commande_adresse` FOREIGN KEY (`fk_id_adresse`) REFERENCES `adresse_livraison` (`id_adresse`),
  ADD CONSTRAINT `fk_commande_utilisateur` FOREIGN KEY (`fk_id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Constraints for table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `fk_commentaire_produit` FOREIGN KEY (`fk_id_produit`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `fk_commentaire_utiliateur` FOREIGN KEY (`fk_id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `fk_contact_utilisateur` FOREIGN KEY (`fk_id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Constraints for table `details_commande`
--
ALTER TABLE `details_commande`
  ADD CONSTRAINT `fk_detail_commande_commande` FOREIGN KEY (`fk_id_commande`) REFERENCES `commande` (`id_commande`),
  ADD CONSTRAINT `fk_detail_commande_produit` FOREIGN KEY (`fk_id_produit`) REFERENCES `produit` (`id_produit`);

--
-- Constraints for table `entree_en_stock`
--
ALTER TABLE `entree_en_stock`
  ADD CONSTRAINT `fk_entre_en_stock_produit` FOREIGN KEY (`fk_id_produit`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `fk_entree_en_stock_fournisseur` FOREIGN KEY (`fk_id_fournisseur`) REFERENCES `fournisseur` (`id_fournisseur`);

--
-- Constraints for table `favori`
--
ALTER TABLE `favori`
  ADD CONSTRAINT `fk_favori_produit` FOREIGN KEY (`fk_id_produit`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `fk_favori_utilisateur` FOREIGN KEY (`fk_id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Constraints for table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `fk_image_produit` FOREIGN KEY (`fk_id_produit`) REFERENCES `produit` (`id_produit`);

--
-- Constraints for table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `fk_produit_sous_categorie` FOREIGN KEY (`fk_id_sous_categorie`) REFERENCES `sous_categorie` (`id_sous_categorie`);

--
-- Constraints for table `recherche`
--
ALTER TABLE `recherche`
  ADD CONSTRAINT `fk_recherche_utilisateur` FOREIGN KEY (`fk_id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Constraints for table `sous_categorie`
--
ALTER TABLE `sous_categorie`
  ADD CONSTRAINT `fk_sous_categorie_categorie` FOREIGN KEY (`fk_id_categorie`) REFERENCES `categorie` (`id_categorie`);

--
-- Constraints for table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `fk_visite_produit` FOREIGN KEY (`fk_id_produit`) REFERENCES `produit` (`id_produit`),
  ADD CONSTRAINT `fk_visite_utilisateur` FOREIGN KEY (`fk_id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
