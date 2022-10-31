CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `prikaz_vaspitaca` AS
    SELECT 
        `o`.`JMB` AS `JMB`,
        `o`.`Ime` AS `Ime`,
        `o`.`Prezime` AS `Prezime`,
        `o`.`DatumRodjenja` AS `DatumRodjenja`,
        `a`.`Ulica` AS `Ulica`,
        `a`.`Grad` AS `Grad`,
        `a`.`Broj` AS `Broj`
    FROM
        ((`vaspitac` `v`
        JOIN `osoba` `o` ON ((`o`.`IdOsobe` = `v`.`OSOBA_IdOsobe`)))
        JOIN `adresa` `a` ON ((`a`.`IdAdrese` = `o`.`ADRESA_IdAdrese`)));