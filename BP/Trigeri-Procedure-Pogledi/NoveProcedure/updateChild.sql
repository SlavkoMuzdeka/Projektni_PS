DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `updateChild`(
in idOsobe INT, in ime varchar(45), in prezime varchar(45), in jmbg varchar(13)
, in datumRodjenja Date, in imeOca varchar(45), in imeMajke varchar(45), in telMajke varchar(45), in telOca varchar(45),
in visina varchar(45), in tezina varchar(45), in grad varchar(45), in ulica varchar(45), in broj varchar(45),
in napomena varchar(250), in doc longblob, out rez boolean
)
BEGIN
	declare idAdr int default 0;
    declare num int default 0;
    select false into rez;
    if exists (select * from adresa a where a.Ulica = ulica AND a.Grad=grad AND a.Broj = broj) then
		select IdAdrese into idAdr  from adresa a where a.Ulica = ulica AND a.Grad=grad AND a.Broj = broj;
        else
			insert into adresa (Ulica, Grad, Broj) values (ulica, grad, broj);
			select last_insert_id() into idAdr;
            
        end if;
    
	UPDATE osoba o
    SET o.JMB = jmbg, o.Ime = ime, o.Prezime = prezime, o.DatumRodjenja = datumRodjenja, o.ADRESA_IdAdrese = idAdr
    WHERE o.IdOsobe = idOsobe;
    
    UPDATE dijete d
    SET d.Visina = visina, d.Tezina = tezina, d.ImeOca = imeOca, d.ImeMajke = imeMajke, d.BrojTelefonaOca = telOCa, d.BrojTelefonaMajke = telMajke
    WHERE d.OSOBA_IdOsobe = idOsobe;
    
    select true into rez;
    
END
DELIMITER $$