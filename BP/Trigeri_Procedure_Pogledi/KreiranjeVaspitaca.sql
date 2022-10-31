use projektni_ps;

delimiter $$
create procedure create_vaspitac(
	in jmb char(13),
	   ime varchar(50),
       prezime varchar(50),
       datumRodjenja DATE,
       ulica varchar(100),
       grad varchar(100),
       brojUlice INT,
       plata INT,
       korisnickoIme varchar(50),
       lozinka varchar(50),
       dokumentHigijenskiTest LONGBLOB,
       dokumentLjekarskoUvjerenje LONGBLOB,
	out je_kreiran bool
)
begin
	declare idA, idO INT;
    set je_kreiran = false;
    
    insert into adresa(Ulica,Grad,Broj) values (ulica, grad, brojUlice);
    select LAST_INSERT_ID() into idA;
    
    insert into osoba(JMB,Ime,Prezime,DatumRodjenja,ADRESA_IdAdrese) values (jmb, ime, prezime, datumRodjenja, idA);
    select LAST_INSERT_ID() into idO;
    
    insert into vaspitac values (idO, plata, korisnickoIme, lozinka);

	insert into ljekarsko_uvjerenje(VASPITAC_OSOBA_IdOsobe, DIJETE_OSOBA_IdOsobe, Dokument) values (idO, null, dokumentLjekarskoUvjerenje);
	insert into higijenski_test(VASPITAC_OSOBA_IdOsobe, Dokument) values (idO, dokumentHigijenskiTest);

	set je_kreiran = true;
end$$
delimiter ;
