-- --------------------------------------------------------

-- 
-- Structure de la table `client`

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id_client` int(10) NOT NULL auto_increment,
  `email` varchar(64) NOT NULL default '',
  `mot_de_passe` varchar(32) NOT NULL default '',
  `civilite` varchar(32) NOT NULL default '',
  `nom` varchar(64) NOT NULL default '',
  `prenom` varchar(64) NOT NULL default '',
  `adresse` varchar(255) NOT NULL default '',
  `code_postal` int(5) NOT NULL default '0',
  `ville` varchar(64) NOT NULL default '',
  `pays` varchar(32) NOT NULL default '',
  `telephone` int(10) NOT NULL default '0',
  `img_client` varchar(64) NOT NULL default 'images/default_logo_user.png',
  PRIMARY KEY  (`id_client`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;
