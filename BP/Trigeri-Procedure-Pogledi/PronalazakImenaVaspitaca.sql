 CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `pronadji_ime_vaspitaca` AS
    SELECT 
        `o`.`Ime` AS `Ime`,
        `o`.`Prezime` AS `Prezime`,
        `v`.`KorisnickoIme` AS `KorisnickoIme`,
        `v`.`Lozinka` AS `Lozinka`
    FROM
        (`vaspitac` `v`
        JOIN `osoba` `o` ON ((`o`.`IdOsobe` = `v`.`OSOBA_IdOsobe`)));