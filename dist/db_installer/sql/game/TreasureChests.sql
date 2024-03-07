CREATE TABLE TreasureChests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    level INT NOT NULL,
    type VARCHAR(50) NOT NULL,
    drop_items TEXT,
    respawn_time INT NOT NULL,
    UNIQUE KEY (level, type)
);