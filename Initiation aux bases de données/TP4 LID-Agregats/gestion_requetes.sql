/* 1.Donnez les numéros des interventions avec le montant (hors taxes) pour la totalité des pièces remplacées (alias: piecesremp). */
SELECT 
	r.nointerv,
	SUM (r.qteremplacee * p.prixht) AS piecesremp
FROM 
	remplacements r
	JOIN produits p ON r.reference = p.reference
GROUP BY
	r.nointerv
ORDER BY r.nointerv ASC;

/* 2. Donnez le montant total de la main d’oeuvre (alias maindoeuvre) de chaque facture (il s’agit du temps passé pour chaque intervention, 
multiplié par le taux horaire de l’intervenant).*/
SELECT
	i.nofacture,
	SUM (i.temps * th.txhoraire) AS maindoeuvre
FROM
	interventions i
	JOIN tauxhoraire th ON i.codetaux = th.codetaux
GROUP BY
	i.nofacture
ORDER BY i.nofacture ASC;

/* 3. Donnez le montant des pièces remplacées (alias piecesremplacees) pour chaque facture (le montant total des pièces remplacées lors de toutes les
interventions liées à une facture). */
SELECT 
	i.nofacture,
	SUM (r.qteremplacee * p.prixht) AS piecesremp
FROM 
	remplacements r
	JOIN produits p ON r.reference = p.reference
	JOIN interventions i ON r.nointerv = i.nointerv
GROUP BY
	i.nofacture
ORDER BY i.nofacture ASC;
