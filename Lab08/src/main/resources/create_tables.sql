CREATE SEQUENCE author_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE TABLE Authors (
    author_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Trigger to automatically populate author_id using the sequence
CREATE OR REPLACE TRIGGER author_id_trigger
BEFORE INSERT ON Authors
FOR EACH ROW
BEGIN
    SELECT author_seq.NEXTVAL INTO :new.author_id FROM dual;
END;
/

CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    language VARCHAR(50),
    publication_date DATE,
    num_pages INT,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES Authors(author_id)
);

CREATE TABLE Genres (
    genre_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);


SELECT * FROM BOOKS;
SELECT * FROM AUTHORS;

DELETE FROM BOOKS;
DELETE FROM AUTHORS;
