DELIMITER $$
CREATE  PROCEDURE `dodajDijete`(in ime varchar(45), in prezime varchar(45), in jmbg varchar(13)
, in datumRodjenja Date, in imeOca varchar(45), in imeMajke varchar(45), in telMajke varchar(45), in telOca varchar(45),
in visina varchar(45), in tezina varchar(45), in grad varchar(45), in ulica varchar(45), in broj varchar(45),
in napomena varchar(250), out rez boolean)

BEGIN

	declare id int default 0;
    declare idDijete int default 0;
    if not exists (select * from adresa a where a.Grad=grad and a.Ulica=ulica and a.Broj=broj) then
		insert into adresa (Ulica, Grad, Broj)
		values (ulica, grad, broj);
        select max(IdAdrese) into id from adresa;
	else
		select IdAdrese into id from adresa a where a.Grad=grad and a.Ulica=ulica and a.Broj=broj;
	end if;
    
    insert into osoba (JMB, Ime, Prezime, DatumRodjenja, ADRESA_IdAdrese)
    values (jmbg, ime, prezime, datumRodjenja, id);
	
    select max(IdOsobe) into idDijete from osoba;
    
    insert into dijete 
    values(idDijete, visina, tezina, imeOca, imeMajke, telOca, telMajke, false);
    
    select true into rez;
    
END$$
DELIMITER ;