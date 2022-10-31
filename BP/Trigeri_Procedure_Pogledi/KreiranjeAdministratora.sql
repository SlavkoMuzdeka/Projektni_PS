use projektni_ps;

delimiter $$
create procedure create_administrator(
	in  jmb varchar(100),
		ime varchar(100),
        prezime varchar(100),
        datumRodjenja DATE,
        ulica varchar(100),
        grad varchar(100),
        broj_ulice INT,
        korisnickoIme varchar(100),
        lozinka varchar(1000),
	out kreiranStatus bool
)
BEGIN
	declare idA, idO INT;
    set kreiranStatus = false;
    
    insert into adresa(Ulica,Grad,Broj) values(ulica, grad, broj_ulice);
    select LAST_INSERT_ID() into idA;
    
     insert into osoba(JMB,Ime,Prezime,DatumRodjenja,ADRESA_IdAdrese) values(jmb, ime, prezime, datumRodjenja, idA);
     select LAST_INSERT_ID() into idO;
     
     insert into administrator values(idO, korisnickoIme, lozinka);
	 set kreiranStatus = true;
END$$
delimiter ;

call create_administrator('1234567890123', 'Marko', 'Markovic', '1991-10-10', 'Patre', 'Banjaluka', 10, 'admin', 'admin', @vrijednost);
select @vrijednost