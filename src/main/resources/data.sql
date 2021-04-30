INSERT INTO person(id, firstname, lastname, birthday, phone)
VALUES
       (1, 'Elaine', 'Brobst', '1979/1/16', '727-771-0067'),
       (2, 'Shawna', 'Scott', '1967/12/22', '303-914-6493'),
       (3, 'Hector', 'Gleason', '1965/5/26', '856-736-6884'),
       (4, 'Warren', 'Hawkins', '1967/4/8', '614-444-8115');

INSERT INTO address(country, zipcode, city, street, person_id)
VALUES
       ('USA', 34683, 'St George', '2999  County Line Road', 1),
       ('USA', 80227, 'Lakewood', '3944  Roy Alley', 2),
       ('USA', 32712, 'ADOPKA', '3388  Prospect Street', 3),
       ('USA', 61910, 'ARCOLA', '2537  James Martin Circle', 4);