-- Création de la table des blocs
CREATE TABLE IF NOT EXISTS  bloc (
    id INT AUTO_INCREMENT PRIMARY KEY,
    start_bloc date,
    min_quantity_mw NUMERIC, 
    id_offre INT
);

-- Création de la table des parks
CREATE TABLE IF NOT EXISTS park (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    type VARCHAR(100)
);

-- Création de la table de jonction pour la relation many-to-many
CREATE TABLE IF NOT EXISTS  bloc_park (
    id_bloc INT,
    id_park INT,
    quantity_mw NUMERIC,
    PRIMARY KEY (id_bloc, id_park),
    FOREIGN KEY (id_bloc) REFERENCES bloc(id),
    FOREIGN KEY (id_park) REFERENCES park(id)
);
CREATE TABLE IF NOT EXISTS  marche (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    date date
);
CREATE TABLE IF NOT EXISTS  offre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marche_id INT,
    date date
);
