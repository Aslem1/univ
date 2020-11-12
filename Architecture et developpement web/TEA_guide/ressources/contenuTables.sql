-- --------------------------------------------------------
--
-- Contenu de la table `article`
--
-- --------------------------------------------------------

INSERT INTO `article` (`id_article`, `id_categorie`, `designation`, `prix`, `tva`, `description`, `img_article`) VALUES
(22, 4, 'ADVANCED CHARACTER ANIMATION WITH HALF-LIFE 2 DVD', 49.95, 19.6, 'Teaches how to "Evolve Your Character " by focusing on bringing your character to life by animating or applying motion capture data to your own custom design characters within Half-Life', 'images/magasin/NoesisCharAnim.jpg'),
(20, 4, 'Real-time Character Animation', 39.95, 19.6, 'his DVD teaches you how to "activate your Character" by demonstrating techniques used by professional animators.\r\n\r\nDVD topics covered include: animation clips & sequences, animation blending, custom parameters, custom parameters, linked parameters, animating poses, device capture techniques, and real-time shadows.', 'images/magasin/NoesisRTCharacterAnimation.jpg'),
(21, 4, 'Intro to Source Vehicle Programming', 49.95, 19.6, 'Part of the Noesis Interactive MOD Your World training series, introduces you to the basic functions and methodologies of programming in the Source Engine.\r\n\r\nDVD topics covered include: Setting up your development environment. Installing a Version Control System. Overview of Source programming conventions. Creating new classes. Interfacing with GUI elements. Creating thrusters and adding enhancements. Integrating models & animations.', 'images/magasin/NoesisIntroSrcVehicleProgramming.jpg'),
(19, 4, 'Source Machinima Choreography', 49.95, 19.6, 'Direct a full range of digital characters and creatures using Valve''s Source', 'images/magasin/NoesisSrcMachinimaChoreography.jpg'),
(18, 3, 'DAY OF DEFEAT POSTER', 6.95, 19.6, 'Folded, four-color glossy, 18" x 24"', 'images/magasin/DoDPoster.jpg'),
(17, 3, 'HALF-LIFE 2: EPISODE ONE POSTER', 9.95, 19.6, 'Rolled, four-color glossy, 18" x 24"', 'images/magasin/HL2EP1Poster.jpg'),
(16, 3, 'HALF-LIFE 2: EPISODE TWO POSTER', 9.95, 19.6, 'Four-color glossy, 18" x 24".', 'images/magasin/HL2EP202poster.jpg'),
(14, 2, 'Half-Life 2 D0G Mousepad', 12.95, 19.6, 'Precision surface with fine micro grid for perfect mouse operations.', 'images/magasin/HL2DOGMousepad.jpg'),
(15, 3, 'Left 4 Dead Hand Poster', 9.95, 19.6, 'Left 4 Dead Hand, 18" x 24" rolled poster.', 'images/magasin/L4DPoster.jpg'),
(12, 2, 'Left 4 Dead Mousepad', 12.95, 19.6, 'Precision surface with fine micro grid for perfect mouse operations.', 'images/magasin/L4DMousepad.jpg'),
(10, 1, 'HALF-LIFE 2 SHIRT', 19.99, 19.6, 'Hanes', 'images/magasin/HL2Shirt.jpg'),
(11, 2, 'Counter-Strike: Source Mousepad (Yellow)', 12.95, 19.6, 'Precision surface with fine micro grid for perfect mouse operations.', 'images/magasin/CSSMousepad-YELLOW.jpg'),
(13, 2, 'Team Fortress 2 Red Team Mousepad', 12.95, 19.6, 'Precision surface with fine micro grid for perfect mouse operations.', 'images/magasin/TF2RedTeamMousepad.jpg'),
(8, 1, 'COUNTER-STRIKE SHIRT', 18.95, 19.6, 'Navy. 100% Cotton tee with embroidered Counter-Strike logo in white and yellow.', 'images/magasin/CSShirt.jpg'),
(9, 1, 'HALF-LIFE 2 GOOD D0G SHIRT', 19.99, 19.6, 'Black Hanes', 'images/magasin/GoodD0gShirt.jpg'),
(2, 1, 'LEFT 4 DEAD DISTRESS-STYLED CAP', 14.95, 19.6, '100% cotton unstructured 6-panel construction. Enzyme-washed for a worn, apocalyptically-distressed look. One size fits all with metal d-ring slider buckle with hide-away strap closure.', 'images/magasin/L4DHat.jpg'),
(6, 1, 'PORTAL SHIRT', 19.99, 19.6, 'Black American Apparel', 'images/magasin/PortalShirt.jpg'),
(7, 1, 'HALF-LIFE 2 DEATHMATCH LONG-SLEEVE SHIRT', 24.95, 19.6, 'Long-Sleeve Gildan', 'images/magasin/HL2DMLSShirt.jpg'),
(3, 1, 'TEAM FORTRESS 2 HAT', 14.95, 19.6, '100% cotton twill with 6-panel construction. Low profile. Goldenrod Team Fortress 2 embroidery . One size fits all with Velcro enclosure.', 'images/magasin/TF2Hat.jpg'),
(4, 1, 'HALF-LIFE 2 HAT', 14.95, 19.6, '100% Black brushed cotton twill with reflective details on bill and the back strap. Low profile with the Half-Life', 'images/magasin/HL2Hat.jpg'),
(5, 1, 'LEFT 4 DEAD LONG-SLEEVE TEE', 24.95, 19.6, 'Jet-black 4.3-ounce, 100% ring-spun combed cotton District Threads"! t-shirt with Left 4 Dead logotype screen printed on upper left chest. Features a 40-singles fine knit perfect-weight cotton that''s not too sheer, with a relaxed drape and a comfortable stretch. Lightweight and layerable.', 'images/magasin/L4DShirt.jpg'),
(23, 4, '3D CONTENT / CREATION WITH XSI DVD', 39.95, 5.5, 'Part one of the MOD Your World training series from Noesis Interactive, focuses on teaching how to "Build Your Character". Learn the nuts and bolts of the SOFTIMAGE|XSI interface, polygon modeling, texture application, generate props from scratch, and follow step-by-step instructions for creating biped characters. The DVD covers the basics of SOFTIMAGE|XSI 3D software including 3D layout, modeling, texturing, prop and character modeling and provides you with all the short cuts and tips.', 'images/magasin/Noesis01.jpg');

-- --------------------------------------------------------
--
-- Contenu de la table `categorie`
--
-- --------------------------------------------------------
INSERT INTO `categorie` (`id_categorie`, `nom`) VALUES
(1, 'Vetements'),
(2, 'Accessoires'),
(3, 'Posters'),
(4, 'DVD');