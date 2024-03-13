CREATE TABLE recipes
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(55) NOT NULL,
    preparation TEXT,
    imageUrl    VARCHAR(255)
);

CREATE TABLE ingredients
(
    id        SERIAL PRIMARY KEY,
    recipe_id BIGINT,
    name      VARCHAR(55) NOT NULL,
    quantity  VARCHAR(55) NOT NULL,
    FOREIGN KEY (recipe_id) REFERENCES recipes (id)
);