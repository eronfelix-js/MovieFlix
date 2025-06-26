CREATE TABLE TB_Movie(
    id SERIAL PRIMARY KEY,
    tittle VARCHAR(255) NOT NULL,
    description text,
    rating numeric,
    created_at timestamp,
    updated_at timestamp
)