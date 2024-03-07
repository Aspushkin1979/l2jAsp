CREATE TABLE DropItems (
    id INT AUTO_INCREMENT PRIMARY KEY,
    chest_id INT NOT NULL,
    item_name VARCHAR(100) NOT NULL,
    item_type VARCHAR(50) NOT NULL,
    item_description TEXT,
    FOREIGN KEY (chest_id) REFERENCES TreasureChests(id)
);