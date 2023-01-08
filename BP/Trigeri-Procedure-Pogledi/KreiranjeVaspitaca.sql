CREATE DEFINER=`root`@`localhost` PROCEDURE `create_vaspitac`(
	in jmb char(13),
	   ime varchar(50),
       prezime varchar(50),
       datumRodjenja DATE,
       ulica varchar(100),
       grad varchar(100),
       brojUlice INT,
       korisnickoIme varchar(50),
       lozinka varchar(50),
       dokumentHigijenskiTest LONGBLOB,
       dokumentLjekarskoUvjerenje LONGBLOB,
	out je_kreiran bool
)
begin
	declare id_adrese int default 0;
    declare id_osobe int default 0;
    select false into je_kreiran;
    
    if not exists (select * from adresa a where a.Grad=grad and a.Ulica=ulica and a.Broj=brojUlice) then
		insert into adresa (Ulica, Grad, Broj) values (ulica, grad, brojUlice);
        select LAST_INSERT_ID() into id_adrese;
	else
		select IdAdrese into id_adrese from adresa a where a.Grad=grad and a.Ulica=ulica and a.Broj=brojUlice;
	end if;
    
    insert into osoba (JMB, Ime, Prezime, DatumRodjenja, ADRESA_IdAdrese) values (jmb, ime, prezime, datumRodjenja, id_adrese);
    select LAST_INSERT_ID() into id_osobe;
    
    insert into vaspitac values (id_osobe, korisnickoIme, lozinka);
    
    insert into ljekarsko_uvjerenje(VASPITAC_OSOBA_IdOsobe, DIJETE_OSOBA_IdOsobe, Dokument) values (id_osobe, null, dokumentLjekarskoUvjerenje);
	insert into higijenski_test(VASPITAC_OSOBA_IdOsobe, Dokument) values (id_osobe, dokumentHigijenskiTest);
    
    select true into je_kreiran;
end