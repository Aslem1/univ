/*Exercice 4 - Identifiant de tous les clients ayant un montant de paiement compris entre 1 et 2 euros*/
SELECT customer.customer_id
FROM customer
JOIN payment ON customer.customer_id = payment.customer_id
WHERE amount BETWEEN 1 AND 2;


/*Exercice 5 - Locations (tous les attributs) qui ont été retournées moins de 24h après leur emprunt*/
SELECT rental
FROM rental
WHERE rental_date >= return_date - INTERVAL '24 HOURS'
